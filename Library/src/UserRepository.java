import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static int save(User user){
        int status=0;
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into user(name,lastname) values(?,?)");
            ps.setString(1,user.getName());
            ps.setString(2, user.getLastname());

            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static List<User> showUsers(){
        List<User> users = new ArrayList<>();
         try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                users.add(new User(resultSet.getLong("user_id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("lastname")
                ));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return users;
    }
}
