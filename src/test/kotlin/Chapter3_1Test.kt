import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter3_1Test : FunSpec({
    val dp = Chapter3_1()
    test("First Test Case") {
        var root: Chapter3_1.Node? = dp.Node(3, null)
        var b: Chapter3_1.Node? = dp.Node(9, null)
        var c: Chapter3_1.Node? = dp.Node(8, null)
        var d: Chapter3_1.Node? = dp.Node(4, null)
        var e: Chapter3_1.Node? = dp.Node(2, null)

        root?.next = b
        b?.next = c
        c?.next = d
        d?.next = e

        var ptr: Chapter3_1.Node? = root
        println("Forward Order")
        while(ptr != null) {
            println("Node: ${ptr?.data}")
            ptr = ptr?.next
        }

        var reversed = dp.reversedLinkedList(root)
        var ptr2: Chapter3_1.Node? = reversed
        println("Reverse Order")
        while(ptr2 != null) {
            println("Node: ${ptr2?.data}")
            ptr2 = ptr2?.next
        }
    }
})