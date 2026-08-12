import models.ArithmeticProgression
import models.CombinatoricsCalculator
import kotlin.system.exitProcess

fun main() {

    val combinatoricsCalculator = CombinatoricsCalculator
    val arithmeticProgression = ArithmeticProgression
//    val n = 5
//    val k = 2
//
//    val result = calculator.calculateArrangement(n, k)
//    println(result)
    println("Choose the operation:\n1 - Combinatorics Calculator\n2 - Arithmetic Progression")
    val option: Int = readln().toInt()
    var result:Int = 0

    when (option) {
        1 -> {
            println("Type n: ")
            val n = readln().toInt()
            println("Type k: ")
            val k = readln().toInt()
            println("What to calculate: \n1 - Combinatorics \n2 - Arrangement ")
            val op = readln().toInt()
            if(op == 1){
                result = combinatoricsCalculator.calculateCombination(n, k)
                //println(combinatoricsCalculator.calculateCombination(n, k))
            }
            else if(op == 2){
                result = combinatoricsCalculator.calculateArrangement(n, k)
                //println(combinatoricsCalculator.calculateArrangement(n, k))
            }

        }
        2 -> {
         println("Enter your numbers separated by commas (e.g., 2, 4, 6, 8): ")
            val numbers = readln()
            val termList: List<Int> = numbers.split(",").map { it.trim().toInt() }
            if (!arithmeticProgression.isAP(termList)) exitProcess(1)
            println("What do you want to do?\n 1 - Find D\n2 - find Nth term\n3 - Sum of the first N terms(KNOWING THE FIRST AND LAST TERMS) ")
                val op = readln().toInt()
                var n:Int = 0
                if(op !=1){
                    println("Type n: ")
                    n = readln().toInt()
                }
            if(op == 1) {
                result = arithmeticProgression.findCommonDifference(termList)
                //println(arithmeticProgression.findCommonDifference(termList))
            }
            else if(op == 2) {
                //n = readln().toInt()
                result = arithmeticProgression.findNTerm(termList, n)
            }
            else if(op == 3){
                //println("Type n: ")
                 //n = readln().toInt()
                result = arithmeticProgression.sumNFiniteTermsFirstAndLastTermKnown(termList, n)
                //println(arithmeticProgression.sumNFiniteTermsFirstAndLastTermKnown(termList, n))
            }
        }
        else -> println("Value is unknown") // Acts like 'default:' in Java
    }
    print("Answer: $result")

}