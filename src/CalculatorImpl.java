import java.util.*;
import java.util.stream.Collectors;

public class CalculatorImpl {

    public static void main(String[] args) {
//        Calculator calculator = () -> System.out.println("Swotch on");
//calculator.switchOn();

//Calculator calculator = num -> num+2;
//        System.out.println(calculator.sum(321));

        Calculator calculator = (i1, i2) -> {
            if(i1>i2){
                System.out.println("error");
            }else {
                System.out.println(i2-i1);
            }
            return i2-i1;
        };
        calculator.subtract(32,41);


        Book book1 = new Book(1L,"Janam",12);
        Book book2 = new Book(2L,"Banam",14);
        Book book3 = new Book(3L,"Manam",16);
        List<Book> bookList = Arrays.asList(book1,book2,book3);
        //bookList.sort(Comparator.comparing(Book::getBookName));
        bookList.stream().sorted((o1, o2) -> o2.getBookName().compareTo(o1.getBookName()))
                .forEach(book -> System.out.println(book.getBookName()));
    }


}
