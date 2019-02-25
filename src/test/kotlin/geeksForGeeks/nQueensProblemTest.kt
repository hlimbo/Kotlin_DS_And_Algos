package geeksForGeeks

import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class NQueensProblemTest : FunSpec({
    val queenPiece = 1
    val freePiece = 0


    // more of an integration test rather than a unit test
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
        if(solvable) {
            // 1. find all queen positions
            val queenPositions = ArrayList<Pair<Int, Int>>()
            for((rowIndex, row) in queens.chessBoard.withIndex()) {
                for((colIndex, piece) in row.withIndex()) {
                    if(piece == queenPiece)
                        queenPositions.add(Pair(rowIndex, colIndex))
                }
            }

            // 2. for each queen position, find all attacking positions
            val attackingPositions = ArrayList<Pair<Int, Int>>()
            for(queenPosition in queenPositions) {
                val positions: ArrayList<Pair<Int, Int>> = queens.queenAttackingPositions(queenPosition.first, queenPosition.second)
                attackingPositions.addAll(positions)
            }

            // 3. if any queen is on an attacking position, then make this test fail
            // otherwise, this test passes
            for(queenPosition in queenPositions) {
                for(attackingPosition in attackingPositions) {
                    val canBeAttacked = queenPosition.first == attackingPosition.first && queenPosition.second == attackingPosition.second
                    canBeAttacked.shouldBeFalse()
                }
            }
        }
        println(queens)
    }
})