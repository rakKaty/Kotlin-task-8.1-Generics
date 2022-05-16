object NoteService : CrudService<Note> {

    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()


    override fun add(entity: Note): Note {
        notes.add(entity)
        return notes.last()
    }

    override fun delete(entity: Note) {
        val noteId = entity.component1()
        for (note in notes) {
            if (note.id == noteId)
                note.isDeleted
        }
        for (comment in comments) {
            if (comment.noteId == noteId)
                comment.isDeleted
        }
    }

    override fun edit(entity: Note) {
        val noteId = entity.id
        for (note in notes) {
            if (!note.isDeleted && note.id == noteId) {
                val noteEdited = note.copy(title = "title отредактирован", text = "text отредактирован")
                notes.remove(note)
                notes.add(noteEdited)
            } else {
                println("Невозможно отредактировать данную заметку, " +
                        "т.к она не существует или была удалена")
            }
        }
    }

    override fun getById(id: Int): Note? {
        var noteToGet: Note? = null
        for (note in notes) {
            if (!note.isDeleted && note.id == id) {
                noteToGet = note
            }
            println("Заметки с таким id не существует, либо она была удалена")
        }
        return noteToGet
    }

    override fun getByOwnerId(id: Int): MutableList<Note> {
        val notesByOwnerId = mutableListOf<Note>()
        for (note in notes) {
            if (!note.isDeleted && note.ownerId == id) {
                notesByOwnerId.add(note)
            }
            println("Пользователя с таким id не существует, либо заметка была удалена")
        }
        return notesByOwnerId
    }

    override fun restore(entity: Note) : Boolean {
        var isRestored = false
        for (note in notes) {
            isRestored = if (note.isDeleted && note.id == entity.id) {
                val noteRestored = note.copy(isDeleted = false)
                notes.remove(note)
                notes.add(noteRestored)
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
