package com.zachtib.typicode.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Registers a View.OnAttachStateChangeListener to set the RecyclerView's Adapter
 * to null when it detaches from a window in order to prevent leaking memory.
 */
fun RecyclerView.clearAdapterOnViewDetached() {
    addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
        override fun onViewAttachedToWindow(view: View?) { }

        override fun onViewDetachedFromWindow(view: View?) {
            adapter = null
        }
    })
}