package com.mg.relaxy.ui.home.favorites

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseFragment
import com.mg.relaxy.databinding.FragmentFavoriteBinding
import com.mg.remote.model.Sound
import com.mg.util.helpers.SingleEventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val viewModel by viewModel<FavoriteViewModel>()
    private var adapter: FavoriteAdapter? = null
    private var soundList: List<Sound> = listOf()

    override val layoutId: Int
        get() = R.layout.fragment_favorite

    override fun initPresenter() {
        viewModel.setPresenter(this)
    }

    override fun bindingUI() {
        binding.lifecycleOwner = this
    }

    override fun observeUI() {
        viewModel.favorites.observe(this, SingleEventObserver {
            soundList = it
            adapter?.submitData(it)
            binding.swipeFavorite.isRefreshing = false
        })
    }

    override fun initUI(view: View, savedInstanceState: Bundle?) {
        initAdapter()
        initSwipe()
        viewModel.getFavorites()
    }

    override fun initListener() {

        adapter?.onRemovedItemClick = {
            it.isFav = false
            viewModel.removeItem(it)
        }

        adapter?.onPlayOrPause = { sound, position, hashMap ->
            val mediaPlayer = hashMap[sound.id.toString()]
            if (!sound.isPlaying) {
                mediaPlayer?.start()
            } else {
                mediaPlayer?.release()
            }
        }

    }

    private fun initSwipe() {
        binding.swipeFavorite.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.blue),
                ContextCompat.getColor(context, R.color.purple),
                ContextCompat.getColor(context, R.color.red)
            )
            scrollUpChild = binding.rvFavorite
            setOnRefreshListener { viewModel.getMyFavorites() }
        }
    }

    private fun initAdapter() {
        adapter = FavoriteAdapter()
        binding.rvFavorite.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMyFavorites()
    }

    override fun onPause() {
        super.onPause()
        adapter?.stopEveryThing()
    }

}
