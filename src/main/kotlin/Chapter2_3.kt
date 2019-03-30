class Chapter2_3 {
    // o(k * n) solution where k is the number of rows and n is the number of columns
    fun printZigZagForm(sentence: String,k: Int) : String {
        val canvas = Array(k) { CharArray(sentence.length + 1) }

         // initialize canvas with whitespace and newlines
        for(r in 0 until canvas.size) {
            for(c in 0 until canvas[r].size) {
                if(c == canvas[r].size - 1) {
                    canvas[r][c] ='\n'
                } else {
                    canvas[r][c] = ' '
                }
            }
        }

        // construct string as a zigzag
        var rowCounter = 0
        var rowShifter = 1
        for(col in 0 until (canvas[canvas.size - 1].size - 1)) {
            canvas[rowCounter][col] = sentence[col]
            // change row direction
            if(rowCounter >= k - 1)
                rowShifter = -1
            else if(rowCounter <= 0)
                rowShifter = 1

            rowCounter += rowShifter
        }

        // convert array of char arrays into a string
        val builder = StringBuilder()
        for(r in 0 until canvas.size) {
            builder.append(canvas[r])
        }

        return builder.toString()
    }
}