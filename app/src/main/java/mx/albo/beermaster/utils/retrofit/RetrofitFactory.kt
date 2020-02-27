package mx.albo.beermaster.utils.retrofit

import android.util.Log
import mx.albo.beermaster.constants.Web
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {


    private fun interceptHeader(): Interceptor {
        return Interceptor { chain ->
            chain.proceed(chain.request())
        }
    }

    private fun httpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.i(Web.LOG_API, it)
        })
        logger.level = HttpLoggingInterceptor.Level.BODY
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(interceptHeader())
            .readTimeout(Web.TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .writeTimeout(Web.TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .connectTimeout(Web.TIMEOUT_MS, TimeUnit.MILLISECONDS)
        return okHttp.build()
    }


    fun <T> makeService(urlBase: String, serviceClass: Class<T>): T {
        val builder = Retrofit.Builder()
            .baseUrl(urlBase)
            .client(httpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return builder.create(serviceClass)
    }

}