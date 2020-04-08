interface Repository<ColorEntity> {

    fun save(entity: ColorEntity)
    fun findAll(parametro: Int): Pair<List<ColorEntity?>,List<String>>
}

class MessageRepositoryCollection: Repository<Color> {
    private val messageList = mutableListOf<Color?>()

    override fun save(color: Color) {
        messageList.add(color)
    }
    fun findCategory(color: Color): List<String> {
        return Categorizer(color).categorizaMensagem().filterNotNull()
    }
    override fun findAll(elemento: Int):Pair<List<Color?>,List<String>> {
        val message = messageList.get(elemento)
        findCategory(message!!)
        return Pair(listOf(message),findCategory(message))
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

