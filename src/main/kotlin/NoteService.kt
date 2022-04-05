import java.awt.List

object NoteService {

    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()


    fun addNote(newNote: Note): Note {
        notes.add(newNote)
        return notes.last()
    }

    fun addComment(newComment: Comment): Comment {
        comments.add(newComment)
        return comments.last()
    }

    fun deleteNote(noteToDelete: Note): Boolean {
        val noteId = noteToDelete.component1()
        for (note in notes) {
            if (note.id == noteId)
                note.isDeleted
        }
        for (comment in comments) {
            if (comment.noteId == noteId)
                comment.isDeleted
        }
        return true
    }


    fun deleteComment(commentToDelete: Comment): Boolean {
        val commentId = commentToDelete.component1()
        for (comment in comments) {
            if (comment.noteId == commentId)
                comment.isDeleted
        }
        return true
    }

    fun editNote(noteToEdit: Note): Boolean {
        val noteId = noteToEdit.id
        var isEditedBoolean = false
        for (note in notes) {
            isEditedBoolean = if (!note.isDeleted && note.id == noteId) {
                val noteEdited = note.copy(title = "title отредактирован", text = "text отредактирован")
                notes.remove(note)
                notes.add(noteEdited)
                true
            } else {
                println("Невозможно отредактировать данную заметку, " +
                        "т.к она не существует или была удалена")
                false
            }
        }
        return isEditedBoolean
    }

    fun editComment(commentToEdit: Comment): Boolean {
        val commentId = commentToEdit.id
        var isEdited = false
        for (comment in comments) {
            isEdited = if (!comment.isDeleted && comment.id == commentId) {
                val commentEdited = comment.copy(message = "message отредактирован")
                comments.remove(comment)
                comments.add(commentEdited)
                true
            } else {
                println("Невозможно отредактировать данный комментарий, " +
                        "т.к он не существует или был удалён")
                false
            }
        }
        return isEdited
    }


    fun getNoteByOwnerId(noteOwnerId: Int): MutableList<Note> {
        val notesByOwnerId = mutableListOf<Note>()
        for (note in notes) {
            if (!note.isDeleted && note.ownerId == noteOwnerId) {
                notesByOwnerId.add(note)
            }
            println("Пользователя с таким id не существует, либо заметка была удалена")
        }
        println(notesByOwnerId)
        return notesByOwnerId
    }

    fun getNoteById(noteIdToGet: Int): Note? {
        var noteToGet: Note? = null
        for (note in notes) {
            if (!note.isDeleted && note.id == noteIdToGet) {
                noteToGet = note
            }
            println("Заметки с таким id не существует, либо она была удалена")
        }
        return noteToGet
    }


    fun getCommentsByNoteId(noteIdToGetComment: Int): MutableList<Comment> {
        val commentsByNoteId = mutableListOf<Comment>()
        for (comment in comments) {
            if (!comment.isDeleted && comment.noteId == noteIdToGetComment) {
                commentsByNoteId.add(comment)
            }
            println("Заметки с таким id не существует, либо она была удалена")
        }
        return commentsByNoteId
    }

    fun restoreComment(commentToRestore: Comment): Boolean {
        val commentId = commentToRestore.id
        var isRestored = false
        for (comment in comments) {
            isRestored = if (comment.isDeleted && comment.id == commentId) {
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


    fun printNotes() {
        for (note in notes) {
            println("note.id = " + note.id +
                    ", note.owner_id = " + note.ownerId +
                    ", note.title = " + note.title +
                    ", note.text = " + note.text +
                    ", isDeleted = " + note.isDeleted
            )
        }
    }

    fun printComments() {
        for (comment in comments) {
            println("comment.id = " + comment.id +
                    ", comment.noteId= " + comment.noteId +
                    ", comment.ownerId = " + comment.ownerId +
                    ", comment.message = " + comment.message +
                    ", isDeleted = " + comment.isDeleted
            )
        }
    }


}
