operator fun Fraction.plus(i: Fraction): Fraction {
    return if (this.denominator == i.denominator) simplify(Fraction(this.numerator + i.numerator, this.denominator))
    else {
        val numT = this.numerator * i.denominator
        val numI = i.numerator * this.denominator
        val den = i.denominator * this.denominator
        simplify(Fraction(numT + numI, den))
    }
}

operator fun Fraction.minus(i: Fraction): Fraction {
    return if (this.denominator == i.denominator) simplify(Fraction(this.numerator - i.numerator, this.denominator))
    else {
        val numT = this.numerator * i.denominator
        val numI = i.numerator * this.denominator
        val den = i.denominator * this.denominator
        simplify(Fraction(numT - numI, den))
    }
}


operator fun Fraction.times(i: Fraction): Fraction {
    return simplify(Fraction(this.numerator * i.numerator, this.denominator * i.denominator))
}

operator fun Fraction.div(i: Fraction): Fraction {
    return simplify(Fraction(this.numerator * i.denominator, this.denominator * i.numerator))
}

operator fun Fraction.compareTo(i: Fraction): Int {
    if (this.denominator == i.denominator) return this.numerator.compareTo(i.numerator)
    val numT = this.numerator * i.denominator
    val numI = i.numerator * this.denominator
    return numT.compareTo(numI)
}


fun gcd(a: Int, b: Int): Int {
    return if (a == 0)
        b
    else gcd(b % a, a)
}

/*
fun lcm(a: Int, b: Int): Int {
    return (a / gcd(a, b)) * b
}
*/

fun simplify(i: Fraction): Fraction {
    return Fraction(i.numerator / gcd(i.numerator, i.denominator), i.denominator / gcd(i.numerator, i.denominator))
}

data class Fraction(val numerator: Int, val denominator: Int) {
    override fun equals(other: Any?): Boolean {
        return this.compareTo(other as Fraction) == 0
    }

    override fun hashCode(): Int { //generated
        var result = numerator
        result = 31 * result + denominator
        return result
    }
}

fun main() {
    val a = Fraction(4, 6)
    val b = Fraction(1, 2)

    println(a + b)
    println(a - b)
    println(a * b)
    println(a / b)
    println(a > b)
    println(a == b)
}
