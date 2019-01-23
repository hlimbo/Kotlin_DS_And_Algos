import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.specs.FunSpec

class DailyProblem25Test : FunSpec({
    test("Test Case 1: given regular exp 'ra.' and string 'ray'") {
        val regExp = "ra."
        val str = "ray"

        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test Case 2: given regular exp 'ra.' and string 'raymond'") {
        val regExp = "ra."
        val str = "raymond"

        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 3: given regular exp '.*at' and string 'chat'") {
        val regExp = ".*at"
        val str = "chat"

        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 4: given regular exp '.*at' and string 'chats'") {
        val regExp = ".*at"
        val str = "chats"
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 5: given regular exp '*.at' and string 'chat'") {
        val regExp = "*.at"
        val str = "chat"
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 6: given regular exp '.*' and string 'abcdefghijklmnopqrstuvwyz'") {
        val regExp = ".*"
        val str = "abcdefghijklmnopqrstuvwyz"
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 7: given regular exp '.....' and string 'abcde'") {
        val regExp = "....."
        val str = "abcde"
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 8: given regular exp '.....' and string 'abcdef'") {
        val regExp = "....."
        val str = "abcdef"
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 9: given regular exp '*' and string ''") {
        val regExp = "*"
        val str = ""
        val answer : Boolean = dailyProblem25(str, regExp)
        answer.shouldBeFalse()
    }
})

class DailyProblem25StackTest : FunSpec({
    test("Test Case 1: given regular exp 'ra.' and string 'ray'") {
        val regExp = "ra."
        val str = "ray"

        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test Case 2: given regular exp 'ra.' and string 'raymond'") {
        val regExp = "ra."
        val str = "raymond"

        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 3: given regular exp '.*at' and string 'chat'") {
        val regExp = ".*at"
        val str = "chat"

        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 4: given regular exp '.*at' and string 'chats'") {
        val regExp = ".*at"
        val str = "chats"
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 5: given regular exp '*.at' and string 'chat'") {
        val regExp = "*.at"
        val str = "chat"
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 6: given regular exp '.*' and string 'abcdefghijklmnopqrstuvwyz'") {
        val regExp = ".*"
        val str = "abcdefghijklmnopqrstuvwyz"
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 7: given regular exp '.....' and string 'abcde'") {
        val regExp = "....."
        val str = "abcde"
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeTrue()
    }

    test("Test case 8: given regular exp '.....' and string 'abcdef'") {
        val regExp = "....."
        val str = "abcdef"
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeFalse()
    }

    test("Test case 9: given regular exp '*' and string ''") {
        val regExp = "*"
        val str = ""
        val answer : Boolean = dailyProblem25Stack(str, regExp)
        answer.shouldBeFalse()
    }
})