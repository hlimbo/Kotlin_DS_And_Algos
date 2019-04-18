class Chapter4_4 {
    fun reconstructArray(hints: ArrayList<String>): ArrayList<Int> {
        val answer = ArrayList<Int>()
        var startValue = 1
        for(hint in hints) {
            when(hint) {
                "None" -> answer.add(startValue)
                "+" -> {
                    startValue += 1
                    answer.add(startValue)
                }
                "-" -> {
                    startValue -= 1
                    answer.add(startValue)
                }
                else -> {
                    println("Unsupported hint: ${hint}")
                }
            }
        }

        return answer
    }

    inner class Stack {
        private val theStack = ArrayList<Int>()
        fun push(num: Int) {
            theStack.add(num)
        }

        fun pop(): Int {
            return theStack.removeAt(theStack.size - 1)
        }

        fun isEmpty(): Boolean {
            return theStack.isEmpty()
        }
    }


    fun reconstructArrayCorrect(hints: ArrayList<String>): ArrayList<Int> {
        val n = hints.size - 1
        val answer = ArrayList<Int>()
        val theStack = Stack()

        for(i in 0 until n) {
            if(hints[i + 1] == "-") {
                println("Pushing $i")
                theStack.push(i)
            } else {
                answer.add(i)
                while(!theStack.isEmpty()) {
                    answer.add(theStack.pop())
                }
            }
        }

        theStack.push(n)

        while(!theStack.isEmpty()) {
            answer.add(theStack.pop())
        }

        return answer
    }
}