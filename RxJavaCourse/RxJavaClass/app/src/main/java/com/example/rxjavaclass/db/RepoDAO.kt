package com.example.rxjavaclass.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface RepoDAO {

    @Query(" Select * FROM repo")
    fun fetchAllMyStarsRepos(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyStarsRepos(repos: ArrayList<Repo>)
}