package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallsDao
import es.iessaladillo.pedrojoya.quilloque.data.pojos.CallWithContact
import es.iessaladillo.pedrojoya.quilloque.utils.Event
import java.lang.Exception
import java.lang.StringBuilder
import kotlin.concurrent.thread

class DialViewModel(private val callsDao: CallsDao, private val application: Application): ViewModel() {

    private val _listCalls: MutableLiveData<List<CallWithContact>> = MutableLiveData()
    val listCalls: LiveData<List<CallWithContact>>
        get() = _listCalls

    // Para mostrar en el caso de error
    private val _message : MutableLiveData<Event<String>> = MutableLiveData()
    val message : LiveData<Event<String>>
        get() = _message

    fun sugestionCall(newNumber: String) {
/*        var oldNumber = ""
        if(oldNumber != newNumber){
            var search = StringBuilder()
            search.append("%"+newNumber+"%")
            thread {
                try {
                    _listCalls.postValue(callsDao.getRefreshCalls(search.toString()))
                }catch (e: Exception){
                    _message.postValue(Event(e.message ?: "Pete"))
                }
            }
            oldNumber = newNumber
        }*/
    }

}