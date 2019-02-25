import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem56Test : FunSpec({
    test("First Test Case") {
        val dp = DailyProblem56()
        val graph = dp.UndirectedGraph(3)

        val matrix = Array<IntArray>(3) { IntArray(3) }
        matrix[0] = intArrayOf(0, 1, 1)
        matrix[1] = intArrayOf(1, 0, 1)
        matrix[2] = intArrayOf(1, 1, 0)

        graph.construct(matrix, 3)

        for(v in graph.vertices) {
            println("v: ${v.label}")
            for(other in v.verticesRef) {
                println("other: $other")
                println("other color choices: ${other.colorChoices}")
            }
        }
    }
})