import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter3_4Test : FunSpec({
    val dp = Chapter3_4()
    test("First Test Case") {
        val nodeA: Chapter3_4.Node? = dp.Node(3, null)
        nodeA?.next = dp.Node(7, null)
        nodeA?.next?.next = dp.Node(8, null)
        nodeA?.next?.next?.next = dp.Node(10, null)

        val nodeB: Chapter3_4.Node? = dp.Node(99, null)
        nodeB?.next = dp.Node(1, null)
        nodeB?.next?.next = dp.Node(8, null)
        nodeB?.next?.next?.next = dp.Node(10, null)

        val node: Chapter3_4.Node? = dp.findIntersectingNode(nodeA, nodeB)
        node.shouldNotBe(null)
        node?.data.shouldBe(8)

        println("Intesecting Node value: ${node?.data}")
    }
})