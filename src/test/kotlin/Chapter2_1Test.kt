import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter2_1Test : FunSpec({
    val dp = Chapter2_1()
    test("First Test Case") {
        val word = "ab"
        val s = "abxaba"
        val startIndices: ArrayList<Int> = dp.findAnagramIndices2(word, s)
        val expectedIndices = arrayListOf(0, 3, 4)
        startIndices.shouldBe(expectedIndices)
    }

})