package mx.albo.beermaster.data.datasource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.datasource.BeerDataSource
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.data.remote.api.BeerAPI
import mx.albo.beermaster.utils.retrofit.RetrofitFactory

class BeerDataSourceFactory : DataSource.Factory<Int, Beer>() {
    val liveSource = MutableLiveData<BeerDataSource>()

    override fun create(): DataSource<Int, Beer> {
        val api = RetrofitFactory.makeService(Web.URL_BASE, BeerAPI::class.java)
        val composite = CompositeDisposable()
        val source = BeerDataSource(api = api, composite = composite)
        liveSource.postValue(source)
        return source
    }

}