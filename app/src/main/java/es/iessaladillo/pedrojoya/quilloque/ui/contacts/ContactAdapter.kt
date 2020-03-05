package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.models.Contact
import es.iessaladillo.pedrojoya.quilloque.data.pojos.CallWithContact
import es.iessaladillo.pedrojoya.quilloque.utils.createAvatarDrawable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.contacts_fragment_item.*

class ContactAdapter(private val application: Application): ListAdapter<Contact, ContactAdapter.ViewHolder>(ContactDiffCallback){

    var onItemClickListener: ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.contacts_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val callContact: Contact = currentList[position]
        holder.bind(callContact)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        init {
            containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) }
        }

        fun bind(contact: Contact) {
            contact.run {
                imgAvatar.setImageDrawable(createAvatarDrawable(contact.name))
                lblName.text = name
                lblPhoneNumber.text = phoneNumber
                btnCall.visibility = View.VISIBLE
                btnDelete.visibility = View.VISIBLE
                btnMessage.visibility = View.VISIBLE
                btnVideoCall.visibility = View.VISIBLE
            }
        }
    }

    object ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean =
            oldItem.phoneNumber == newItem.phoneNumber

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean =
            oldItem == newItem

    }
}