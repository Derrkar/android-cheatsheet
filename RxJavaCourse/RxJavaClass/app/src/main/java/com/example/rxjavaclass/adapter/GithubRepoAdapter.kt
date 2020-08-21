package com.example.rxjavaclass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavaclass.R
import com.example.rxjavaclass.db.Repo
import kotlinx.android.synthetic.main.stars_item.view.*

class GithubRepoAdapter : RecyclerView.Adapter<GithubRepoAdapter.StartRepoViewHolder>() { // recyclerView for listView of views

    val data = ArrayList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : StartRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stars_item, parent, false) // flatting view
        return StartRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: StartRepoViewHolder, position: Int) { // adding data to our view
        holder.repoName.text = data[position].name
        holder.repoLang.text = data[position].lang
        holder.repoStarsCount.text = data[position].starCount.toString()

        data[position].desc?.let {
            holder.repoDesc.text = data[position].desc
        }?.run {
            holder.repoDesc.text = "NO DESC"
        }
    }

    public fun addRepos(repos: ArrayList<Repo>) {
        data.addAll(repos)
        notifyDataSetChanged()
    }

    class StartRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) { // making references for our views
        val repoName = view.name
        val repoDesc = view.desc
        val repoLang = view.language
        val repoStarsCount = view.starsCount
    }

}