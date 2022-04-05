import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addNote() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )

        //act
        val result : Boolean = NoteService.addNote(note1) == note1

        //assert
        assertTrue(result)
    }

    @Test
    fun addComment() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            1_00,
            "Текст комментария 1",
            false
        )

        //act
        val result : Boolean = NoteService.addComment(comment1) == comment1

        //assert
        assertTrue(result)
    }

    @Test
    fun deleteNote() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )
        NoteService.addNote(note1)

        //act
        NoteService.deleteNote(note1)
        val result : Boolean = notes.contains(note1)

        //assert
        assertFalse(result)
    }

    @Test
    fun deleteComment() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            1_00,
            "Текст комментария 1",
            false
        )
        NoteService.addComment(comment1)

        //act
        NoteService.deleteComment(comment1)
        val result : Boolean = comments.contains(comment1)

        //assert
        assertFalse(result)
    }


    @Test
    fun editNoteIsNotDeletedExist() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )

        //act
        NoteService.addNote(note1)
        val result : Boolean = NoteService.editNote(note1)

        //assert
        assertTrue(result)
    }

    @Test
    fun editNoteDeletedExist() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            true
        )

        //act
        NoteService.addNote(note1)
        val result : Boolean = NoteService.editNote(note1)

        //assert
        assertFalse(result)
    }


   @Test
    fun editNoteIsNotDeletedDoesNotExist() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )
        val note2 = Note(
            2,
            222,
            "Заметка 2",
            "Текст заметки 2",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )

        //act
        NoteService.addNote(note1)
        val result : Boolean = NoteService.editNote(note2)

        //assert
        assertFalse(result)
    }


    @Test
    fun editCommentIsNotDeletedExist() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            false
        )

        //act
        NoteService.addComment(comment1)
        val result : Boolean = NoteService.editComment(comment1)

        //assert
        assertTrue(result)
    }

    @Test
    fun editCommentIsNotDeletedNotExist() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            false
        )
        val comment2 = Comment(
            12,
            1,
            555,
            "message",
            false
        )

        //act
        NoteService.addComment(comment1)
        val result : Boolean = NoteService.editComment(comment2)

        //assert
        assertFalse(result)
    }

    @Test
    fun editCommentDeletedExist() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            true
        )

        //act
        NoteService.addComment(comment1)
        val result : Boolean = NoteService.editComment(comment1)

        //assert
        assertFalse(result)
    }


    @Test
    fun getNoteByOwnerId() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )

        //act
        NoteService.addNote(note1)
        val notesByOwnerId : MutableList<Note> = NoteService.getNoteByOwnerId(1_00)
        val result : Boolean = notesByOwnerId.contains(note1)

        //assert
        assertTrue(result)

    }


    @Test
    fun getDeletedNoteByOwnerId() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            true
        )

        //act
        NoteService.addNote(note1)
        val notesByOwnerId : MutableList<Note> = NoteService.getNoteByOwnerId(1_00)
        val result : Boolean = notesByOwnerId.contains(note1)

        //assert
        assertFalse(result)
    }


    @Test
    fun getNoteById() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            false
        )

        //act
        NoteService.addNote(note1)
        val result : Boolean = NoteService.getNoteById(1) == note1

        //assert
        assertTrue(result)
    }

    @Test
    fun getDeletedNoteById() {
        //arrange
        val notes = mutableListOf<Note>()
        notes.clear()
        val note1 = Note(
            1,
            1_00,
            "Заметка 1",
            "Текст заметки 1",
            110121,
            1,
            1,
            "www.note1.com",
            true
        )

        //act
        NoteService.addNote(note1)
        val result : Boolean = NoteService.getNoteById(1) == note1

        //assert
        assertFalse(result)
    }


    @Test
    fun getCommentsByNoteId() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            false
        )

        //act
        NoteService.addComment(comment1)
        val commentsByNoteId : MutableList<Comment> = NoteService.getCommentsByNoteId(1)
        val result : Boolean = commentsByNoteId.contains(comment1)

        //assert
        assertTrue(result)
    }


    @Test
    fun getDeletedCommentsByNoteId() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            true
        )
        NoteService.addComment(comment1)

        //act
        val commentsByNoteId : MutableList<Comment> = NoteService.getCommentsByNoteId(1)
        val result : Boolean = commentsByNoteId.contains(comment1)

        //assert
        assertFalse(result)
    }


    @Test
    fun restoreComment() {
        //arrange
        val comments = mutableListOf<Comment>()
        comments.clear()
        val comment1 = Comment(
            11,
            1,
            555,
            "message",
            true
        )
        NoteService.addComment(comment1)

        //act
        val result : Boolean = NoteService.restoreComment(comment1)

        //assert
        assertTrue(result)
    }
}