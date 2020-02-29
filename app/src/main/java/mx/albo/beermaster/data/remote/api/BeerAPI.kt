package mx.albo.beermaster.data.remote.api

import io.reactivex.Flowable
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.entity.Beer
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerAPI {
    @GET(Web.URL_SERVICE_BEER)
    fun getBeers(@Query(Web.PARAM_PAGE) page: Int = 1,
                 @Query(Web.PARAM_ITEM_PER_PAGE) items: Int = Web.PAGING_ITEMS): Flowable<List<Beer>>

}