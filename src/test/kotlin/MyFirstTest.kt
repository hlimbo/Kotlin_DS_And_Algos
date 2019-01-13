import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class MyFirstTest : FunSpec({
    test("First Test") {
        val sum = 2 + 2
        sum.shouldBe(4)
    }
})