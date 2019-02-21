import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem54Test : FunSpec({
    test("subgrid conversion test") {
        val dp = DailyProblem54()
        val unfilled = 0
        val board = Array(9) { IntArray(9) }

        board[0] = arrayOf(4, 0, 0, 0, 0, 0, 9, 3, 8).toIntArray()
        board[1] = arrayOf(0, 3, 2, 0, 9, 4, 1, 0, 0).toIntArray()
        board[2] = arrayOf(0, 9, 5, 3, 0, 0, 2, 4, 0).toIntArray()
        board[3] = arrayOf(3, 7, 0, 6, 0, 9, 0, 0, 4).toIntArray()
        board[4] = arrayOf(5, 2, 9, 0, 0, 1, 6, 7, 3).toIntArray()
        board[5] = arrayOf(6, 0, 4, 7, 0, 3, 0, 9, 0).toIntArray()
        board[6] = arrayOf(9, 5, 7, 0, 0, 8, 3, 0, 0).toIntArray()
        board[7] = arrayOf(0, 0, 3, 9, 0, 0, 4, 0, 0).toIntArray()
        board[8] = arrayOf(2, 4, 0, 0, 3, 0, 7, 0, 9).toIntArray()

        // add initial unfilled cell data
        val unfilledCells = ArrayList<DailyProblem54.Cell>()
        for((rowIndex, row) in board.withIndex()) {
            for((colIndex, col) in row.withIndex()) {
                if(col == unfilled)
                    unfilledCells.add(dp.Cell(rowIndex, colIndex))
            }
        }
        // sub-grid values exclusion


        val sectors = arrayOf(
            Pair(0, 0), Pair(0, 1), Pair(0, 2),
            Pair(1, 0), Pair(1, 1), Pair(1, 2),
            Pair(2, 0), Pair(2, 1), Pair(2, 2))

        // check first sector
        val firstSector = Pair(0, 0)
        val firstSectorArr = Array(3) { IntArray(3) }
        firstSectorArr[0] = arrayOf(4, 0, 0).toIntArray()
        firstSectorArr[1] = arrayOf(0, 3, 2).toIntArray()
        firstSectorArr[2] = arrayOf(0, 9, 5).toIntArray()

        for(ir in 0 until 3) {
            var normalizedRow = (3 * firstSector.first) + ir
            for(ic in 0 until 3) {
                var normalizedCol = (3 * firstSector.second) + ic
                board[normalizedRow][normalizedCol].shouldBe(firstSectorArr[ir][ic])
            }
        }

        // check second sector
        val secondSector = Pair(0, 1)
        val secondSectorArr = Array(3) { IntArray(3) }
        secondSectorArr[0] = arrayOf(0, 0, 0).toIntArray()
        secondSectorArr[1] = arrayOf(0, 9, 4).toIntArray()
        secondSectorArr[2] = arrayOf(3, 0, 0).toIntArray()

        for(ir in 0 until 3) {
            var normalizedRow = (3 * secondSector.first) + ir
            for(ic in 0 until 3) {
                var normalizedCol = (3 * secondSector.second) + ic
                board[normalizedRow][normalizedCol].shouldBe(secondSectorArr[ir][ic])
            }
        }

        // check third sector

        // check fourth sector

        // check fifth sector

        // check sixth sector

        // check seventh sector

        // check eighth sector

        // check ninth sector
    }
//    test("First Test Case") {
//        val dp = DailyProblem54()
//        val unfilled = 0
//        val board = Array(9) { IntArray(9) }
//
//        board[0] = arrayOf(4, 0, 0, 0, 0, 0, 9, 3, 8).toIntArray()
//        board[1] = arrayOf(0, 3, 2, 0, 9, 4, 1, 0, 0).toIntArray()
//        board[2] = arrayOf(0, 9, 5, 3, 0, 0, 2, 4, 0).toIntArray()
//        board[3] = arrayOf(3, 7, 0, 6, 0, 9, 0, 0, 4).toIntArray()
//        board[4] = arrayOf(5, 2, 9, 0, 0, 1, 6, 7, 3).toIntArray()
//        board[5] = arrayOf(6, 0, 4, 7, 0, 3, 0, 9, 0).toIntArray()
//        board[6] = arrayOf(9, 5, 7, 0, 0, 8, 3, 0, 0).toIntArray()
//        board[7] = arrayOf(0, 0, 3, 9, 0, 0, 4, 0, 0).toIntArray()
//        board[8] = arrayOf(2, 4, 0, 0, 3, 0, 7, 0, 9).toIntArray()
//
//        // add initial unfilled cell data
//        val unfilledCells = ArrayList<DailyProblem54.Cell>()
//        for((rowIndex, row) in board.withIndex()) {
//            for((colIndex, col) in row.withIndex()) {
//                if(col == unfilled)
//                    unfilledCells.add(dp.Cell(rowIndex, colIndex))
//            }
//        }
//
//        val sudoku = dp.SudokuBoard(board)
//        for(row in sudoku.board) {
//            println("row: ${row.size}")
//        }
//
//        // remove candidates per cell based on initial board state given
//        // spit out all possible candidates a cell can be given the initial board state
//        for(unfilledCell in unfilledCells) {
//            val rowOfInterest = unfilledCell.row
//            val colOfInterest = unfilledCell.col
//
//            // column values exclusion
//            for((colIndex, col) in sudoku.board[rowOfInterest].withIndex()) {
//                // don't exclude self
//                if(colOfInterest != colIndex)
//                    unfilledCell.removeCandidate(col)
//            }
//
//            // row values exclusion
//            for(rowIndex in 0 until sudoku.board.size) {
//                val row: Int = sudoku.board[rowIndex][colOfInterest]
//                // don't exclude self
//                if(rowIndex != rowOfInterest)
//                    unfilledCell.removeCandidate(row)
//            }
//        }
//    }
})