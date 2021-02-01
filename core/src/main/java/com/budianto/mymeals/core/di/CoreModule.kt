package com.budianto.mymeals.core.di

import androidx.room.Room
import com.budianto.mymeals.core.data.MealRepository
import com.budianto.mymeals.core.data.source.local.LocalDataSouce
import com.budianto.mymeals.core.data.source.local.room.MealDatabase
import com.budianto.mymeals.core.data.source.remote.RemoteDataSource
import com.budianto.mymeals.core.data.source.remote.network.ApiService
import com.budianto.mymeals.core.domain.repository.IMealRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://themealdb.com/"

val databaseModule = module{
    factory { get<MealDatabase>().mealDao() }

    single {
        Room.databaseBuilder(androidContext(),
        MealDatabase::class.java, "Meal.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}


val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}


val repositoryModule = module {
    single { LocalDataSouce(get()) }
    single { RemoteDataSource(get()) }

    single<IMealRepository> { MealRepository(get(), get()) }
}