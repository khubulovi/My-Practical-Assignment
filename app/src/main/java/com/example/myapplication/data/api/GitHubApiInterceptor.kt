package com.example.myapplication.data.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Credentials

object GitHubApiInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
         chain.proceed(
            chain.request()
                .newBuilder()
                .header("Autorization", Credentials.basic("GUTHUB_USER_NAME","GUTHUB_USER_PASSWORD"))
                .build()
        )
    }