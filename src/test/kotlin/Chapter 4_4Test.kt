import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter4_4Test : FunSpec({
    val dp = Chapter4_4()
    test("First Test Case") {
        val hints = arrayListOf<String>("None", "+", "+", "-", "+")
        val answer = dp.reconstructArray(hints)
        for(a in answer) {
            println("$a")
        }
    }

})