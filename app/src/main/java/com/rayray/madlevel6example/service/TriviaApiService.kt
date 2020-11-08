package com.rayray.madlevel6example.service

import com.rayray.madlevel6example.model.Trivia
import retrofit2.http.GET

interface TriviaApiService {

    @GET("/random/trivia?json")
    suspend fun getRandomNumberTrivia(): Trivia
}