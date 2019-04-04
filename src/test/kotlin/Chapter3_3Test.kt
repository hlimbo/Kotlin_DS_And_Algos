import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter3_3Test : FunSpec({
    val dp = Chapter3_3()
    test("First Test Case") {
        var root: Chapter3_3.Node? = dp.Node(3, null)
        val next: Chapter3_3.Node? = dp.Node(5, null)
        root?.next = next

        println("Before")
        var ptr: Chapter3_3.Node? = root
        while(ptr != null) {
            println("Node: ${ptr?.data}")
            ptr = ptr?.next
        }

        root = dp.swap2AdjacentNodes(root, root, null)

        println("After")
        var ptr2: Chapter3_3.Node? = root
        while(ptr2 != null) {
            println("Node: ${ptr2?.data}")
            ptr2 = ptr2?.next
        }
    }

    test("Second Test Case") {
        val root: Chapter3_3.Node? = dp.Node(3, null)
        val next: Chapter3_3.Node? = dp.Node(5, null)
        root?.next = next

        println("Before")
        var ptr: Chapter3_3.Node? = root
        while(ptr != null) {
            println("Node: ${ptr?.data}")
            ptr = ptr?.next
        }

        val root2 = dp.swap2AdjacentNodes(root, root, null)

        println("After")
        var ptr2: Chapter3_3.Node? = root2
        while(ptr2 != null) {
            println("Node: ${ptr2?.data}")
            ptr2 = ptr2?.next
        }
    }
})