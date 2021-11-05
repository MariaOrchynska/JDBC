import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ContactRepo implements ContactRepository {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ContactRepo(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public void save(Contact contact) {
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
    public void saveBulk(List<Contact> contact) {
        for (int i = 0; i < contact.size(); i++) {
            String sql = "INSERT INTO Users VALUES ('" + contact.get(i).getId() + "','" + contact.get(i).getName() + "','"
                    + contact.get(i).getAge() + "','" + contact.get(i).getCountry() + "')";


            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Contact added to person table");
    }

    @Override
    public void update(int id) {
        String str2 = "update users set name= 'IDK' where  id =" + id;
        try {
            statement.executeUpdate(str2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact is updated in table");

    }

    //    delete From Users where ID=12
    @Override
    public void delete(int id) {
        String str3 = "delete from Users where id=" + id;
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
        int z = 0;
        List<Contact> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select count(*) FROM Users");
        rs.next();
        z = rs.getInt("count(*)");

        for (int i = 1; i < z; i++) {
            String sql = "select id,name,age,country FROM Users where id= " + i;
            rs = statement.executeQuery(sql);
            Contact contact = new Contact("ter", 34, 45, "ger");
            while (rs.next()) {
                contact.setId(rs.getInt("id"));
                contact.setAge(rs.getInt("age"));
                contact.setName(rs.getString("name"));
                contact.setCountry(rs.getString("country"));
            }
            list.add(contact);

        }

        return list;

    }

    @Override
    public Contact getContactById(int id) throws SQLException {
        int k = 0;
        ResultSet rs = statement.executeQuery("select count(*) FROM Users");
        rs.next();
        k = rs.getInt("count(*)");
        String sql = "select id FROM Users where id= " + k;
        rs = statement.executeQuery(sql);
        Contact contact = new Contact("ter", 34, 45, "ger");
        while (rs.next()) {
            contact.setId(rs.getInt("id"));
        }
        return  contact;
    }


    }

