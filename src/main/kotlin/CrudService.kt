interface CrudService<E> {
    fun add(entity: E): E
    fun delete(entity: E)
    fun edit(entity: E)
    fun getById(id: Int): E?
    fun getByOwnerId(id: Int): MutableList<E>
    fun restore(entity: E) : Boolean
}