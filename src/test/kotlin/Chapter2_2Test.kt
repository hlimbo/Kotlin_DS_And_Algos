import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter2_2Test : FunSpec({
    val dp = Chapter2_2()
    test("First Test Case") {
        val list = arrayListOf("code", "edoc", "da", "d")
        val actualAnswer = dp.generatePalindromePairs(list)
        val expectedAnswer = arrayListOf(Pair(0, 1), Pair(1, 0), Pair(2, 3))

        actualAnswer.shouldBe(expectedAnswer)
    }
})