package enthuare.examples.java_class_design;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
    static BookStore bs = new BookStore();

    public static void main(String[] args) {
        Book b = new Book();
        b.setIsbn("111");
        bs.addBook(b, 10);
        System.out.println(bs.getNumberOfCopies(b));

        System.out.println(b.hashCode());

        b = new Book();
        System.out.println(b.hashCode());
        b.setIsbn("111");
        System.out.println(bs.getNumberOfCopies(b));
    }
}


class Book {
    private String title, isbn;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean equals(Object o) {
        return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
    }
}

class BookStore {
    Map<Book, Integer> map = new HashMap<>();

    int getNumberOfCopies(Book b) {
        return map.get(b);
    }

    public void addBook(Book b, int numberofcopies) {
        map.put(b, numberofcopies);
    }
}
