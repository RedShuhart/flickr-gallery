package com.example.flickrgallery.core.api

import com.example.flickrgallery.core.api.models.FlickrFeed
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("https://api.flickr.com/services/feeds/photos_public.gne")
    fun getFeed(
        @Query("format")  format: String = "json",
        @Query("tags")  tags: String = "sunset"
    ): Observable<FlickrFeed>
}