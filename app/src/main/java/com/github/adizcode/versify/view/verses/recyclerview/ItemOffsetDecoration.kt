package com.github.adizcode.versify.view.verses.recyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Credit: yqritc (Yoshiko Ikeda)
 * Source: https://gist.github.com/yqritc/ccca77dc42f2364777e1
 */
class ItemOffsetDecoration(private val itemOffset: Int) : RecyclerView.ItemDecoration() {

    constructor(
        context: Context,
        itemOffsetId: Int
    ) : this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(itemOffset, itemOffset, itemOffset, itemOffset)
    }
}