package com.mg.relaxy.ui.home.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mg.local.entity.SoundEntity
import com.mg.manager.IDataManager
import com.mg.relaxy.base.BaseViewModel
import com.mg.relaxy.base.IBasePresenter
import com.mg.remote.model.Sound
import com.mg.remote.network.NetworkState
import com.mg.util.helpers.SingleEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoriteViewModel(dataManager: IDataManager) : BaseViewModel<IBasePresenter>(dataManager) {

    val favorites = MutableLiveData<SingleEvent<ArrayList<Sound>>>()

    fun getFavorites() = viewModelScope.launch {
        getPresenter()?.showLoading()
        dataManager.getFavorites().collect { state ->
            when (state) {
                is NetworkState.Success -> {
                    getPresenter()?.hideLoading()
                    state.data.forEach {
                        it.isFav = true
                        dataManager.insertSound(transformEntity(it))
                    }
                    favorites.value = SingleEvent(state.data)
                }
                is NetworkState.Error -> {
                    getPresenter()?.hideLoading()
                    getPresenter()?.onServerError(state.exception.code, state.exception.message)
                }
            }
        }
    }

    fun getMyFavorites() = viewModelScope.launch {
        var newSoundList = arrayListOf<Sound>()
        val favSounds = dataManager.getFavSounds()
        favSounds.forEach {
            newSoundList.add(transform(it))
        }
        favorites.value = SingleEvent(newSoundList)
    }

    fun removeItem(data: Sound) = viewModelScope.launch {
        dataManager.insertSound(transformEntity(data))
        getMyFavorites()
    }

    private fun transformEntity(data: Sound): SoundEntity = SoundEntity(
        soundId = data.id,
        isFav = data.isFav,
        title = data.title,
        soundUrl = data.soundUrl,
        categoryId = data.categoryId
    )

    private fun transform(data: SoundEntity) = Sound(
        id = data.soundId,
        isFav = data.isFav,
        title = data.title,
        soundUrl = data.soundUrl,
        categoryId = data.categoryId
    )

}