import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter4_3Test : FunSpec({
    val dp = Chapter4_3()
    test("First Test Case") {

        val arr = ArrayList<Int>()
        arr.add(10)
        arr.add(5)
        arr.add(2)
        arr.add(7)
        arr.add(8)
        arr.add(7)
        val k = 3

        dp.computeMaxKLengthSubArrays(arr, k)
    }

})