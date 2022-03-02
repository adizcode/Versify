package com.github.adizcode.versify.view.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.github.adizcode.versify.R
import com.github.adizcode.versify.databinding.FragmentVerseContentsBinding
import com.github.adizcode.versify.model.versesList

class VerseContentsFragment : Fragment() {
    private val args: VerseContentsFragmentArgs by navArgs()
    private lateinit var binding: FragmentVerseContentsBinding
    private lateinit var titleString: String
    private lateinit var contentsString: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_verse_contents,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(args.verse) {
            titleString = name
            contentsString = contents
        }

        binding.apply {
            verseTitle.setText(titleString)
            verseContents.setText(contentsString)
            verseTitle.doOnTextChanged { text, _, _, _ ->
                titleString = text.toString()
            }
            verseContents.doOnTextChanged { text, _, _, _ ->
                contentsString = text.toString()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        args.verse.apply {
            name = titleString
            contents = contentsString

            if (name.isBlank() && contents.isBlank()) {
                versesList.remove(this)
            }
        }
    }
}