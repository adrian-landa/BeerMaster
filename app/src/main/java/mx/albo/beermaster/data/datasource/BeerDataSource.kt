package mx.albo.beermaster.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.albo.beermaster.constants.Web
import mx.albo.beermaster.data.entity.Beer
import mx.albo.beermaster.data.remote.api.BeerAPI

class BeerDataSource(private val api: BeerAPI, private val composite: CompositeDisposable) :
    PageKeyedDataSource<Int, Beer>() {

    val errorStatus: MutableLiveData<Boolean> = MutableLiveData()
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Beer>
    ) {
        composite.add(
            api.getBeers(page = 1, items = Web.PAGING_ITEMS)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        errorStatus.postValue(false)
                        callback.onResult(response, null, 2)
                    },
                    { error ->
                        errorStatus.postValue(true)
                        Log.i("TAG", error.toString())
                    }
                )

        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
        val page = params.key
        composite.add(
            api.getBeers(page = page, items = Web.PAGING_ITEMS)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        errorStatus.postValue(false)
                        Log.i("TAG", response.toString())
                        callback.onResult(response, page + 1)
                    },
                    { error ->
                        errorStatus.postValue(true)
                        Log.i("TAG", error.toString())
                    }
                )

        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
    }
}