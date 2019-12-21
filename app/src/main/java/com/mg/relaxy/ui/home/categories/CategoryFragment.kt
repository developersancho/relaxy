package com.mg.relaxy.ui.home.categories

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseFragment
import com.mg.relaxy.databinding.FragmentCategoryBinding
import com.mg.remote.model.Category
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private val viewModel by viewModel<CategoryViewModel>()
    private var adapter: CategoryAdapter? = null

    override val layoutId: Int
        get() = R.layout.fragment_category

    override fun initPresenter() {
        viewModel.setPresenter(this)
    }

    override fun bindingUI() {
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun observeUI() {
        viewModel.categories.observe(this, Observer {
            adapter?.submitList(it)
            binding.swipeCategories.isRefreshing = false
        })
    }

    override fun initUI(view: View, savedInstanceState: Bundle?) {
        initAdapter()
        initSwipe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCategories()
    }

    private fun initSwipe() {
        binding.swipeCategories.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.blue),
                ContextCompat.getColor(context, R.color.purple),
                ContextCompat.getColor(context, R.color.red)
            )
            scrollUpChild = binding.rvCategory
            setOnRefreshListener { viewModel.getCategories() }
        }
    }

    private fun initAdapter() {
        adapter = CategoryAdapter()
        binding.rvCategory.adapter = adapter
    }

    override fun initListener() {

        adapter?.onItemClick = { category ->
            val action =
                CategoryFragmentDirections.actionCategoryToCategoryDetailsFragment(category)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        adapter = null
        super.onDestroyView()
    }
}
