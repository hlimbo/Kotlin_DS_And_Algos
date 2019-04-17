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
}