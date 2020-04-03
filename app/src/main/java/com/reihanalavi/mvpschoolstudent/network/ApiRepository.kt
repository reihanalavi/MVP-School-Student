package com.reihanalavi.mvpschoolstudent.network

import com.reihanalavi.mvpschoolstudent.models.Popular
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {

    @GET("3/movie/popular?")
    fun getPopular(@Query ("api_key") api: String,
                   @Query ("language") lang: String,
                   @Query ("page") page: String): Observable<ArrayList<Popular>>

}