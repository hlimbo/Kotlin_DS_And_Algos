import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DailyProblem51Test : FunSpec({
    test("First Test Case") {
        val suits = arrayListOf("Hearts", "Diamonds", "Spades", "Clubs")
        val ace = 1
        val jack = 11
        val queen = 12
        val king = 13
        val values = arrayListOf(ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king)
        val dp = dp51()
        // construct deck of standard playing cards (anglo-american)
        val deckOfCards = ArrayList<dp51.Card>()
        for(value in values) {
            for(suit in suits) {
                deckOfCards.add(dp.Card(value, suit))
            }
        }

        println("Deck of Cards: $deckOfCards")
        val shuffledDeck: ArrayList<dp51.Card> = dailyProblem51(deckOfCards)
        println("Shuffled Deck: $shuffledDeck")
    }
})