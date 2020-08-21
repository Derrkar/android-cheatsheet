package com.example.rxjavaclass

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavaclass.adapter.GithubRepoAdapter
import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val repoList = ArrayList<Repo>()
    private lateinit var repoAdapter: GithubRepoAdapter
    private lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(myStarsList.context, DividerItemDecoration.VERTICAL)
        myStarsList.layoutManager = linearLayoutManager

        repoAdapter = GithubRepoAdapter()
        /*repoAdapter.addRepos(repoList)*/
        myStarsList.adapter = repoAdapter
        myStarsList.addItemDecoration(divider)

        repoViewModel = ViewModelProvider(this).get(RepoViewModel::class.java)

        getStarredRepos(repoViewModel)
        observeMyStars(repoViewModel)
    }


    @SuppressLint("CheckResult")
    fun getStarredRepos(viewModel: RepoViewModel) { // calling the api of stars to getOurStarsRepos
        viewModel.getMyStarsRepos("mrabelwahed")
    }

    fun observeMyStars(viewModel: RepoViewModel) {
        viewModel.getLiveData().observe(this, Observer {
            repos -> repoAdapter.addRepos(repos)
        })
    }
}