fun main() {
	ex1_4()
}

fun ex1_1 () {
    var a: Int = 0
    var b: Double = 2.33
    var c: String = "test"
    var d: Boolean = true 

    println("Int: " + a);
    println("Double: " + b);
    println("String: " + c);
    println("Boolean: " + d);
}

fun ex1_2() {
    var number: Int = 5;
    if (number > 0) {
        println("$number is positive")
    }
    else if(number < 0) {
        println("$number is negative")
    }
    else println("The number is zero")
}
    
fun ex1_3() {
    for (i in 1..10) {
        println(i)
    }
    
    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }
}

fun ex1_4() {
    val numbers = listOf(3, 4, 2, 5, 10)
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    println("Sum: $sum")
}