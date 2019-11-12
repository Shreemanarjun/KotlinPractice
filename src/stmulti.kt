import java.util.*

fun sub(A:Array<IntArray>, B:Array<IntArray>) :Array<IntArray>{
    val n=A.size
    val c=Array(n){IntArray(n)}
    for (i in 0 until n){
        for (j in 0 until n){
            c[i][j]=A[i][j]-B[i][j]
        }
    }
    return c
}
fun add( A:Array<IntArray>,B:Array<IntArray>) :Array<IntArray>{
    val n=A.size
    val c=Array(n){IntArray(n)}
    for (i in 0 until n){
        for (j in 0 until n){
            c[i][j]=A[i][j]+B[i][j]
        }
    }
    return c
}
fun split(P: Array<IntArray>, C: Array<IntArray>, iB: Int, jB: Int) {
    var i1 = 0
    var i2 = iB
    while (i1 < C.size) {
        run {
            var j1 = 0
            var j2 = jB
            while (j1 < C.size) {
                C[i1][j1] = P[i2][j2]
                j1++
                j2++
            }
        }
        i1++
        i2++
    }
}
fun join(C: Array<IntArray>, P: Array<IntArray>, iB: Int, jB: Int) {
    var i1 = 0
    var i2 = iB
    while (i1 < C.size) {
        run {
            var j1 = 0
            var j2 = jB
            while (j1 < C.size) {
                P[i2][j2] = C[i1][j1]
                j1++
                j2++
            }
        }
        i1++
        i2++
    }
}
fun multiply(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val n = A.size
    val R = Array(n) { IntArray(n) }
    /** base case  */
    if (n == 1)
        R[0][0] = A[0][0] * B[0][0]
    else {
        val A11 = Array(n / 2) { IntArray(n / 2) }
        val A12 = Array(n / 2) { IntArray(n / 2) }
        val A21 = Array(n / 2) { IntArray(n / 2) }
        val A22 = Array(n / 2) { IntArray(n / 2) }
        val B11 = Array(n / 2) { IntArray(n / 2) }
        val B12 = Array(n / 2) { IntArray(n / 2) }
        val B21 = Array(n / 2) { IntArray(n / 2) }
        val B22 = Array(n / 2) { IntArray(n / 2) }

        /** Dividing matrix A into 4 halves  */
        split(A, A11, 0, 0)
        split(A, A12, 0, n / 2)
        split(A, A21, n / 2, 0)
        split(A, A22, n / 2, n / 2)
        /** Dividing matrix B into 4 halves  */
        split(B, B11, 0, 0)
        split(B, B12, 0, n / 2)
        split(B, B21, n / 2, 0)
        split(B, B22, n / 2, n / 2)

        /**
         * M1 = (A11 + A22)(B11 + B22)
         * M2 = (A21 + A22) B11
         * M3 = A11 (B12 - B22)
         * M4 = A22 (B21 - B11)
         * M5 = (A11 + A12) B22
         * M6 = (A21 - A11) (B11 + B12)
         * M7 = (A12 - A22) (B21 + B22)
         */

        val M1 = multiply(add(A11, A22), add(B11, B22))
        val M2 = multiply(add(A21, A22), B11)
        val M3 = multiply(A11, sub(B12, B22))
        val M4 = multiply(A22, sub(B21, B11))
        val M5 = multiply(add(A11, A12), B22)
        val M6 = multiply(sub(A21, A11), add(B11, B12))
        val M7 = multiply(sub(A12, A22), add(B21, B22))

        /**
         * C11 = M1 + M4 - M5 + M7
         * C12 = M3 + M5
         * C21 = M2 + M4
         * C22 = M1 - M2 + M3 + M6
         */
        val C11 = add(sub(add(M1, M4), M5), M7)
        val C12 = add(M3, M5)
        val C21 = add(M2, M4)
        val C22 = add(sub(add(M1, M3), M2), M6)

        /** join 4 halves into one result matrix  */
        join(C11, R, 0, 0)
        join(C12, R, 0, n / 2)
        join(C21, R, n / 2, 0)
        join(C22, R, n / 2, n / 2)
    }
    /** return result  */
    return R
}
fun inputt(a:Array<IntArray>) {
    var sc = Scanner(System.`in`)
    var count = 1;
    for (i in a.indices) {
        for (j in a[i].indices) {
            println("Enter the ${count}${OrdinalNumbers(count++)} element")
            a[i][j] = sc.nextInt()
        }
    }
}

    fun OrdinalNumbers(n: Int): String {
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
        val sc=Scanner(System.`in`);
        println("Enter the row size of matrix")
        val r=sc.nextInt()
        println("Enter the column size of matrix")
        val c=sc.nextInt()

        val a=Array(r) {IntArray(c)}
        val b=Array(r) {IntArray(c)}
        if (r==c){
            if (`matrix checker`(r)){
                println("Matrix is compatible")
                println("Enter the 1st matrix")
                input(a)

                println("Enter the 2nd matrix")
                input(b)
                println("your 1st matrices are")
                show(a)
                println("your 2nd matrices are")
                show(b)
                println("The resultant matrix is")
                val c=multiply(a, b)
                show(c)
            }
            else
                println("Matrix is incompatible .Order must be 2^n.")
        }
        else
            println("Matrix order must be in 2^n")



    }