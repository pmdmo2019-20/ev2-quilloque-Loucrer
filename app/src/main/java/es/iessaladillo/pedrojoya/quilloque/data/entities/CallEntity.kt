package es.iessaladillo.pedrojoya.quilloque.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class CallEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val phoneNumber: String,
    val type: Int,
    val date: String,
    val time: String
)