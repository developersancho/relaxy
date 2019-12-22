package com.mg.relaxy.ui.home.favorites

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import com.mg.relaxy.R
import com.mg.relaxy.base.BaseViewHolder
import com.mg.relaxy.databinding.ItemFavoriteBinding
import com.mg.remote.model.Sound
import com.mg.util.extensions.inflate
import com.mg.util.extensions.load

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    var onRemovedItemClick: ((Sound) -> Unit)? = null
    var onPlayOrPause: ((Sound, Int, HashMap<String, MediaPlayer>) -> Unit)? = null

    private var selectedPlayList: ArrayList<String> = arrayListOf()
    private var mediaPlayerHashMap: HashMap<String, MediaPlayer> = hashMapOf()

    var mediaPlayer: MediaPlayer? = null
    var items: List<Sound> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder =
        FavoriteViewHolder(parent.inflate(R.layout.item_favorite))

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(items[position], selectedPlayList)
    }


    override fun getItemCount() = items.size

    fun submitData(list: List<Sound>) {
        items = list
        notifyDataSetChanged()
    }

    fun stopEveryThing() {
        mediaPlayerHashMap.forEach { (key, value) ->
            println("$key = $value")
            value?.stop()
        }

        selectedPlayList.clear()
    }

    inner class FavoriteViewHolder(view: View) : BaseViewHolder<ItemFavoriteBinding>(view) {
        fun bind(
            sound: Sound,
            selectedPlaying: ArrayList<String>
        ) {
            binding.item = sound

            if (selectedPlaying.contains(sound.id.toString())) {
                binding.imgPlayOrPause.load(R.drawable.ic_pause_24dp)
            } else {
                binding.imgPlayOrPause.load(R.drawable.ic_play_24dp)
            }


            binding.imgStar.setOnClickListener {
                onRemovedItemClick?.invoke(sound)
            }

            binding.imgPlayOrPause.setOnClickListener {
                sound.isPlaying = !sound.isPlaying

                if (!selectedPlaying.contains(sound.id.toString())) {
                    selectedPlaying.add(sound.id.toString())
                    mediaPlayer =
                        MediaPlayer.create(binding.root.context, Uri.parse(sound.soundUrl))
                    mediaPlayerHashMap[sound.id.toString()] = mediaPlayer!!
                    onPlayOrPause?.invoke(sound, adapterPosition, mediaPlayerHashMap)
                } else {
                    onPlayOrPause?.invoke(sound, adapterPosition, mediaPlayerHashMap)
                    selectedPlaying.remove(sound.id.toString())
                    mediaPlayerHashMap.remove(sound.id.toString())
                }

                notifyDataSetChanged()
            }

            // Volume up and down
            val audioManager =
                binding.root.context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            binding.seekBarSoundVolume.max =
                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            binding.seekBarSoundVolume.progress =
                audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)


            binding.seekBarSoundVolume.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })

        }
    }

}