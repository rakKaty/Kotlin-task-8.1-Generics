fun main() {

   /* val note1 = Note(
        1,
        111,
        "Заметка 1",
        "Текст заметки 1",
        110121,
        1,
        1,
        "www.note1.com",
        true
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



    NoteService.addNote(note1)
    NoteService.printNotes()


    NoteService.editNote(note1)
    NoteService.printNotes()
*/

    val comments = mutableListOf<Comment>()
    val comment1 = Comment(
        11,
        1,
        555,
        "message",
        true
    )
    NoteService.addComment(comment1)
    NoteService.printComments()

    NoteService.restoreComment(comment1)
    NoteService.printComments()

}