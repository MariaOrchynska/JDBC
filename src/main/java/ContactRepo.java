
import com.mysql.cj.MysqlConnection;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ContactRepo implements ContactRepository{
Connection connection=null;
Statement statement=null;
ResultSet resultSet = null;

    public ContactRepo(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public void save(Contact contact)  {
        String sql = "INSERT INTO Users VALUES ('" + contact.getId() + "','" + contact.getName() + "','"
                + contact.getAge() + "','" + contact.getCountry() + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added to person table");
    }


    @Override
    public void saveBulk(List<Contact> contact)  {
        String query = " insert into Users (id, name, age, country)"
                + " values (list)";
        List<Contact> list = new ArrayList<>();
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Contact added to person table");

//listof contacts
    }

    @Override
    public void update(int id) {
        String str2="update users set id = 113 where name = Tom";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(str2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStmt.setInt   (1, 6000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStmt.setString(2, "Fred");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact is updated in table");


//change smth look for id
    }
//    delete From Users where ID=12
    @Override
    public void delete(int id) {
        String str3="delete from Users where id=12";
        try {
            statement.executeUpdate(str3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Contact deleted to person table");

//where id
    }

    @Override
    public List<Contact> getContacts() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String[] types = {"Users"};
        ResultSet tables = metaData.getTables(null, null, "%", types);
        while (tables.next()) {
            System.out.println(tables.getString("TABLE_NAME"));
        }

        return null;

    }

    @Override
    public Contact getContactById(int id) throws SQLException {
        String sql = "SELECT * FROM Users WHERE id = 12";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt('2',2);
        resultSet=st.executeQuery();


        if (resultSet.next()) {
            String username = resultSet.getString("id");
        }
        return null;


    }
}
