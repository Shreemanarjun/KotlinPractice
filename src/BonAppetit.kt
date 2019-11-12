import java.util.*


    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val n = scanner.nextInt()
        val k = scanner.nextInt()
        var total = 0
        for (i in 0 until n) {
            val price = scanner.nextInt()
            if (i != k) total += price
        }
        val charged = scanner.nextInt()
        println(if (total / 2 == charged) "Bon Appetit" else charged - total / 2)
    }
