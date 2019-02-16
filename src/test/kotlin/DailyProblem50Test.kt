import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.lang.ArithmeticException
import io.kotlintest.shouldThrow

/*
    Example:
                *
            /        \
           +          +
         /   \      /   \
        3     2    4     5

   Should evaluate to 45
 */
class DailyProblem50Test : FunSpec({
    test("First Test Case") {
        val dp = dp50()

        // hardcode construct the input
        // level 0
        val root: dp50.Node = dp.Node(null, '*')
        // level 1
        root.leftNode = dp.Node(null, '+')
        root.rightNode = dp.Node(null, '+')
        // level 2
        root.leftNode?.leftNode = dp.Node(3, null)
        root.leftNode?.rightNode = dp.Node(2, null)
        root.rightNode?.leftNode = dp.Node(4, null)
        root.rightNode?.rightNode = dp.Node(5, null)
        val bt = dp.BinaryTree(root)

        val expectedAnswer = 45
        val actualAnswer = dailyProblem50(bt)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Second Test Case") {
        val dp = dp50()

        // hardcode construct the tree input
        // level 0
        val root: dp50.Node = dp.Node(null, '/')
        // level 1
        root.leftNode = dp.Node(null, '+')
        root.rightNode = dp.Node(null, '-')
        // level 2
        root.leftNode?.leftNode = dp.Node(null, '*')
        root.leftNode?.rightNode = dp.Node(null, '+')
        root.rightNode?.leftNode = dp.Node(null, '+')
        root.rightNode?.rightNode = dp.Node(null, '+')
        // level 3
        root.leftNode?.leftNode?.leftNode = dp.Node(12, null)
        root.leftNode?.leftNode?.rightNode = dp.Node(5, null)
        root.leftNode?.rightNode?.leftNode = dp.Node(6, null)
        root.leftNode?.rightNode?.rightNode = dp.Node(4, null)

        root.rightNode?.leftNode?.leftNode = dp.Node(48, null)
        root.rightNode?.leftNode?.rightNode = dp.Node(2, null)
        root.rightNode?.rightNode?.leftNode = dp.Node(45, null)
        root.rightNode?.rightNode?.rightNode = dp.Node(3, null)

        val bt = dp.BinaryTree(root)

        val expectedAnswer = ((12 * 5) + (6 + 4)) / ((48 + 2) - (45 + 3)) // should be 35
        val actualAnswer: Int = dailyProblem50(bt)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Divide by zero Case") {
        val dp = dp50()
        val root: dp50.Node = dp.Node(null, '/')
        root.leftNode = dp.Node(5, null)
        root.rightNode = dp.Node(0, null)
        val bt = dp.BinaryTree(root)

        shouldThrow<ArithmeticException> {
            dailyProblem50(bt)
        }
    }
})