package com.example.challengepicpay.presentation.feature.contacts

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengepicpay.R
import com.example.challengepicpay.presentation.extension.bindView
import com.example.challengepicpay.domain.model.ContactVO
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

class ContactsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageViewPicture: CircleImageView by bindView(R.id.item_contact_picture)
    private val textViewName: AppCompatTextView by bindView(R.id.item_contact_name)
    private val textViewUserName: AppCompatTextView by bindView(R.id.item_contact_username)
    private val progressLoading: ProgressBar by bindView(R.id.item_contact_progress_loading)

    fun bind(contact: ContactVO) {
        textViewName.text = contact.name
        textViewUserName.text = contact.username
        progressLoading.visibility = View.VISIBLE
        loadImage(contact)
    }

    private fun loadImage(contact: ContactVO) {
        Picasso.get()
            .load(contact.img)
            .error(R.drawable.ic_round_account_circle)
            .into(imageViewPicture, object : Callback {
                override fun onSuccess() {
                    progressLoading.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progressLoading.visibility = View.GONE
                }
            })
    }
}