package com.example.challengepicpay.presentation.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.challengepicpay.R
import com.example.challengepicpay.presentation.extension.bindView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ContactView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val circleImageViewPicture: CircleImageView by bindView(R.id.item_contact_picture)
    private val textViewUsername: AppCompatTextView by bindView(R.id.item_contact_username)
    private val textViewName: AppCompatTextView by bindView(R.id.item_contact_name)
    private val progressBarLoading: ProgressBar by bindView(R.id.item_contact_progress_loading)

    init {
        inflate(context, R.layout.view_contact, rootView as ViewGroup?)
    }

    fun setImage(urlImage: String) {
        Picasso.get()
            .load(urlImage)
            .error(R.drawable.ic_round_account_circle)
            .into(circleImageViewPicture, object : Callback {
                override fun onSuccess() {
                    setVisibilityLoading(false)
                }

                override fun onError(e: Exception?) {
                    setVisibilityLoading(false)
                }
            })
    }

    fun setUserName(userName: String?) {
        textViewUsername.text = userName
    }

    fun setName(name: String?) {
        textViewName.text = name
    }

    fun setVisibilityLoading(isLoading: Boolean) {
        if (isLoading) {
            progressBarLoading.visibility = View.VISIBLE
        } else {
            progressBarLoading.visibility = View.GONE
        }
    }
}