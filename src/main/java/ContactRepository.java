import java.sql.SQLException;
import java.util.List;


public interface ContactRepository {
    void save(Contact contact) ;

    void saveBulk(List<Contact> contact) throws Exception;

    void update(int id);

    void delete(int id);

    List<Contact> getContacts() throws SQLException;

    Contact getContactById(int id) throws SQLException;










}
