package com.example.harrypotterapp.data.network.response

import com.example.harrypotterapp.data.ReposirotyImp
import com.example.harrypotterapp.data.network.DetailApiService
import com.example.harrypotterapp.domain.model.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetwotkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/characters/house/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun ProvideDetailApiService(retrofit: Retrofit):DetailApiService{
        return retrofit.create(DetailApiService::class.java)
    }
    @Provides
    fun provideRepository(apiService: DetailApiService): Repository {
        return ReposirotyImp(apiService)
    }
}