package com.mg.relaxy.ui.home.categorydetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseViewHolder
import com.mg.relaxy.databinding.ItemCategoryDetailBinding
import com.mg.remote.model.Sound
import com.mg.util.extensions.inflate
import com.mg.util.extensions.load

class CategoryDetailAdapter :
    RecyclerView.Adapter<CategoryDetailAdapter.CategoryDetailViewHolder>() {

    var onStarClick: ((Sound) -> Unit)? = null
    var items: List<Sound> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailViewHolder =
        CategoryDetailViewHolder(parent.inflate(R.layout.item_category_detail))

    override fun onBindViewHolder(holder: CategoryDetailViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    fun submitData(list: List<Sound>) {
        items = list
        notifyDataSetChanged()
    }

    inner class CategoryDetailViewHolder(view: View) :
        BaseViewHolder<ItemCategoryDetailBinding>(view) {

        fun bind(sound: Sound) {
            binding.item = sound
            if (sound.isFav) {
                binding.imgStar.load(R.drawable.ic_star_full_24dp)
            } else {
                binding.imgStar.load(R.drawable.ic_star_border_24dp)
            }
            binding.imgStar.setOnClickListener {
                onStarClick?.invoke(sound)
            }
        }

    }
}
