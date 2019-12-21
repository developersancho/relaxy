package com.mg.relaxy.ui.home.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mg.manager.IDataManager
import com.mg.relaxy.base.BaseViewModel
import com.mg.relaxy.base.IBasePresenter
import com.mg.remote.model.Category
import com.mg.remote.network.NetworkState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoryViewModel(dataManager: IDataManager) : BaseViewModel<IBasePresenter>(dataManager) {

    private val _categories = MutableLiveData<ArrayList<Category>>()
    val categories: LiveData<ArrayList<Category>> get() = _categories

    fun getCategories() = viewModelScope.launch {
        getPresenter()?.showLoading()
        dataManager.getCategories().collect { state ->
            when (state) {
                is NetworkState.Success -> {
                    getPresenter()?.hideLoading()
                    _categories.value = state.data
                }
                is NetworkState.Error -> {
                    getPresenter()?.hideLoading()
                    getPresenter()?.onServerError(state.exception.code, state.exception.message)
                }
            }
        }
    }

}