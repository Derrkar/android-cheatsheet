package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.network.GithubApiClient
import io.reactivex.Observable

object ReposRemoteSource : RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return GithubApiClient.getGithubService().getStarredRepos(username)
    }

    override fun saveRepos(repos: ArrayList<Repo>) {

    }
}