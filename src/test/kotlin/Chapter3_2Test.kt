import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter3_2Test : FunSpec({
    val dp = Chapter3_2()
    test("First Test Case") {
        val node1 = dp.Node(9, null)
        node1.next = dp.Node(9, null)

        val node2 = dp.Node(1, null)
        node2.next = dp.Node(2, null)

        val sumLinkedList: Chapter3_2.Node? = dp.addTwoLinkedLists(node1, node2)

        var ptr = sumLinkedList
        while(ptr != null) {
            println("Number: ${ptr?.value}")
            ptr = ptr?.next
        }
    }
})