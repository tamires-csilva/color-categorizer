data class Color(val colorInput: String,val waveLength: Int)

class Categorizer(val color: Color){
    private val colorCategoryList = mutableListOf<String?>()
    fun categorizaMensagem(): MutableList<String?> {
        colorCategoryList.add(primaryColor().verifyPrimaryColor(color))
        colorCategoryList.add(secondaryColor().verifySecondaryColor(color))
        colorCategoryList.add(waveLengthUpTo500().verifyWaveLengthUpTo500(color))
        colorCategoryList.add(waveLengthUpTo600().verifyWaveLengthBetween500And600(color))
        colorCategoryList.add(waveLengthBetween601And700().verifyWaveLengthBetween601And700(color))
        colorCategoryList.add(waveLengthUpTo700().verifyWaveLengthUpTo700(color))
        return colorCategoryList
    }
}
class primaryColor{
    fun verifyPrimaryColor(color: Color): String? {
        val words = listOf("amarelo", "azul", "vermelho")
        words.forEach { word ->
            if (color.colorInput.contains(Regex(word,RegexOption.IGNORE_CASE))) return "Primary"
        }
        return null
    }
}
class secondaryColor{
    fun verifySecondaryColor(color: Color): String? {
        val words = listOf("laranja", "roxo", "verde")
        words.forEach { word ->
            if (color.colorInput.contains(Regex(word,RegexOption.IGNORE_CASE)) )return "Secondary"
        }
        return null
    }
}

class waveLengthUpTo500{
    fun verifyWaveLengthUpTo500(color: Color): String? {
        if(color.waveLength < 500) return "<= 500 nm"
        return null
    }
}

class waveLengthUpTo600{
    fun verifyWaveLengthBetween500And600(color: Color): String? {
        if(color.waveLength in 501..600) return ">500 ~ 600 nm"
        return null
    }
}
class waveLengthBetween601And700{
    fun verifyWaveLengthBetween601And700(color: Color): String? {
        if(color.waveLength in 601..700) return ">600 ~ 700 nm"
        return null
    }
}

class waveLengthUpTo700{
    fun verifyWaveLengthUpTo700(color: Color): String? {
        if(color.waveLength in 601..700) return "Not visible"
        return null
    }
}