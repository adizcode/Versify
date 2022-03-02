package com.github.adizcode.versify.view.verses.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.adizcode.versify.R
import com.github.adizcode.versify.databinding.VerseItemBinding
import com.github.adizcode.versify.model.Verse
import com.github.adizcode.versify.navigateToVerseContents
import com.github.adizcode.versify.view.verses.VersesFragmentDirections

class VersesAdapter(private val data: List<Verse>) :
    RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: VerseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setVerse(verse: Verse) {
            binding.apply {

                // TODO: Leave the text untouched and use placeholders
                verseItemTitle.text = verse.name.ifBlank { "--Untitled--" }
                verseItemContents.text = verse.contents.ifBlank { " --No Content--" }
                verseCard.setOnClickListener { view -> navigateToVerseContents(view, verse) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<VerseItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.verse_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.setVerse(data[position])

    override fun getItemCount() = data.size
}