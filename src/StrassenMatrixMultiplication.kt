import java.util.*

fun show(a: Array<IntArray>){
    for (i in 0..a.size-1){

        for (j in 0..a[i].size-1)
                print( "${a[i][j]}  ")
        print("\n")
    }

}
fun input(a:Array<IntArray>){
    var sc=Scanner(System.`in`)
    var count=1;
    for (i in 0..a.size-1){
        for (j in 0..a[i].size-1) {
            println("Enter the ${count}${OrdinalNumber(count++)} element")
            a[i][j] = sc.nextInt()
        }
    }

}
fun `matrix checker`(r:Int):Boolean{
    var square=1
    while (r>=square){
        if (r==square){
            return true
        }
        square*=2
    }
    return false
}

fun Multiply(ar1:Array<IntArray>,ar2:Array<IntArray>):Array<IntArray>{
    var a=ar1[0][0]
    var b=ar1[0][1]
    var c=ar1[1][0]
    var d=ar1[1][1]
    var e=ar2[0][0]
    var f=ar2[0][1]
    var g=ar2[1][0]
    var h=ar2[1][1]
   var p1=a*(f-h)
    var p2=h*(a+b)
    var p3=(c+d)*e
    var p4=d*(g-e)
    var p5=(a+d)*(e+h)
    var p6=(b-d)*(g+h)
    var p7=(a-c)*(e+f)
    var ar3=Array(ar1.size,{IntArray(ar2[0].size)})
    ar3[0][0]=p6+p5+p4-p2
    ar3[0][1]=p1+p2
    ar3[1][0]=p3+p4
    ar3[1][1]=p1-p3+p5-p7
    return ar3

}
fun OrdinalNumber(n: Int): String {
    val lastdigit: Int = if (n <= 20) {
        n % 20
    } else {
        n % 10
    }
    return when (lastdigit) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}

fun main(){
    var sc=Scanner(System.`in`);
    println("Enter the row size of matrix")
    var r=sc.nextInt()
    println("Enter the column size of matrix")
    var c=sc.nextInt()

    var a=Array(r) {IntArray(c)}
    var b=Array(r) {IntArray(c)}
    if (r==c){
        if (`matrix checker`(r)){
            println("Matrix is compatible")
            println("Enter the 1st matrix")
            input(a)

            println("Enter the 2nd matrix")
            input(b)
            println("your matrixes are")
            show(a)
            show(b)
            println("The resultant matrix is")
            var c=Multiply(a, b)
            show(c)
        }
        else
            println("Matrix is incompatible .Order must be 2^n.")
    }
    else
        println("Matrix order must be in 2^n")




}