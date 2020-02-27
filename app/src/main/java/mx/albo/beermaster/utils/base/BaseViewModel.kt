package mx.albo.beermaster.utils.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class BaseViewModel(app: Application) : AndroidViewModel(app){
    private val job = Job()
    protected val mainThread = CoroutineScope(job + Dispatchers.Main)
    protected val ioThread = CoroutineScope(job + Dispatchers.IO)
}