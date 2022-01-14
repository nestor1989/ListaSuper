package com.idea3d.sexta.di

import android.app.Application
import androidx.room.Room
import com.idea3d.sexta.data.model.RepoImp
import com.idea3d.sexta.data.model.TaskDb
import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.util.DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providetaskDb(app:Application)= Room.databaseBuilder(
        app,
        TaskDb::class.java,
        DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideRepo(db:TaskDb): Repo {
        return RepoImp(db.taskDao())
    }



}