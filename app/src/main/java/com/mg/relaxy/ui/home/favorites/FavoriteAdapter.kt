package com.mg.relaxy.ui.home.favorites

import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseViewHolder
import com.mg.relaxy.databinding.ItemFavoriteBinding
import com.mg.remote.model.Sound
import com.mg.util.extensions.inflate

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    var onRemovedItemClick: ((Sound) -> Unit)? = null
    var onPlayOrPause: ((Boolean) -> Unit)? = null
    var seekBarProgressChange: ((SeekBar?, Int, Boolean) -> Unit)? = null

    var items: List<Sound> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder =
        FavoriteViewHolder(parent.inflate(R.layout.item_favorite))

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    fun submitData(list: List<Sound>) {
        items = list
        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(view: View) : BaseViewHolder<ItemFavoriteBinding>(view) {
        fun bind(sound: Sound) {
            binding.item = sound

            binding.imgStar.setOnClickListener {
                onRemovedItemClick?.invoke(sound)
            }

            binding.imgPlayOrPause.setOnClickListener {
                //onPlayOrPause?.invoke()
            }

            binding.seekBarSoundVolume.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    seekBarProgressChange?.invoke(seekBar, progress, fromUser)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })

        }
    }

}


private class DiffCallback : DiffUtil.ItemCallback<Sound>() {

    override fun areItemsTheSame(oldItem: Sound, newItem: Sound): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Sound, newItem: Sound): Boolean {
        return oldItem == newItem
    }

}