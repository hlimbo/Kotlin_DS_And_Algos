import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem55Test : FunSpec({
    test("First Test Case") {
        val dp = DailyProblem55()
        val url = "https://www.google.com"

        val shortString = dp.shorten(url)
        println("url: $url")
        println("short string: $shortString")
        val shortString2 = dp.shorten(url)
        // should print out the same short string if the url was already mapped a short string
        println("short string 2: $shortString2")
        val restoredUrl = dp.restore(shortString)
        println("restored url: $restoredUrl")
        restoredUrl.shouldBe(url)
    }

    test("Null restore Test Case") {
        val dp = DailyProblem55()

        val nullString: String? = dp.restore("mankey")
        nullString.shouldBe(null)
    }
})