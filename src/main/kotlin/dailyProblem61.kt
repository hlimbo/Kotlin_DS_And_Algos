class DailyProblem61 {
    // o notation of this solution is o(n) because we are multiplying the base one at a time
    fun powNaive(x: Int, y: Int) : Int {
        var answer = 1
        for(i in 0 until y)
            answer *= x

        return answer
    }

    // o notation of this solution is o(n) because we are multiplying the base one at a time
    fun powNaiveRecursive(x: Int, y: Int) : Int {
        if(y == 0)
            return 1
        return x * powNaiveRecursive(x,y - 1)
    }


    // goal of this algorithm is to minimize the number of multiplication operations to be done through memoization
    // lookup table (memoization) where key = (x,y) exponent pair
    // and value = answer of exponent pair
    // o notation of this algorithm if o(logn) because we are memoizing (caching previous values that were already calculated)
    // and using those to build up the answer
    // this requires however space on the stack and call overhead..
    fun powFast(x: Int, y: Int, inLeftTree: Boolean, inRightTree: Boolean, lookup: HashMap<Pair<Int, Int>, Int>) : Int {
    // debug
//        println("x: $x | y: $y")
//        println("inLeftTree: $inLeftTree")
//        println("inRightTree: $inRightTree")
        // base cases
        if(y == 0)
            return 1
        if(y == 1) {
            return x
        }

        // check if we already have the answer before calculating further
        val expPair = Pair(x, y)
        if(lookup.containsKey(expPair)) {
            return lookup[expPair]!!
        }

        val remainder = y % 2
        val split = y / 2
        var finalAnswer = 1
        if(remainder == 0) {
            val intermediateAnswer1 = powFast(x, split, true, false, lookup)
            val intermediateAnswer2 = powFast(x, split, false, true, lookup)
            finalAnswer = intermediateAnswer1 * intermediateAnswer2
        } else {
            val rightHalf = remainder + split
            val intermediateAnswer1 = powFast(x, split, true, false, lookup)
            val intermediateAnswer2 = powFast(x, rightHalf, false, true, lookup)
            finalAnswer = intermediateAnswer1 * intermediateAnswer2
        }

        if(!lookup.containsKey(expPair))
            lookup[expPair] = finalAnswer

        return finalAnswer


        // Fail code
        // check parity (even/odd)
//        val remainder = y % 2
//        val split = y / 2
//        var finalAnswer = 1
//        if(remainder == 0) {
//            val intermediateAnswer1 = x * powFast(x, split, true, false, lookup)
//            val evenExpPair = Pair(x, split + 1)
//            if(!lookup.containsKey(evenExpPair)) {
//                lookup[evenExpPair] = intermediateAnswer1
//                println("Intermediate Answer1 even leftTree: [${evenExpPair.first}, ${evenExpPair.second}] => $intermediateAnswer1")
//            }
//            val intermediateAnswer2 = x * powFast(x, split, false, true, lookup)
//            finalAnswer = intermediateAnswer1 * intermediateAnswer2
//        } else {
//            val intermediateAnswer1 = x * powFast(x, split, true, false, lookup)
//            val evenExpPair = Pair(x, split + 1)
//            if(!lookup.containsKey(evenExpPair)) {
//                lookup[evenExpPair] = intermediateAnswer1
//                println("Intermediate Answer1 odd leftTree: [${evenExpPair.first}, ${evenExpPair.second}] => $intermediateAnswer1")
//            }
//            val intermediateAnswer2 = x * powFast(x, remainder, false, true, lookup)
//            val oddExpPair = Pair(x , remainder)
//            if(!lookup.containsKey(oddExpPair)) {
//                lookup[oddExpPair] = intermediateAnswer2
//                println("Intermediate Answer2 odd rightTree: [${oddExpPair.first}, ${oddExpPair.second}] => $intermediateAnswer2")
//            }
//
//            finalAnswer = intermediateAnswer1 * intermediateAnswer2
//        }

        // return finalAnswer
    }
}