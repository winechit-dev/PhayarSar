package com.phayarsar.data.di

import com.phayarsar.data.repository.PrayerRepositoryImpl
import com.phayarsar.domain.PrayerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules{
    @Provides
    @Singleton
    fun providerRepository(movieAPIService: MovieAPIService):MovieRepository{
        return MovieRepositoryImpl(movieAPIService)

    }
}*/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRepositoryImpl: PrayerRepositoryImpl
    ): PrayerRepository
}
