package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable

class RepoRepository (val repoRemoteSource: ReposRemoteSource, val repoLocalSource: RepoLocalSource) : RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.empty()
    }

    override fun saveRepos(repos: ArrayList<Repo>) {

    }

}