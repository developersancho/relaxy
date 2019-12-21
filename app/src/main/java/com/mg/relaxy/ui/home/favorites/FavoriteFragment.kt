package com.mg.relaxy.ui.home.favorites

import android.os.Bundle
import android.view.View
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseFragment
import com.mg.relaxy.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val viewModel by viewModel<FavoriteViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_favorite

    override fun initPresenter() {
        viewModel.setPresenter(this)
    }

    override fun bindingUI() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun observeUI() {

    }

    override fun initUI(view: View, savedInstanceState: Bundle?) {

    }

    override fun initListener() {

    }

}
