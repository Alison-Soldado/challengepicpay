package com.example.challengepicpay.presentation.feature.contacts

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengepicpay.R
import com.example.challengepicpay.presentation.extension.bindView
import com.example.challengepicpay.domain.model.ContactVO
import com.example.challengepicpay.presentation.customview.ContactView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

class ContactsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val viewContact : ContactView by bindView(R.id.item_contact_view_contact)

    fun bind(contact: ContactVO) {
        with(viewContact) {
            setName(contact.name)
            setUserName(contact.username)
            setVisibilityLoading(true)
            setImage(contact.img)
        }
    }
}