package com.mg.relaxy.base

interface IBasePresenter {
    fun showLoading()
    fun hideLoading()
    fun onServerError(code: Int, message: String)
    fun onServiceError(message: String)
}