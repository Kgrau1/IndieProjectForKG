package persistance;

import entity.Hours;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Database;
import persistence.GenericDao;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class GenericDaoTest {

    GenericDao dao;
    private static final Logger logger = LogManager.getLogger(GenericDaoTest.class);

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(User.class);
    }

    @Test
    void getByIdSuccess() {
        logger.info("Running getByIdSuccess test");
        User retrievedUser = (User) dao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Kevin", retrievedUser.getFirstName());
        assertEquals("Grau", retrievedUser.getLastName());
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void insertSuccess() {
        User newUser = new User(3, "Jane", "Doe", false);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);

        User insertedUser = (User) dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Jane", insertedUser.getFirstName());
        assertEquals("Doe", insertedUser.getLastName());
    }

    @Test
    void updateSuccess() {
        User userToUpdate = (User) dao.getById(1);
        userToUpdate.setFirstName("K");
        dao.saveOrUpdate(userToUpdate);

        User updatedUser = (User) dao.getById(1);
        assertNotNull(updatedUser);
        assertEquals("K", updatedUser.getFirstName());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

}
