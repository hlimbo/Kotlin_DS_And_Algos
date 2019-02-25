package geeksForGeeks

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class NQueensProblemTest : FunSpec({
    test("First Test Case - 4x4 chessboard") {
        val n = 4

        // NOTE: multiple solutions may exist the expected board state below
        // is one of many solutions
        val expectedChessBoardState = Array(n) { IntArray(n) }
        expectedChessBoardState[0] = intArrayOf(0, 1, 0, 0)
        expectedChessBoardState[1] = intArrayOf(0, 0, 0, 1)
        expectedChessBoardState[2] = intArrayOf(1, 0, 0, 0)
        expectedChessBoardState[3] = intArrayOf(0, 0, 1, 0)

        // to verify if the board is TRULY solvable, test code would need to take the
        // solved chessboard state and see if it made any violations (e.g. a queen can attack another queen on the board)
        val queens = NQueensProblem(n)
        println("BEFORE")
        println(queens)
        val solvable = queens.isSolvable()
        println("Solvable: $solvable")
        println(queens)
    }
})