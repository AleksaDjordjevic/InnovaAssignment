package com.aleksa.innovaassignment.di

import com.aleksa.innovaassignment.data.remote.GitHubApi
import com.aleksa.innovaassignment.data.repository.GitHubRepository
import com.aleksa.innovaassignment.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        )
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): GitHubApi = retrofit.create(GitHubApi::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: GitHubApi) =
        GitHubRepository(apiService)
}