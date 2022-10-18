import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val wiladi = Fraction(6, 3)
    val wiladi2 = Fraction(2, 4)
    println(wiladi.add(wiladi2))
}
class Point(private val x: Double, private val y:Double) {

    override fun toString(): String {
        return "x=$x, y=$y"
    }
    private val negX = -x
    private val negY = -y
    fun symmetric(): String {
        return "x=$negX, y=$negY"
    }
    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }

    fun length(obj: Point): Double {
        val l: Double = this.x - obj.x
        val h: Double = this.y - obj.y
        return sqrt(l.pow(2.0) + h.pow(2.0))
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + negX.hashCode()
        result = 31 * result + negY.hashCode()
        return result
    }
}
class Fraction(private var numerator: Int, private var denominator: Int){
    fun cut():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    fun mult(frc:Fraction):String{
        val z : Int = numerator*frc.numerator
        val l : Int = denominator*frc.denominator
        return  "$z / $l"
    }

    fun add(frc:Fraction):String{
        var z1:Int = numerator
        var l1:Int = denominator
        var z2:Int = frc.numerator
        var l2:Int = frc.denominator
        val tmp:Int = denominator
        if (denominator!=frc.denominator){
            z1*=l2
            l1*=l2
            z2*=tmp
            l2*=tmp
        }
        var sm :Int = z1+z2
        var ct = Fraction(sm, l2)
        return ct.cut()
    }
}