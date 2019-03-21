import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter1_4Test : FunSpec({
    val dp = Chapter1_4()

    test("First Test Case") {
        val arr = arrayListOf(3, 4, 9, 6, 1)
        val expectedAnswer = arrayListOf(1, 1, 2, 1, 0)

        val actualAnswer = dp.smallerElementsToRightNaive(arr)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Second Test Case") {
        val arr = arrayListOf(1, 2, 3, 4, 5)
        val expectedAnswer = arrayListOf(0, 0, 0, 0, 0)

        val actualAnswer = dp.smallerElementsToRightNaive(arr)
        actualAnswer.shouldBe(expectedAnswer)
    }
})