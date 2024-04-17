package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

@SuppressLint("CheckResult")
fun TextView.setUserAvatar(uri: String, placeholder: Int) {
    val glidUri = if (uri.isEmpty()) placeholder else GlideUrl(uri)

    Glide.with(context)
        .load(glidUri)
        .placeholder(placeholder)
        .apply(
            RequestOptions
                .circleCropTransform()
                .override(80, this.autoLinkMask)
        )
        .into(object : CustomViewTarget<TextView, Drawable>(this) {
            override fun onLoadFailed(errorDrawable: Drawable?) {
                view.setCompoundDrawablesWithIntrinsicBounds(
                    errorDrawable, null, null, null
                )
            }

            override fun onResourceCleared(placeholder: Drawable?) {
                view.setCompoundDrawablesWithIntrinsicBounds(
                    placeholder, null, null, null
                )
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                view.setCompoundDrawablesWithIntrinsicBounds(
                    resource, null, null, null
                )
            }
        })
}

fun TextView.setTextColorCompat(@ColorRes color: Int) {
    setTextColor(ContextCompat.getColor(context, color))
}