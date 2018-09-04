package root.com.rxretrofitmvp.Contract

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import root.com.rxretrofitmvp.Model.PlaceDataList

interface PlaceInterface {

    @GET("getplaces?location=manila")
    fun myJSON(): Observable<PlaceDataList>

    companion object {
        fun create(): PlaceInterface {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://sampleapi.us.openode.io/")
                    .build()

            return retrofit.create(PlaceInterface::class.java)
        }
    }
}