package mx.albo.beermaster.data.datasource

import androidx.paging.PageKeyedDataSource
import mx.albo.beermaster.data.entity.Beer

class BeerDataSource:PageKeyedDataSource<Int,Beer>(){
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Beer>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}