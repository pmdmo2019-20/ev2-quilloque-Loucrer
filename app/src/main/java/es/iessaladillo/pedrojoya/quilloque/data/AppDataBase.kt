package es.iessaladillo.pedrojoya.quilloque.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import es.iessaladillo.pedrojoya.quilloque.data.dao.CallsDao
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactsDao
import es.iessaladillo.pedrojoya.quilloque.data.entities.CallEntity
import es.iessaladillo.pedrojoya.quilloque.data.entities.ContactEntity
import kotlin.concurrent.thread


@Database(
    entities = [CallEntity::class, ContactEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract val callsDao: CallsDao
    abstract val contactsDao: ContactsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "app_database"
                        )
                            .addCallback(object: Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    thread {
                                        // Ejecutar sentencias SQL sobre db
                                        // o a través de los métodos de los Dao.
                                        // INSERTAR LLAMADAS DE EJEMPLOS
                                        INSTANCE!!.callsDao.insertCall(CallEntity(0,"666548789", getCallTypeIcon("CALL_TYPE_MADE"),"05/03/2020","11:28"))
                                        INSTANCE!!.callsDao.insertCall(CallEntity(0,"547854478", getCallTypeIcon("CALL_TYPE_RECEIVED"),"05/03/2020","11:30"))
                                        INSTANCE!!.callsDao.insertCall(CallEntity(0,"968547854", getCallTypeIcon("CALL_TYPE_MISSED"),"05/03/2020","11:20"))
                                        INSTANCE!!.callsDao.insertCall(CallEntity(0,"787874477", getCallTypeIcon("CALL_TYPE_VIDEO"),"05/03/2020","11:37"))
                                        // INSERTAR CONTACTOS DE EJEMPLO
                                        INSTANCE!!.contactsDao.insertContact(ContactEntity(0,"Baldomereichon","666548789"))
                                        INSTANCE!!.contactsDao.insertContact(ContactEntity(0,"Pipon","547854478"))
                                    }




                                }
                            })
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}