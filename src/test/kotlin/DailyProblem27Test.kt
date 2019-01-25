import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.specs.FunSpec

class DailyProblem27Test : FunSpec({
    test("First Positive Test Case") {
        val str = "([])[]({})"
        val answer : Boolean = DailyProblem27(str)
        answer.shouldBeTrue()
    }

    test("First Negative Test Case") {
        val str = "([)]"
        val answer : Boolean = DailyProblem27(str)
        answer.shouldBeFalse()
    }

    test("Second Negative Test Case") {
        val str = "((()"
        val answer : Boolean = DailyProblem27(str)
        answer.shouldBeFalse()
    }
})