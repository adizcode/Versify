package com.github.adizcode.versify.view.verses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.github.adizcode.versify.R
import com.github.adizcode.versify.databinding.FragmentVersesBinding
import com.github.adizcode.versify.model.Verse
import com.github.adizcode.versify.model.versesList
import com.github.adizcode.versify.navigateToVerseContents
import com.github.adizcode.versify.view.verses.recyclerview.ItemOffsetDecoration
import com.github.adizcode.versify.view.verses.recyclerview.VersesAdapter

class VersesFragment : Fragment() {
    private lateinit var binding: FragmentVersesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_verses,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = VersesAdapter(versesList)
            addItemDecoration(
                ItemOffsetDecoration(
                    context,
                    R.dimen.item_offset
                )
            )
        }
        binding.addVerseButton.setOnClickListener { clickedView ->

            navigateToVerseContents(
                clickedView,
                Verse().also {
                    versesList.add(it)
                }
            )
        }
    }
}