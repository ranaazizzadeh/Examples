import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public static int save(Book book) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into book(book_name,author,status) values(?,?,?)");
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getStatus().ordinal());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Book> showBooks() {

        List<Book> books = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book where status = 0 ");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getLong("book_id"),
                        resultSet.getString("book_name"),
                        resultSet.getString("author")
                ));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return books;
    }

    public static boolean borrowBook(long userID,long bookId){
        boolean result = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user_book(create_date,status,user_id,book_id) values(?,?,?,?)");
            java.util.Date now = new java.util.Date();

            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2,BookStatus.BORROWED.ordinal());
            ps.setLong(3, userID);
            ps.setLong(4, bookId);


            boolean userBookTbResult = ps.execute();

            ps = con.prepareStatement("update book set status =? where book_id =? ");
            ps.setInt(1, BookStatus.BORROWED.ordinal());
            ps.setLong(2, bookId);
            boolean bookTbResult = ps.execute();

            result = bookTbResult && userBookTbResult ;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}