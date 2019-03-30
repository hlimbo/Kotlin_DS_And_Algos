import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter2_3Test : FunSpec({
    val dp = Chapter2_3()
    test("First Test Case") {
        val sentence = "thisisazigzag"
        val k = 4
        val actualZigZag = dp.printZigZagForm(sentence, k)
        println("\nActual Zig Zag\n")
        println(actualZigZag)
    }
})