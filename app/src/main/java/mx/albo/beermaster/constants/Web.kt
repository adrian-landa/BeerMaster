package mx.albo.beermaster.constants

object Web {
    const val LOG_API = "logAPI"
    const val TIMEOUT_MS: Long = 25000
    const val PAGING_ITEMS = 15

    val URL_BASE: String ="https://api.punkapi.com"
    private const val VERSION: String = "/v2"
    const val EP_BEER = "/beers"


    const val URL_SERVICE_BEER: String = "$VERSION$EP_BEER"

    /**
     * Consts used for params in requests
     */
    const val PARAM_PAGE: String = "page"
    const val PARAM_ITEM_PER_PAGE: String = "per_page"

}