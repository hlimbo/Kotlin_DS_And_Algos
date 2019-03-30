import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter2_4Test : FunSpec({
    val dp = Chapter2_4()
    test("First Test Case") {
        val str = "daily"
        val rotatedString = dp.rotateString(str,1)
        println(rotatedString)

        val uniques = dp.uniquePermutations(str, 1)
        for(unique in uniques) {
            println(unique)
        }

        val answer = dp.determineLexicographicRotatedString(str, 5)
        println("Answer: $answer")
    }
})