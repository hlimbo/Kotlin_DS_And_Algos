 fun dailyProblem63(matrix: Array<CharArray>, targetWord: String): Boolean {
    if(targetWord.length > matrix.size && targetWord.length > matrix[0].size) {
        return false
    }

    // horizontal search
     var isWordFoundHoriz = false
     for(r in 0 until matrix.size) {
         var targetWordIndex = 0
         for(c in 0 until matrix[r].size) {
            if(matrix[r][c] == targetWord[targetWordIndex]) {
                targetWordIndex += 1
                isWordFoundHoriz = true
            } else {
                isWordFoundHoriz = false
                break
            }
             // prevent index out of bounds exception ~ can have targetWord < m or targetWord < n
             if(targetWordIndex >= targetWord.length)
                 break
         }

         if(isWordFoundHoriz)
             break
     }

     // vertical search
     var isWordFoundVert = false
     for(c in 0 until matrix[0].size) {
         var targetWordIndex = 0
         for(r in 0 until matrix.size) {
             if(matrix[r][c] == targetWord[targetWordIndex]) {
                 targetWordIndex += 1
                 isWordFoundVert = true
             } else {
                 isWordFoundVert = false
                 break
             }

             // prevent index out of bounds exception ~ can have targetWord < m or targetWord < n
             if(targetWordIndex >= targetWord.length)
                 break
         }

         if(isWordFoundVert)
             break
     }

     return isWordFoundHoriz || isWordFoundVert
}