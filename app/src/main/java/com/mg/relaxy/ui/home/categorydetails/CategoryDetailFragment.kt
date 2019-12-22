package com.mg.relaxy.ui.home.categorydetails

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.mg.local.entity.SoundEntity
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseFragment
import com.mg.relaxy.databinding.FragmentCategoryDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CategoryDetailFragment : BaseFragment<FragmentCategoryDetailsBinding>() {

    private val viewModel by viewModel<CategoryDetailViewModel>()
    private var adapter: CategoryDetailAdapter? = null
    private val args: CategoryDetailFragmentArgs by navArgs()

    override val layoutId: Int
        get() = R.layout.fragment_category_details

    override fun initPresenter() {
        viewModel.setPresenter(this)
    }

    override fun bindingUI() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun observeUI() {
        viewModel.categoryDetails.observe(this, Observer {
            adapter?.submitData(it)
            binding.swipeCategoryDetail.isRefreshing = false
        })
    }

    override fun initUI(view: View, savedInstanceState: Bundle?) {
        viewModel.categoryId = args.category.categoryId
        initAdapter()
        initSwipe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCategoryDetail()
    }

    override fun initListener() {
        adapter?.onStarClick = { detail ->
            val soundEntity = SoundEntity(
                soundId = detail.id,
                isFav = !detail.isFav,
                title = detail.title,
                categoryId = detail.categoryId,
                soundUrl = detail.soundUrl
            )
            viewModel.insertSoundToFavorites(soundEntity)
        }
    }

    private fun initSwipe() {
        binding.swipeCategoryDetail.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.blue),
                ContextCompat.getColor(context, R.color.purple),
                ContextCompat.getColor(context, R.color.red)
            )
            scrollUpChild = binding.rvCategoryDetail
            setOnRefreshListener { viewModel.getCategoryDetail() }
        }
    }

    private fun initAdapter() {
        adapter = CategoryDetailAdapter()
        binding.rvCategoryDetail.adapter = adapter
    }

    override fun onDestroyView() {
        adapter = null
        super.onDestroyView()
    }
}
