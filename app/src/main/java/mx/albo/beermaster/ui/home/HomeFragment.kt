package mx.albo.beermaster.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import mx.albo.beermaster.R
import mx.albo.beermaster.constants.App
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.ui.adapters.BeerAdapter
import mx.albo.beermaster.ui.adapters.decorators.SpaceDecoration
import mx.albo.beermaster.utils.IRecyclerListener
import mx.albo.beermaster.utils.getViewModel

class HomeFragment : Fragment(), IRecyclerListener<Beer> {

    private val viewmodel: HomeViewModel by lazy { getViewModel { HomeViewModel(app = activity?.application!!) } }
    private val decorator: RecyclerView.ItemDecoration by lazy {
        val dimen = context?.resources?.getDimension(R.dimen.dimen_xshort)?.toInt() ?: 0
        SpaceDecoration(dimen)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view ?: super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        setListener()
    }

    private fun setData() {
        val adapter = BeerAdapter(this)
        beerRecycler.layoutManager = LinearLayoutManager(context)
        beerRecycler.adapter = adapter
        beerRecycler.addItemDecoration(decorator)
        viewmodel.items.observe(this, Observer { items ->
            refreshLayout.isRefreshing = false
            progress.visibility = View.GONE
            adapter.submitList(items)
        })
        viewmodel.error.observe(this, Observer { error ->
            llSomethingWrong.visibility = if (error) View.VISIBLE else View.GONE
        })
    }

    private fun setListener() {
        refreshLayout.setOnRefreshListener {
            progress.visibility = View.VISIBLE
            viewmodel.refresh()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        beerRecycler?.removeItemDecoration(decorator)
    }

    override fun onItemClick(item: Beer) {
        val arguments = Bundle()
        arguments.putParcelable(App.KEY_BEER, item)
        arguments.putString(App.KEY_TITLE, item.name)
        view?.findNavController()?.navigate(R.id.action_detail, arguments)
    }
}
