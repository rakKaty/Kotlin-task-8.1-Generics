data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val commentsCount: Int,
    val readComments: Int,
    val viewUrl: String,
    val isDeleted: Boolean
)


data class Comment(
    val id: Int,
    val noteId: Int,
    val ownerId: Int,
    val message: String,
    val isDeleted: Boolean
)


