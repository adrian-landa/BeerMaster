package mx.albo.beermaster.data.remote.api

import io.reactivex.Flowable
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.entity.Beer
import retrofit2.http.GET

interface BeerAPI {
    @GET(Web.URL_SERVICE_BEER)
    fun getBeers(): Flowable<List<Beer>>

}