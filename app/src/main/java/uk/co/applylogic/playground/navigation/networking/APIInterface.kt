package uk.co.applylogic.playground.navigation.networking

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by Golan Shay @golanshy on 26 June,2019
 */
interface APIInterface {
    @GET("/api/feed.json")
    fun getPopularBlogAsync(): Deferred<String>
}