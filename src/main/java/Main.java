import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql1";
    private static final String USER = "root";
    private static final String PASSWORD = "RootRoot";
    public static void main(String[] args)  {
        Connection connection= null;
        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Users");
            ContactRepo cr = new ContactRepo( connection, statement ) ;
//cr.delete(114);
//            cr.update(113);
//            List<Contact > list =new ArrayList<>();
//            list.add(new Contact("Tom",13,12,"UK"));
//            list.add(new Contact("Tom",13,12,"UK"));
//            cr.saveBulk(list);
//            cr.save(new Contact("Tom",1,12,"Rick"));
//            cr.save(new Contact("Ben",114,12,"Rick"));
//            cr.delete(12);
//            cr.update(113);
//            List<Contact> list = new ArrayList();
//
//            list= cr.getContacts();
//for (int i = 0; i< list.size();i++){
//    System.out.println(list.get(i).getName());
//}
//
//
             System.out.println(cr.getContactById(1).getId());

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    jdbc:mysql://localhost:3306
}
