package com.github.adizcode.versify

import android.view.View
import androidx.navigation.findNavController
import com.github.adizcode.versify.model.Verse
import com.github.adizcode.versify.view.verses.VersesFragmentDirections

// TODO: Reorganize these methods as per MVVM
fun navigateToVerseContents(view: View, verse: Verse) {
    val action = VersesFragmentDirections.actionVersesFragmentToVerseContentsFragment(verse)
    view.findNavController().navigate(action)
}