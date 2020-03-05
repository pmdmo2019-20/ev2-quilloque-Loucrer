package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.entities.CallEntity
import es.iessaladillo.pedrojoya.quilloque.data.models.Call
import es.iessaladillo.pedrojoya.quilloque.data.pojos.CallWithContact

@Dao
interface CallsDao {

    @Insert
    fun insertCall(callEntity: CallEntity)

/*    @Query("SELECT C.id AS callId, C.phoneNumber AS phoneNumber, C.type AS type, \n" +
            "C.date AS date, C.time AS time, T.id AS contactId, T.name AS contactName \n" +
            "FROM CallEntity AS C LEFT JOIN ContactEntity AS T ON C.phoneNumber = T.phoneNumber \n" +
            "ORDER BY C.id DESC LIMIT :limit")
    fun getAllCalls(limit: Int): List<CallWithContact>

    @Query("SELECT name AS contactName, phoneNumber AS phoneNumber " +
            "FROM ContactEntity " +
            "WHERE phoneNumber like :phoneNumber " +
            "UNION " +
            "SELECT DISTINCT phoneNumber AS contactName, phoneNumber AS phoneNumber " +
            "FROM CallEntity " +
            "WHERE phoneNumber like :phoneNumber " +
            "AND phoneNumber NOT IN (SELECT phoneNumber FROM ContactEntity)")
    fun getRefreshCalls(phoneNumber: String): List<CallWithContact>*/

}