import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.*;

class Book{
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author){
        this.title=title;
        this.author=author;
        this.checkedOut= false;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isCheckedOut(){
        return checkedOut;
    }
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut=checkedOut;
    }

    @Override
    public String toString(){
        return "Title: " + title + "Author:" + author + "Status: " + (checkedOut ? "Checked Out" : "Available");
    }

}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog(){
        books = new ArrayList<>();
    }
    public void addBook(Book book ){
        books.add(book);
    }

    public ArrayList<Book> searchByTitle (String title){
        ArrayList<Book> result = new ArrayList<>();
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title)){
                result.add(book);
            }
        }
        return result;
    }
    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book:books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }
        return result;
    }
    public void checkOutBooks(String title){
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()){
                book.setCheckedOut(true);
                System.out.println("Book" + title + "checked out successfully.");
                return;
            }
        }
        System.out.println("Book" + title + "Not Available for checkout.");

    }

    public void returnBook(String title ){
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()){
                book.setCheckedOut(false);
                System.out.println("Book " + title + "returned successfully");
                return;
            }
        }
        System.out.println("Book " + title + "was not checked out or does not exist in the library.");
    }
    public void displayCatalog(){
        System.out.println("Library Catalog:");
        for(Book book  : books){
            System.out.println(book);
        }
    }

}
public class Task_2_Library_Mangement_System {
    public static void main(String[] args) {
        LibraryCatalog Library = new LibraryCatalog();

        Library.addBook(new Book("Book1", "Author1"));
        Library.addBook(new Book("Book2", "Author2"));
        Library.addBook(new Book("Book3", "Author1"));

        Library.displayCatalog();

        System.out.println("\nBooks by Author1: ");
        ArrayList<Book> booksByAuthor = Library.searchByAuthor("Author1");
        for(Book book : booksByAuthor){
            System.out.println(book);
        }

        Library.checkOutBooks("Book1");
        Library.displayCatalog();

        Library.returnBook("Book1");
        Library.displayCatalog();

    }

}
