package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallsDao
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactsDao

class ContactViewModelFactory(private val contactDao: ContactsDao, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ContactViewModel(contactDao, application) as T
}