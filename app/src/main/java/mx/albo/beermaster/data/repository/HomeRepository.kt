package mx.albo.beermaster.data.repository

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.data.entity.Ingredients
import mx.albo.beermaster.data.remote.api.BeerAPI
import mx.albo.beermaster.utils.retrofit.RetrofitFactory
import java.util.*

class HomeRepository(val api: BeerAPI) {
    companion object {
        @Volatile
        private var instance: HomeRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                val api = RetrofitFactory.makeService(Web.URL_BASE, BeerAPI::class.java)

                instance ?: HomeRepository(api).also {
                    instance = it
                }
            }
    }

    suspend fun getBeers(page: Int, elements: Int): Flowable<List<Beer>> {
        return api.getBeers()
    }
}