package mx.albo.beermaster.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_beer.view.*
import mx.albo.beermaster.R
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.utils.IRecyclerListener

class BeerAdapter(val listener: IRecyclerListener<Beer>? = null) :
    PagedListAdapter<Beer, BeerAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beer, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { beer ->
            holder.itemView.setOnClickListener { listener?.onItemClick(beer) }
            Glide.with(holder.itemView)
                .load(beer.imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_placeholder_beer).error(R.drawable.ic_placeholder_beer))
                .into(holder.itemView.imgBeer)

            holder.itemView.tvBeerName.text = beer.name
            holder.itemView.tvBeerTagline.text = beer.tagline
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Beer>() {
            override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean =
                oldItem == newItem
        }
    }
}