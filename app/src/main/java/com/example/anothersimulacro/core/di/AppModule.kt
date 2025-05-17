package com.example.anothersimulacro.core.di

import android.content.Context
import com.example.anothersimulacro.core.db.RoomProvider
import com.example.anothersimulacro.core.db.TaskDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.example.anothersimulacro")
class AppModule {
    @Single
    fun databaseProvider(context: Context): TaskDataBase {
        return RoomProvider.providerDb(context)
    }

}