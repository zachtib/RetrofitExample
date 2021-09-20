package com.zachtib.typicode.util

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PostId


@Module
@InstallIn(ViewModelComponent::class)
class PostIdModule {
    @Provides
    @PostId
    fun providePostId(state: SavedStateHandle): Int {
        return state.get("postId")!!
    }
}