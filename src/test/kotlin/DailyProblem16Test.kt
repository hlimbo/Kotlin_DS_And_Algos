import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DailyProblem16Test : FunSpec({
    test("Test of Understanding") {
        val ds = DailyProblem16()
        val expectedLastRecordId : Long = 5
        ds.record(expectedLastRecordId)

        val actualLastRecordId : Long = ds.getLast(0)

        actualLastRecordId.shouldBe(expectedLastRecordId)
    }

    test("Get the 4th last item in the list") {
        val ds = DailyProblem16()
        val expectedLastRecordId : Long = 2

        val list : ArrayList<Long> = arrayListOf(1,2,3,4,5)
        list.forEach { orderId -> ds.record(orderId)}

        val actualLastRecordId : Long = ds.getLast(3)

        actualLastRecordId.shouldBe(expectedLastRecordId)
    }
})