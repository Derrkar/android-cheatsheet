package com.example.rxjavaclass.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Repo::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getRepoDao() :RepoDAO

    companion object {
        var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            INSTANCE?.let { INSTANCE }?:run {
                INSTANCE = Room.databaseBuilder(context, AppDataBase::class.java, "repo.db").build()
            }

            return INSTANCE
        }
    }
}