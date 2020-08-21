package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable

interface RepoDataSource {
    fun fetchRepos(username: String) : Observable<ArrayList<Repo>>
    fun saveRepos(repos: ArrayList<Repo>)
}