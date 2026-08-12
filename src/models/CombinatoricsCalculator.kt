package models

object CombinatoricsCalculator {
//C(n, k) = n/k = n!/k!(n-k)!
    fun validate(n:Int, k:Int) :Boolean {
        if (n < 0 || k < 0){
            println("n and k should be positive")
            return false
        }
        if(k > n){
            println("Combination is Zero!")
        }
        return true
    }

   fun calculateCombination(n:Int, k:Int) :Int {
       if (k < 0 || n < 0) throw IllegalArgumentException("n e k devem ser positivos")
       if (k > n) return 0 // Matematicamente, escolher mais que o disponível é 0
       if (k == 0 || k == n) return 1 // Casos triviais

       // 2. Otimização de Simetria: C(n, k) = C(n, n-k)
       // Se k for maior que a metade, calculamos a parte menor para economizar loops
       //tipo se a combinacao for C(100, 98), subtraimos n pelo k e temos C(100, 100 - 98) - C(n, n-k)
       //checando pela metade de n pois não faz sentido usar (n-k) para combinacoes onde o k é igual a metade do n, pois da na mesma: ex: C(n:10, k:5) (n-k) = (10 - 5) = 5 = k
       val effectiveK = if (k > (n / 2)) n - k else k

       // 3. Cálculo Iterativo (A Mágica da Eficiência)
       var result: Int = 1

       for (i in 1..effectiveK) {
           // A fórmula iterativa: result = result * (n - i + 1) / i
           // Multiplicamos antes de dividir para manter a precisão inteira
           result = result * ((n - i) + 1) / i
       }

       return result
   }
    fun calculateArrangement(n: Int, k: Int) :Int {
        if (k < 0 || n < 0) throw IllegalArgumentException("n e k devem ser positivos")
        if (k > n) return 0 // Impossível arranjar mais elementos do que os disponíveis
        if (k == 0) return 1 // Por definição, arranjar 0 elementos resulta em 1

        var result: Int = 1

        // 2. Loop multiplicativo (roda exatamente k vezes)
        for (i in 1..k) {
            // Multiplicamos o acumulado pelo termo decrescente a partir de n
            result = result * (n - i + 1)
            /* EXEMPLO: n = 5; k = 2
                Passo i = 1: result = 1 * (5 - 1 + 1) -> 1 * 5 = 5
                Passo i = 2: result = 5 * (5 - 2 + 1) -> 5 * 4 = 20
             */
        }

        return result
    }
}