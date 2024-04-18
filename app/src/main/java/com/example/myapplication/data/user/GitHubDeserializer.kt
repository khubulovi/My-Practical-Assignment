package com.example.myapplication.data.user

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class GitHubDeserializer : JsonDeserializer<GitHubUser.Type> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GitHubUser.Type {
        return when (json?.asString?.lowercase()) {
            "user" -> GitHubUser.Type.USER
            "administrator" -> GitHubUser.Type.ADMIMINISTRATOR
            else -> GitHubUser.Type.UNKHNOWN
        }
    }
}