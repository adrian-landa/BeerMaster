package mx.albo.beermaster.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.datasource.BeerDataSource
import mx.albo.beermaster.data.datasource.factory.BeerDataSourceFactory
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.utils.base.BaseViewModel

class HomeViewModel(app: Application) : BaseViewModel(app) {
    val items: LiveData<PagedList<Beer>>
    val error: LiveData<Boolean>

    init {
        val factory = BeerDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(Web.PAGING_ITEMS)
            .build()
        items = LivePagedListBuilder(factory, config).build()
        error = Transformations.switchMap(factory.liveSource, BeerDataSource::errorStatus)
    }

    fun refresh() {
        items.value?.dataSource?.invalidate()
    }
}