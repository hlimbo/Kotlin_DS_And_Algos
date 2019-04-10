import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter4_2Test : FunSpec({
    val dp = Chapter4_2()
    test("First Test Case") {
        val brackets = "([])[]({})"
        val answer = dp.areBracketsBalanced(brackets)
        answer.shouldBeTrue()
    }

    test("Second Test Case") {
        val brackets = "([)]"
        val answer = dp.areBracketsBalanced(brackets)
        answer.shouldBeFalse()
    }

    test("Third Test Case") {
        val brackets = "((()"
        val answer = dp.areBracketsBalanced(brackets)
        answer.shouldBeFalse()
    }
})