package mx.albo.beermaster.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_beer.view.*
import mx.albo.beermaster.R
import mx.albo.beermaster.constants.App
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.utils.getViewModel

class BeerDetailFragment : Fragment() {

    private val viewmodel: HomeViewModel by lazy { getViewModel { HomeViewModel(app = activity?.application!!) } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view ?: super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val args = arguments
        if (args != null) {
            if (args.containsKey(App.KEY_BEER)) {
                val beer: Beer? = args.getParcelable(App.KEY_BEER)
                beer?.let {
                    Glide.with(this)
                        .load(beer.imageUrl)
                        .apply(RequestOptions.circleCropTransform())
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_placeholder_beer).error(R.drawable.ic_placeholder_beer))
                        .into(imgBeerDetail)

                    val ctx = context
                    if (ctx != null) {
                        val na = ctx.getString(R.string.label_na)
                        val name = beer.name
                        tvBeerName.text = ctx.getString(R.string.label_beer_name, name)
                        val tagline = beer.tagline ?: na
                        tvBeerTagline.text = ctx.getString(R.string.label_beer_tagline, tagline)
                        val brewed = beer.firstBrewed ?: na
                        tvBeerBrewed.text = ctx.getString(R.string.label_beer_brewed_date, brewed)
                        val food = beer.foodPairing
                        val tmp = food.fold("") { acc, item -> "$acc,$item" }
                        val pair = if (food.isNotEmpty()) tmp else na
                        tvBeerFood.text = ctx.getString(R.string.label_beer_food_pairing, pair)
                        val description = beer.description ?: na
                        tvBeerDescription.text =
                            ctx.getString(R.string.label_beer_description, description)
                    }
                }

            }
        }
    }
}