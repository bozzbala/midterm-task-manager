fun sum(a: Int, b: Int): Int {
    return a + b
}

val multiply: (Int, Int) -> Int = { a, b -> a * b }

fun applyFunc(a: Int, b: Int, func: (Int, Int) -> Int): Int {
    return func(a, b)
} 