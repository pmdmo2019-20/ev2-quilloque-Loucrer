package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.entities.ContactEntity
import es.iessaladillo.pedrojoya.quilloque.data.models.Contact

@Dao
interface ContactsDao {

    @Query("SELECT name, phoneNumber FROM ContactEntity ORDER BY name")
    fun getAllContacts(): List<Contact>

    @Query("SELECT name, phoneNumber FROM ContactEntity WHERE name LIKE :search ORDER BY name")
    fun getContact(search: String): List<Contact>

    @Insert
    fun insertContact(contact: ContactEntity)

}