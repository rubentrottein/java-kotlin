class kotlinElements {
    import java.util.*
    import kotlin.collections.HashMap

    fun main(){
        val nom = "Bono";
        val nom2 : String = "Bono";

        var nomVar : String;
        nomVar = "Bono2"

        var nullNull = null;

        var nomNull : String? = null
        nomNull = "test"
        nomNull = null

        // println("HW")
        // printTest()
        // printParam(nomVar)
        handleArray()
        handleMap()
        //handleInput()
        //handleCondition()
        handleWhen()
    }

    fun printTest(){
        println("Test")
    }

    fun printParam(paramToPrint : String){
        println(paramToPrint)
    }

    fun returnParam(paramToReturn : String): String {
        return paramToReturn
    }

    fun returnUnit(paramToReturn : String): Unit{
    }

    fun printOneLine(toPrint : String) { println(toPrint)}

    fun handleArray() {
        var a: IntArray = intArrayOf(1, 2);
        for (i in a){println(i)}
    }

    fun handleMap() {
        var testMap: HashMap<String, Int> = HashMap();
        testMap.put("testKey", 2)
        println(testMap)
    }

    fun handleInput(){
        print("input : ")
        var i : String? = readLine()
        //var sc = Scanner(i)
        println(i)
    }

    fun handleCondition(){
        var count = 1;
        while (true){ //WARNING!!!!
            print("Condition: " + count);
            count++;
        }
    }

    fun handleWhen(){
        val saisie = readLine()
        when(saisie){
            "test" -> println("test")
            "test2" -> println("test2")
            "test3" -> println("test3")
            else -> println("else")
        }
    }






    class Calculatrice {
        fun add(a: Int, b: Int): Int { return a + b;}
        fun subtract(a: Int, b: Int): Int { return a - b;}
        fun multiply(a: Int, b: Int): Int { return a * b;}
        fun divide(a: Int, b: Int): Int {
            try {
                return a / b;
            } catch (e: ArithmeticException) {
                return 0
            }

            /*    if (b==0){
                    print("oups")
                }
                return a / b;*/
        }

    }

    fun main(args: Array<String>) {
        var c : Calculatrice = Calculatrice()

        print(c.add(1,2))
    }


}