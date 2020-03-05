package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.pojos.CallWithContact
import es.iessaladillo.pedrojoya.quilloque.utils.createAvatarDrawable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recent_fragment_item.*

class DialAdapter(private val application: Application): ListAdapter<CallWithContact, DialAdapter.ViewHolder>(ContactDiffCallback){

    var onItemClickListener: ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.dial_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val callContact: CallWithContact = currentList[position]
        holder.bind(callContact)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        init {
            containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) }
        }

        fun bind(contact: CallWithContact) {
            contact.run {
                imgAvatar.setImageDrawable(createAvatarDrawable(contact.contactName))
                lblName.text = contactName
                lblPhoneNumber.text = phoneNumber
            }
        }
    }

    object ContactDiffCallback : DiffUtil.ItemCallback<CallWithContact>() {

        override fun areItemsTheSame(oldItem: CallWithContact, newItem: CallWithContact): Boolean =
            oldItem.phoneNumber == newItem.phoneNumber

        override fun areContentsTheSame(oldItem: CallWithContact, newItem: CallWithContact): Boolean =
            oldItem == newItem

    }
}