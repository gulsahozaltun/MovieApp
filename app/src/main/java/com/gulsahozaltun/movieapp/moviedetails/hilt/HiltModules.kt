package com.gulsahozaltun.movieapp.moviedetails.hilt

import com.gulsahozaltun.movieapp.moviedetails.remote.MovieInterface
import com.gulsahozaltun.movieapp.moviedetails.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//uygulama bir kere çalıştırıldığında gender edilsin br daha olmasın
//bu sınıf bunu sağlıyor
@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    fun provideRetrofitInterface():MovieInterface{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }

}