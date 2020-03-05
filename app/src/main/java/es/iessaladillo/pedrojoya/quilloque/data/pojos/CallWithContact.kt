package es.iessaladillo.pedrojoya.quilloque.data.pojos

data class CallWithContact(
    val callId: Long,
    val contactId: Long,
    val contactName : String,
    val phoneNumber: String,
    val type: String,
    val date: String,
    val time: String
)