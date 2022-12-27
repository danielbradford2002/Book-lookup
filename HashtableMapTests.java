import java.util.NoSuchElementException;

public class HashtableMapTests {
    static HashtableMap testMap1 = new HashtableMap<>();
    static HashtableMap testMap2 = new HashtableMap<>(10);
    static HashtableMap testMap3 = new HashtableMap<>(50);

    public static boolean test1() {
testMap1.put(2, "firstItem");
System.out.println(testMap1.get(2));
testMap1.clear();
if(testMap1.size() == 0) {
    System.out.println("test 1 passed"); //testing that the clear and size methods work correctly
    return true;
}
    else return false;
}

    public static boolean test2() {
        testMap2.put(3,"test2 string");
        if(testMap2.get(3).equals("test2 string")){ //testing correctness of put and get methods
            System.out.println("test 2 passed");
            return true;
        }
        else return false;
    }
    public static boolean test3() {
        testMap3.put(5,"test 3 string a");
    testMap3.put(6,"test 3 string b");
    if(testMap3.size() == 2){ //testing correctness of put and size methods
        System.out.println("test 3 passed");
    return true;}
    else return false;
    }
    public static boolean test4(){
       try{ testMap1.get(8);}
       catch(NoSuchElementException e){ //testing get method when calling element that isn't there
        System.out.println("test 4 passed");
        return true;
        }
    return false;
    }

    public static boolean test5() {
        testMap3.put(1, "test5 string");
        if(testMap3.containsKey(1)){ //testing correctness of containsKey method and put method
            System.out.println("test 5 passed");
            return true;
        }
        else return false;
         }
}
