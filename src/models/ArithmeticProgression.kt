package models

 object ArithmeticProgression {

   fun findCommonDifference(termList: List<Int>) :Int{
        if(termList.size < 2) {
            println("Can't find the common difference: Number of terms is less than 2")
            return 0
        }
        if (!isAP(termList)){
            println("Can't return D, not an AP!")
            return 0
        }

       return termList[1] - termList[0]
   }
     fun isAP(termList: List<Int>):Boolean{
         val resultList = ArrayList<Int>()
         val expectedD = termList[1] - termList[0]
         for (i in termList.size - 1 downTo 1) {
            //d = difference
             val result = termList[i] - termList[i - 1]
             if (result != expectedD){
//                 println("Not an AP!")
                 return false
             }
             resultList.add(result)
//             println(result)

         }
//         println(resultList)
         return true
     }

     fun countNumberOfTerms(termList: List<Int>) :Int{
        return termList.size
     }
     fun findNTerm(termList: List<Int>, n:Int):Int{
        //an = a1 + (n-1)*d
         val an :Int = termList[0] + (n - 1) * findCommonDifference(termList)
         return an
     }
     fun sumNFiniteTermsFirstAndLastTermKnown(termList: List<Int>, n:Int):Int{
         //SUM OF THE FIRST N TERMS
         //Sn = n/2 (a1 + an) - NEEDS DOUBLE TO WORK
         //Sn = n * (a1 + an)/2 - BY CHANGING THE OPERATION ORDER(MULTIPLYING FIRST) INT CAN BE USED
         //val sum = n/2 * (termList[0] + findNTerm(termList, n))
         val sum = n * (termList[0] + findNTerm(termList, n)) / 2
         return sum
     }
 }
