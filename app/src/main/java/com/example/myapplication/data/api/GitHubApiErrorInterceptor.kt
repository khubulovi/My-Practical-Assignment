package com.example.myapplication.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.lang.RuntimeException

object GitHubApiErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        try {
            chain.proceed(chain.request())
        } catch (error: Throwable) {
            throw when (error) {
                is IOException -> RuntimeException("Error don't have connection")
                else -> error
            }
        }
}
