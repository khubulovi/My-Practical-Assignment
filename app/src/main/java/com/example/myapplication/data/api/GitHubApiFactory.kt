package com.example.myapplication.data.api

import com.example.myapplication.data.user.GitHubDeserializer
import com.example.myapplication.data.user.GitHubUser
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GitHubApiFactory {

    private val gSon: Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(GitHubUser.Type::class.java, GitHubDeserializer())
            .create()

    private val gitHubApi: GitHubApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(GitHubApiInterceptor)
                    .addInterceptor(GitHubApiErrorInterceptor)
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .build()
            .create(GitHubApi::class.java)
    }
    fun create() : GitHubApi = gitHubApi
}