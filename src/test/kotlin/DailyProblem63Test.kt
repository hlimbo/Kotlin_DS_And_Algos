import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem63Test : FunSpec({
    test("First Test Case") {
        val n = 4
        val m = 4
        val matrix = Array(n) { CharArray(m)}
        matrix[0] = charArrayOf('F', 'A', 'C', 'I')
        matrix[1] = charArrayOf('O', 'B', 'Q', 'P')
        matrix[2] = charArrayOf('A', 'N', 'O', 'B')
        matrix[3] = charArrayOf('M', 'A', 'S', 'S')

        val expectedAnswer = true
        val actualAnswer: Boolean = dailyProblem63(matrix, "FOAM")
        actualAnswer.shouldBe(expectedAnswer)

        val expectedAnswer2 = true
        val actualAnswer2: Boolean = dailyProblem63(matrix, "MASS")
        actualAnswer2.shouldBe(expectedAnswer2)

        val expectedAnswer3 = false
        val actualAnswer3: Boolean = dailyProblem63(matrix, "GIRAFFE")
        actualAnswer3.shouldBe(expectedAnswer3)
    }

    test("Second Test Case") {
        val n = 5
        val m = 4
        val matrix = Array(n) { CharArray(m) }
        matrix[0] = charArrayOf('M','E', 'A', 'L')
        matrix[1] = charArrayOf('A', 'C', 'E', 'T')
        matrix[2] = charArrayOf('T', 'N', 'A', 'K')
        matrix[3] = charArrayOf('E', 'D', 'Z', 'X')
        matrix[4] = charArrayOf('I', 'O' ,'Q', 'S')

        val actualAnswer: Boolean = dailyProblem63(matrix, "MAT")
        actualAnswer.shouldBeTrue()

        val actualAnswer2: Boolean = dailyProblem63(matrix, "ACE")
        actualAnswer2.shouldBeTrue()

        val actualAnswer3: Boolean = dailyProblem63(matrix, "MEAL")
        actualAnswer3.shouldBeTrue()
    }
})