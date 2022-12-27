
// --== CS400 Project One File Header ==--
// Name: Daniel Bradford
// CSL Username: bradford
// Email: dcbradford@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookMapperBackend implements IBookMapperBackend{

     MyHashtable<String, IBook> database = new MyHashtable<String, IBook>(20);
String[] filter = new String[10];

    /**
     * Adds a new book to the backend's database and is stored in
     * a hash table interally.
     * @param book the book to add
     */

    public void addBook(IBook book) {
                database.put(book.getISBN13(), book);
    }

    /**
     * Returns the number of books stored in the backend's database.
     * @return the number of books
     */
    public int getNumberOfBooks(){
        return database.size;
    }

    /**
     * This method can be used to set a filter for the author names
     * contained in the search results. A book is only returned as
     * a result for a search by title, it is also contains the string
     * filterBy in the names of its authors.
     * @param filterBy the string that the book's author names must contain
     */
    public void setAuthorFilter(String filterBy){
filter[0] = filterBy;
for (int i = 1; i < 10; i++){
    filter[i] = null;
}
    }
//next and has next are only
    //
    /**
     * Returns the string used as the author filter, null if no author
     * filter is currently set.
     * @return the string used as the author filter, or null if none is set
     */
    public String getAuthorFilter(){
        if(filter[0] == null){
            return null;
        }
        return filter[0];
    }

    /**
     * Resets the author filter to null (no filter).
     */
    public void resetAuthorFilter(){
filter[0] = null;
    }

    /**
     * Search through all the books in the title base and return books whose
     * title contains the string word (and that satisfies the author filter,
     * if an author filter is set).
     * @param word word that must be contained in a book's title in result set
     * @return list of books found
     */
    public LinkedList<IBook> searchByTitleWord(String word){
        Iterator iter = database.iterator();
        LinkedList<IBook> booksFound = new LinkedList<IBook>(); //HELP
      while(iter.hasNext()) {
          IBook book = (IBook) iter.next();
          if(book != null) {
              if (book.getTitle().contains(word)) {

                  booksFound.add(book);
              }
          }
      }
        return booksFound;

    }

    /**
     * Return the book uniquely identified by the ISBN, or null if ISBN is not
     * present in the dataset.
     * @param ISBN the book's ISBN number
     * @return the book identified by the ISBN, or null if ISBN not in database
     */
    public IBook getByISBN(String ISBN){
        Iterator iter = database.iterator();
        while(iter.hasNext()) {
            IBook book = (IBook) iter.next();
            if(book != null) {
                if (book.getISBN13().equals(ISBN)) {
                    return book;

                }
            }
        }
        return null;
    }
}
