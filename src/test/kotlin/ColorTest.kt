import junit.framework.Assert.assertEquals
import org.junit.Test

class ColorTest {
    @Test
    fun `it creates a Color with a colorInput`() {
        val subject = buildColor(colorInput = "amarelo")

        assertEquals("amarelo", subject.colorInput)
    }
    @Test
    fun `it creates a Color with a waveLength`() {
        val subject = buildColor(waveLength = 700)

        assertEquals(700, subject.waveLength)
    }
    private fun buildColor(colorInput: String = "azul", waveLength: Int = 500): Color {
        return Color(colorInput = colorInput, waveLength = waveLength)
    }
}
