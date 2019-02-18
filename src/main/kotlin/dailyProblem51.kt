import kotlin.random.Random

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
    inner class Card(val value: Int, val suit: String) {
        override fun toString(): String {
            return "Card Value: $value | Card Suit: $suit"
        }
    }
}

// assumption 1: randomNum is a perfectly randomly generated number that is used to make a set of swaps
// I got stuck due to the 3 constraints:
// 1. equally likely permutations
// 2. randomNum generated from a perfectly random number generator
// 3. O(n) time complexity
fun dailyProblem51(deckOfCards: ArrayList<dp51.Card>) : ArrayList<dp51.Card> {
    val shuffledDeck = ArrayList<dp51.Card>(deckOfCards)

    // apply fisher-yates algorithm here as well to achieve O(n) time complexity
    // don't go to first element since selecting a random index from array from 0 to 0 = 0
    for(i in (shuffledDeck.size - 1) downTo 1) {
        val j = Random.nextInt(i + 1)
        // swap
        val tmp = shuffledDeck[i]
        shuffledDeck[i] = shuffledDeck[j]
        shuffledDeck[j] = tmp
    }

    return shuffledDeck
}