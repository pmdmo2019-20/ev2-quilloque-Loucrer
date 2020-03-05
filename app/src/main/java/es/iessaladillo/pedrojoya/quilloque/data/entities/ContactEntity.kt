package es.iessaladillo.pedrojoya.quilloque.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(
            name = "CONTACT_INDEX_NAME_UNIQUE",
            value = ["phoneNumber"],
            unique = true
        )
    ]
)
data class ContactEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name : String,
    val phoneNumber : String
)