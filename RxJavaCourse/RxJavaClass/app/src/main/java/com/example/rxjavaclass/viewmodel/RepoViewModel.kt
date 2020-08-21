package com.example.rxjavaclass.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.network.GithubApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val repoLiveData = MutableLiveData<ArrayList<Repo>>()

    @SuppressLint("CheckResult")
    fun getMyStarsRepos(username: String) {

        val reposDisposable = GithubApiClient.getGithubService().getStarredRepos(username)
            .subscribeOn(Schedulers.io()) // scheduler.io because it's network connection
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                repoLiveData.value = it
            }
        compositeDisposable.add(reposDisposable)

    }

    fun getLiveData(): LiveData<ArrayList<Repo>> = repoLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}