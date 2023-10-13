package com.example.kmptemplate.remote

import io.ktor.client.HttpClient

interface ApiClient{
    // suspend fun signatures
}

class ApiClientImpl(private val httpClient: HttpClient): ApiClient{
    // suspend fun implementations
}