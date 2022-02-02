package kg.asylbekov.dagger4.di

import dagger.Module
import dagger.Provides
import kg.asylbekov.data.api.ApiUser
import kg.asylbekov.data.repository.DataRepositoryImpl
import kg.asylbekov.domain.repository.DataRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val baseUrl = "https://api.coindesk.com/v1/bpi/"

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideDataRepo(apiUser: ApiUser): DataRepository {
        return DataRepositoryImpl(apiUser)
    }
}

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getHttpLogInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getHttpLogInterceptor()).build()
    }

    @Provides
    @Singleton
    internal fun getApiUser(retrofit: Retrofit): ApiUser {
        return retrofit.create(ApiUser::class.java)
    }

}
