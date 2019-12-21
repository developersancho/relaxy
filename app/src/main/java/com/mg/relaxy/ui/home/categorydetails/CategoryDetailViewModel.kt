package com.mg.relaxy.ui.home.categorydetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mg.local.entity.SoundEntity
import com.mg.manager.IDataManager
import com.mg.relaxy.base.BaseViewModel
import com.mg.relaxy.base.IBasePresenter
import com.mg.remote.model.Category
import com.mg.remote.model.CategoryDetail
import com.mg.remote.network.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoryDetailViewModel(dataManager: IDataManager) :
    BaseViewModel<IBasePresenter>(dataManager) {

    var categoryId: Int? = null

    private val _categoryDetails = MutableLiveData<ArrayList<CategoryDetail>>()
    val categoryDetails: LiveData<ArrayList<CategoryDetail>> get() = _categoryDetails

    fun getCategoryDetail() = viewModelScope.launch {
        getPresenter()?.showLoading()
        dataManager.getCategoryDetails().collect { state ->
            when (state) {
                is NetworkState.Success -> {
                    getPresenter()?.hideLoading()
                    val detailList =
                        state.data.filter { it.categoryId == categoryId }
                    val favList = dataManager.getSounds()
                    favList.forEach { favSound ->
                        detailList.find { it.id == favSound.soundId }?.isFav = favSound.isFav
                    }
                    _categoryDetails.value = ArrayList(detailList)
                }
                is NetworkState.Error -> {
                    getPresenter()?.hideLoading()
                    getPresenter()?.onServerError(state.exception.code, state.exception.message)
                }
            }
        }
    }

    fun insertSoundToFavorites(soundEntity: SoundEntity) = viewModelScope.launch {
        dataManager.insertSound(soundEntity = soundEntity)
        getCategoryDetail()
    }

}