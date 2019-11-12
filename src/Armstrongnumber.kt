import java.util.*
import kotlin.math.pow

fun main(){
val sc= Scanner(System.`in`)
    println("Enter a range")
    val num=sc.nextInt()
    for (i in 10..num){
        if (CheckArmstrong(i))
            print("$i \t")

    }

}
fun CheckArmstrong(num:Int):Boolean{
    var rem:Int
    val power=num.getpower()
    var sum=0.0
    var n=num
    do {
        rem=n%10
        sum+= rem.toDouble().pow(power.toDouble())
        n /= 10
    }while (n!=0)
    return num==sum.toInt()

}

fun Int.getpower():Int{
    var count =0
    var rem:Int
    var num=this
    do {
        rem=num%10;
        count++
        num/=10
    }while(num!=0)
    return count
}