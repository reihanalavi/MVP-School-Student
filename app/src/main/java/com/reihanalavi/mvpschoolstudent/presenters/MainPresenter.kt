package com.reihanalavi.mvpschoolstudent.presenters

import android.annotation.SuppressLint
import com.reihanalavi.mvpschoolstudent.network.ApiRepository
import com.reihanalavi.mvpschoolstudent.network.RetrofitBuilder
import com.reihanalavi.mvpschoolstudent.views.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class MainPresenter(val view: MainView): AnkoLogger {

    private val retrofit = RetrofitBuilder.getPopulars()
    private val apiRepository = retrofit.create(ApiRepository::class.java)

    @SuppressLint("CheckResult")
    fun getPopulars() {
        debug { apiRepository.getPopular("5739419841fb670ff49528e8afd73006", "en-US", "1").toString() }
        view.showLoading()
        apiRepository.getPopular("5739419841fb670ff49528e8afd73006", "en-US", "1")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                {
                    view.hideLoading()
                    view.showData(it)
                    debug(it)
                },
                {
                    view.hideLoading()
                    view.onError(it.message!!)
                    debug(it.message!!)
                }
            )
    }

}