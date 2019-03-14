package com.iyushchuk.flickrgallery.core.api

import com.iyushchuk.flickrgallery.core.api.models.FlickrFeed
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("services/feeds/photos_public.gne")
    fun getFeed(
        @Query("format")  format: String = "json",
        @Query("tags")  tags: String = "",
        @Query("nojsoncallback")  nojsoncallback: String = "true"
    ): Observable<FlickrFeed>
}

const val FLICKR_URL = "https://api.flickr.com/"