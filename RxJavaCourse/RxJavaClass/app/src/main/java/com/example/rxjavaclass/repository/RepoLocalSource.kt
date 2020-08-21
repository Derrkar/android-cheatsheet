package com.example.rxjavaclass.repository

import com.example.rxjavaclass.RxApp
import com.example.rxjavaclass.db.AppDataBase
import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable


object RepoLocalSource : RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {

        return  Observable.fromCallable {
            return AppDataBase.getInstance(RxApp.INSTANCE).getRepoDao()!!.fetchAllMyStarsRepos()
        }


    }

    override fun saveRepos(repos: ArrayList<Repo>) {
        AppDataBase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }
}