package com.phayarsar.data.di

import com.phayarsar.data.repository.LocalizationRepositoryImpl
import com.phayarsar.data.repository.PrayerRepositoryImpl
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.localization.LocalizationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindPrayerRepository(
        prayerRepositoryImpl: PrayerRepositoryImpl
    ): PrayerRepository

    @Singleton
    @Binds
    abstract fun bindLocalizationRepository(
        localizationRepositoryImpl: LocalizationRepositoryImpl
    ): LocalizationRepository
}