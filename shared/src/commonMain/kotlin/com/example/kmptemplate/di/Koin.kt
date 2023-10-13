package com.example.kmptemplate.di

import com.example.kmptemplate.logger.AppLogger
import com.example.kmptemplate.logger.AppLoggerImpl
import com.example.kmptemplate.remote.ApiClient
import com.example.kmptemplate.remote.ApiClientImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()

        modules(
            apiModule,
            loggerModule,
            platformModule()
        )
    }

val loggerModule = module {
    single<AppLogger> { AppLoggerImpl() }
}

val apiModule = module {
    single<ApiClient> { ApiClientImpl(get()) }

    single {
        val appLogger: AppLogger = get()
        HttpClient {
            install(ContentNegotiation){
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    },
                    contentType = ContentType.Any
                )
            }
            install(Logging){
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        appLogger.d(message)
                    }

                }
            }
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}
fun KoinComponent.injectLogger(tag: String): Lazy<AppLogger> = inject { parametersOf(tag) }