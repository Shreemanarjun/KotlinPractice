
import java.text.DateFormat
import kotlin.io.*

import kotlin.text.*

// Complete the dayOfProgrammer function below.
fun dayOfProgrammer(year: Int): String {
    if (year==1918){
        return "26.09.$year"
    }
    if (isLeap(year)) return  "12.09.$year"
    else
        return "13.09.$year"

}
fun isLeap(year: Int):Boolean{
    return when {
        (year%4) != 0 -> false
        else -> {
            when {
                year > 1918 && year % 100 == 0 && year % 400 != 0 -> false
                else -> true
            }
        }
    }
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    val result = dayOfProgrammer(year)

    println(result)
}
