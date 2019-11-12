/*
* You have been asked to help study the population of birds migrating across the continent. Each type of bird you are
interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be
added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of
sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common,
choose the type with the smallest ID number.
For example, assume your bird sightings are of types . There are two each of types and , and
one sighting of type . Pick the lower of the two types seen twice: type .
*
* */


// Complete the migratoryBirds function below.
fun migratoryBirds(arr: Array<Int>): Int {
var typearray= intArrayOf(1,2,3,4,5)
 var countarray= IntArray(5)
    var count=0
    when {
        arr.size>=5 -> {
            typearray.indices.forEach { i ->
                count = 0
                for (element in arr) {
                    if (typearray[i] == element) {
                        count++
                    }
                    countarray[i] = count
                }
            }
            println("Type array is\n")
            typearray.forEach { j ->
                print("$j   \t")
            }
            println("\nCount array have elemnts")
            countarray.forEach { i ->
                print("$i   \t")
            }
            (countarray.indices).forEach { i ->
                (i+1 until countarray.size).forEach { j ->
                    when {
                        countarray[i]==countarray[j] -> return typearray[i]
                        else -> typearray[countarray.getmaximumindices()]
                    }
                }
            }


        }
    }

        return 0
}
fun IntArray.getmaximumindices():Int{
    return this.indexOf((this.sortedDescending())[0])
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

   var result=  migratoryBirds(arr)

   println("\nAnswer is $result")
}
