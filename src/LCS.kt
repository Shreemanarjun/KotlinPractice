fun LCS_Length(x:String,y:String): Pair<Array<IntArray>, Array<Array<String>>> {
    var m=x.length
    var n=y.length
    var b=Array(m) {Array<String>(n){""} }
    var c=Array(m) {IntArray(n) }

    var cd=0
    /*for (i in 1..m-1){
        for (j in 1..n-1){
        cd++
           println("${x[i]} ${y[j]}")
        }

        println(cd)
    }*/
    for (i in 1 until m){
        c[i][0]=0
    }
    for (j in 0 until n){
        c[0][j]=0
    }
    for (i in 1 until m){
        for (j in 1 until n)
            if (x[i]==y[j]) {
                c[i][j]=c[i-1][j-1]+1
                b[i][j]="\u2196"
            }
            else if (c[i-1][j]>=c[i][j-1]) {
                c[i][j]=c[i-1][j]
                b[i][j]="\u2191"
            }
            else {
                c[i][j]=c[i][j-1]
                b[i][j]="\u2190"
            }
    }

    return c to b
}
fun PRINT_LCS(b:Array<Array<String>>,x:Array<Char>,i:Int,j:Int){
    if (i==0 || j==0){
return
    }

    if (b[i][j]=="\u2196") {
        PRINT_LCS(b,x, i-1, j-1)
        println(x[i])
    }
    else if (b[i][j]=="\u2191") PRINT_LCS(b,x, i-1, j)
    else PRINT_LCS(b, x, i, j-1)

}
fun main(){
    var m=LCS_Length("babb","aabab")
    var f=m.first
    var s=m.second
         PRINT_LCS(s,"aabab".toCharArray().toTypedArray(),4,4)

}

    //PRINT_LCS(m.first,"aabab".toCharArray().toTypedArray(),1,4)

