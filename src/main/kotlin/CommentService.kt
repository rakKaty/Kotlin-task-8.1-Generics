object CommentService : CrudService<Comment> {

    private var comments = mutableListOf<Comment>()


    override fun add(entity: Comment): Comment {
        comments.add(entity)
        return comments.last()
    }

    override fun delete(entity: Comment) {
        for (comment in comments) {
            if (comment.noteId == entity.id)
                comment.isDeleted
        }
    }

    override fun edit(entity: Comment) {
        for (comment in comments) {
            if (!comment.isDeleted && comment.id == entity.id) {
                val commentEdited = comment.copy(message = "message отредактирован")
                comments.remove(comment)
                comments.add(commentEdited)
            } else {
                println("Невозможно отредактировать данный комментарий, " +
                        "т.к он не существует или был удалён")
            }
        }
    }

    override fun getByOwnerId(id: Int): MutableList<Comment> {
        val commentsByOwnerId = mutableListOf<Comment>()
        for (comment in comments) {
            if (!comment.isDeleted && comment.ownerId == id) {
                commentsByOwnerId.add(comment)
            }
            println("Заметки с таким id не существует, либо она была удалена")
        }
        return commentsByOwnerId
    }

    override fun getById(id: Int): Comment? {
        var commentToGet: Comment? = null
        for (comment in comments) {
            if (!comment.isDeleted && comment.id == id) {
                commentToGet = comment
            }
            println("Заметки с таким id не существует, либо она была удалена")
        }
        return commentToGet
    }

    override fun restore(entity: Comment): Boolean {
        var isRestored = false
        for (comment in comments) {
            isRestored = if (comment.isDeleted && comment.id == entity.id) {
                val commentRestored = comment.copy(isDeleted = false)
                comments.remove(comment)
                comments.add(commentRestored)
                println("Комментарий восстановлен")
                true
            } else {
                println("Невозможно восстановить комментарий")
                false
            }
        }
        return isRestored
    }
}