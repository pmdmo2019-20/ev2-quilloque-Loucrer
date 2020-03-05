package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactsDao
import es.iessaladillo.pedrojoya.quilloque.data.models.Contact
import es.iessaladillo.pedrojoya.quilloque.utils.Event
import java.lang.Exception
import java.lang.StringBuilder
import kotlin.concurrent.thread

class ContactViewModel(private val contactDao: ContactsDao,private val application: Application): ViewModel() {

    val name = MutableLiveData<String>("")
    val lblNameText: LiveData<String> = name

    private val _listCalls: MutableLiveData<List<Contact>> = MutableLiveData()
    val listCalls: LiveData<List<Contact>>
        get() = _listCalls


    private val _listCurrentContact: MutableLiveData<List<Contact>> = MutableLiveData()
    val listCurrentCalls: LiveData<List<Contact>>
        get() = _listCurrentContact

    // Para mostrar en el caso de error
    private val _message : MutableLiveData<Event<String>> = MutableLiveData()
    val message : LiveData<Event<String>>
        get() = _message


    init {
        thread {
            try {
                _listCalls.postValue(contactDao.getAllContacts())
            }catch (e: Exception){
                _message.postValue(Event(e.message ?: "Pete"))
            }
        }
    }

    fun search(){
        // Esta funcion iba hacerlo con databinding
        var oldWord = ""
        if(oldWord != lblNameText.value){
            var searchWord = StringBuilder()
            searchWord.append("%"+lblNameText.value+"%")
            thread {
                try {
                    _listCurrentContact.postValue(contactDao.getContact(searchWord.toString()))
                }catch (e: Exception){
                    _message.postValue(Event(e.message ?: "Pete"))
                }
            }
            oldWord = lblNameText.value!!
        }

    }

}