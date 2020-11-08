package com.rayray.madlevel6example.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rayray.madlevel6example.api.TriviaApi
import com.rayray.madlevel6example.model.Trivia
import com.rayray.madlevel6example.service.TriviaApiService
import kotlinx.coroutines.withTimeout

class TriviaRepository {
    private val triviaApiService: TriviaApiService = TriviaApi.createApi()

    private val _trivia: MutableLiveData<Trivia> = MutableLiveData()

    val trivia: LiveData<Trivia> get() = _trivia


    suspend fun getRandomNumberTrivia(){
        try{
            val result = withTimeout(5_000){
                triviaApiService.getRandomNumberTrivia()
            }
            _trivia.value = result
        }catch (error: Throwable){
            throw TriviaRefreshError("Unable to refresh trivia", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}