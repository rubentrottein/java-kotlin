import java.util.HashMap

fun handleArray(){
    var array : [String elt];
    array.add("Element 1", "Element 2");
    printltn(array);
}
fun handleMap(){
    var map: HashMap<String, Int>   = HashMap();
    map.put("TestKey", "Test value");
    printltn(map);
}

fun handleInput(){
    var i : String? = readLine;
}