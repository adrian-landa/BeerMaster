package mx.albo.beermaster.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.samani.management.viewmodels.ViewModelFactory

inline fun <reified T : ViewModel> Fragment.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(this).get(T::class.java)
    else
        ViewModelProvider(this, ViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(this).get(T::class.java)
    else
        ViewModelProvider(this, ViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) ViewModelProvider(this).get(T::class.java)
    else ViewModelProvider(this, ViewModelFactory(creator)).get(T::class.java)
}
