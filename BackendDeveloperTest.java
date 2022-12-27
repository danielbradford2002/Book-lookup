public class BackendDeveloperTest {
    //what objects should I be creating
    static MyHashtable<String, IBook> databaseTest = new MyHashtable<String, IBook>(20);
    static BookMapperBackend testMapper = new BookMapperBackend();
    static IBook testBook = new IBook() {
        @Override
        public String getTitle() {
            return "testTitle";
        }

        @Override
        public String getAuthors() {
            return "testAuthor";
        }

        @Override
        public String getISBN13() {
            return "testISBN";
        }
    };

    public static boolean test1()
    {
        testMapper.addBook(testBook);
        if (databaseTest.get("testISBN").equals(testBook)) {
            System.out.println("Backend Developer Individual Test 1: passed");
            return true;
        }
        System.out.println("Backend Developer Individual Test 1: failed");
        return false;
    }
    public static boolean test2()
    {
        testMapper.getNumberOfBooks();
        if (databaseTest.size() == 1) {
            System.out.println("Backend Developer Individual Test 2: passed");
            return true;
        }
        System.out.println("Backend Developer Individual Test 2: failed");
        return false;
    }
    public static boolean test3()
    {
        testMapper.setAuthorFilter("John");
        if (testMapper.getAuthorFilter().equals("John") ){ // expected for filter[0]{
            System.out.println("Backend Developer Individual Test 3: passed");
            return true;
        }
        System.out.println("Backend Developer Individual Test 3: failed");
        return false;
    }
    public static boolean test4()
    {
testMapper.resetAuthorFilter(); //is supposed to set filter[0] to null
        if (testMapper.getAuthorFilter() == null) {
            System.out.println("Backend Developer Individual Test 4: passed");
            return true;
        }
        System.out.println("Backend Developer Individual Test 4: failed");
        return false;
    }

    public static boolean test5()
    {
         //is supposed to set filter[0] to null
        if (testMapper.getByISBN("testISBN").equals(testBook)){ //should return this because
            // matching ISBN{
            System.out.println("Backend Developer Individual Test 5: passed");
            return true;
        }
        System.out.println("Backend Developer Individual Test 5: failed");
        return false;
    }
    public static boolean integrationTest1() { /* test code here */

        try {
            boolean isValid = validator.validate("83790930909490404984787998");

            if (isValid) {
                System.out.println("Error. The ISBN number was not valid, but validator returned " +
                        "true");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error. There was an unexpected exception");
            return false;
        }

    }


    public static boolean IntegrationTest2() {

        try {
            validator = new IISBNValidatorImplementation();

            boolean isValid = validator.validate("9780439358064");

            if (!isValid) {
                System.out.println("Error. returned false when the ISBN number was valid. It " +
                        "should have returned true");
                return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error. an exception was caught that was unexpected");
            return false;
        }

    }
    public static boolean IntegrationTest3() {
        try {
            isbnLookup("hfjkadshkjfhajk");
        }
        catch (Exception e){
            System.out.println("test passed. successfully caught exception");
            return true;
        }
        System.out.println("Error. should have caught exception");
        return false;
    }
    public static boolean IntegrationTest3() {
        try {
            isbnLookup("hfjkadshkjfhajk");
        }
        catch (Exception e){
            System.out.println("test passed. successfully caught exception");
            return true;
        }
        System.out.println("Error. should have caught exception");
        return false;
    }
    public static boolean IntegrationTest4() {
        try {
            getTitle("The Martian");
        }
        catch (Exception e){
            System.out.println("error. unexpected exception caught");
            return false;
        }
        System.out.println("test passed. get title works correctly");
        return true;
    }



    public static void main(String[] args){
        BackendDeveloperTest.test1();
        BackendDeveloperTest.test2();
        BackendDeveloperTest.test3();
        BackendDeveloperTest.test4();
        BackendDeveloperTest.test5();
//        BackendDeveloperTest.integrationTest1();
//        BackendDeveloperTest.IntegrationTest2();
    }

}

