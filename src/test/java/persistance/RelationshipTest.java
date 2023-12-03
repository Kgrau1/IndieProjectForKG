package persistance;

import entity.Hours;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Database;
import persistence.GenericDao;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RelationshipTest {

    private GenericDao<User> userDao;
    private GenericDao<Hours> hoursDao;

    private static final Logger logger = LogManager.getLogger(RelationshipTest.class);

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao<>(User.class);
        hoursDao = new GenericDao<>(Hours.class);
    }

    @Test
    void testUserAndHoursRelationship() {
        User user = new User(55, "John", "Smith", false);

        LocalDateTime clockInTime = LocalDateTime.parse("2023-11-16T09:00");
        LocalDateTime clockOutTime = LocalDateTime.parse("2023-11-16T12:00");

        int userId = userDao.insert(user);

        Hours hours = new Hours("123", clockInTime, clockOutTime, 55, null);
        hours.setUser(user);

        int hoursId = hoursDao.insert(hours);

        User retrievedUser = userDao.getById(Integer.parseInt(String.valueOf(userId)));
        Hours retrievedHours = hoursDao.getById(Integer.parseInt(String.valueOf(hoursId)));

        System.out.println("retrievedUser: " + retrievedUser);
        System.out.println("retrievedHours.getUser(): " + retrievedHours.getUser());

        assertEquals(retrievedUser.getId(), retrievedHours.getUser().getId());
        assertEquals(retrievedUser.getFirstName(), retrievedHours.getUser().getFirstName());
        assertEquals(retrievedUser.getLastName(), retrievedHours.getUser().getLastName());
        assertEquals(retrievedUser.isClockedIn(), retrievedHours.getUser().isClockedIn());

        assertTrue(user.getLoggedHours().contains(retrievedHours));
    }
}
