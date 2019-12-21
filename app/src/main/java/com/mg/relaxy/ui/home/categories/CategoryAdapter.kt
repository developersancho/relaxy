package com.mg.relaxy.ui.home.categories

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseViewHolder
import com.mg.relaxy.databinding.ItemCategoryBinding
import com.mg.remote.model.Category
import com.mg.util.extensions.inflate

class CategoryAdapter : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(DiffCallback()) {

    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(parent.inflate(R.layout.item_category))

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.apply {
            bind(getItem(position))
            itemView.tag = getItem(position)
        }
    }

    inner class CategoryViewHolder(view: View) : BaseViewHolder<ItemCategoryBinding>(view) {
        fun bind(category: Category) {
            binding.item = category
            binding.cardCategory.setOnClickListener {
                onItemClick?.invoke(category)
            }
        }
    }
}


private class DiffCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}