package mx.albo.beermaster.data.datasource.factory

import androidx.paging.DataSource
import mx.albo.beermaster.data.entity.Beer

class BeerDataSourceFactory: DataSource.Factory<Int,Beer>(){
    override fun create(): DataSource<Int, Beer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}