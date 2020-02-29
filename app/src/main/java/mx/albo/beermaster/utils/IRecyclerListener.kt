package mx.albo.beermaster.utils


interface IRecyclerListener<T> {
    fun onItemClick(item: T)
}