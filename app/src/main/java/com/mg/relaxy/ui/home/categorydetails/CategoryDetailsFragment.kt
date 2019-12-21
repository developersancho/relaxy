package com.mg.relaxy.ui.home.categorydetails

import android.os.Bundle
import android.view.View
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseFragment
import com.mg.relaxy.databinding.FragmentCategoryDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CategoryDetailsFragment : BaseFragment<FragmentCategoryDetailsBinding>() {

    private val viewModel by viewModel<CategoryDetailViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_category_details

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
