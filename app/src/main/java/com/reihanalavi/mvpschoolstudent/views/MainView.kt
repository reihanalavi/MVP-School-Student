package com.reihanalavi.mvpschoolstudent.views

import com.reihanalavi.mvpschoolstudent.models.Popular

interface MainView {

    fun showLoading()
    fun hideLoading()
    fun showData(data: ArrayList<Popular>)
    fun onError(message: String)

}