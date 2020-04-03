package com.reihanalavi.mvpschoolstudent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.reihanalavi.mvpschoolstudent.adapters.PopularAdapter
import com.reihanalavi.mvpschoolstudent.models.Popular
import com.reihanalavi.mvpschoolstudent.presenters.MainPresenter
import com.reihanalavi.mvpschoolstudent.views.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.onRefresh

class MainActivity : AppCompatActivity(), MainView, AnkoLogger {

    private val populars: MutableList<Popular> = mutableListOf()

    lateinit var presenter: MainPresenter
    lateinit var adapter: PopularAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        adapter = PopularAdapter(this) {

        }

        swipeRefresh.onRefresh {
            presenter.getPopulars()
        }

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = adapter

        adapter.popular.clear()
        presenter.getPopulars()

    }

    override fun showLoading() {
        toast("Loading")
    }

    override fun hideLoading() {
        toast("Selesai")
        swipeRefresh.isRefreshing = false
    }

    override fun showData(data: ArrayList<Popular>) {
        swipeRefresh.isRefreshing = false
        adapter.popular = data
        adapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        debug { message }
    }

}
