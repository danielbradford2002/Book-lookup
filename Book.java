public class Book implements IBook{

    @Override
    public String getTitle() {
        return "Cat in the Hat";
    }

    @Override
    public String getAuthors() {
       return "John Smith";
    }

    @Override
    public String getISBN13() {
        return "90909382948";
    }
}
