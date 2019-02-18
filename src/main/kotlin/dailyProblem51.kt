class dp51 {
    // In Kotlin parameter arguments ARE NOT passed by reference
    // Parameter arguments are passed as val variables (read-only)
    fun swap(num1: Int, num2: Int) : Pair<Int,Int> {
        return Pair(num2, num1)
    }

    /*
        Order
        1 -> ACE
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11 -> JACK
        12 -> QUEEN
        13 -> KING
        Suits
        Ace
        Spade
        Club
        Heart
     */
    inner class Card(val value: Int, val suit: String)
}

// assumption 1: randomNum is a perfectly randomly generated number that is used to make a set of swaps
fun dailyProblem51(randomNum: Int, deckOfCards: ArrayList<dp51.Card>) : ArrayList<dp51.Card> {
    val dp = dp51()
    val shuffledDeck = ArrayList<dp51.Card>(deckOfCards)

    // how does randomNum retrieved from an outside function help me solve this problem?
    // swapping procedure goes here... think about how to swap the cards such that
    // the input order != output order

    return shuffledDeck
}