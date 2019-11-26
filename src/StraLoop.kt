fun main(){
   val r=6
    var c=r-1
    for (row in 1..r){
        for (col in 1..c){
            print("*")
        }
        c--
        for (c2 in 0..c+1){
            print("  ")
        }
        println()
    }
}