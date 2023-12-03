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
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class GenericDaoHoursTest {

    GenericDao dao;
    private static final Logger logger = LogManager.getLogger(GenericDaoUserTest.class);

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Hours.class);
    }

    @Test
    void getClockInByIdSuccess() {
        logger.info("Running getByIdSuccess test");
        Hours retrievedHours = (Hours) dao.getById(1);
        assertNotNull(retrievedHours);
        assertEquals(LocalDateTime.parse("2023-11-16T08:00"), retrievedHours.getClockInTime());
    }

    @Test
    void getAllSuccess() {
        List<Hours> hours = dao.getAll();
        assertEquals(2, hours.size());
    }

    @Test
    void insertHoursSuccess() {
        LocalDateTime expectedClockInTime = LocalDateTime.parse("2023-11-16T09:00");
        LocalDateTime expectedClockOutTime = LocalDateTime.parse("2023-11-16T12:00");
        Hours newHours = new Hours("3", expectedClockInTime, expectedClockOutTime, 1, null);

        int hoursId = (dao.insert(newHours));
        assertNotEquals(0, hoursId);

        Hours insertedHours = (Hours) dao.getById(Integer.parseInt(String.valueOf(hoursId)));

        assertNotNull(insertedHours);
        assertEquals(expectedClockInTime, insertedHours.getClockInTime());
        assertEquals(expectedClockOutTime, insertedHours.getClockOutTime());
        assertNull(insertedHours.getUser());
    }

    @Test
    void updateHoursSuccess() {
        Hours hoursToUpdate = (Hours) dao.getById(1);

        LocalDateTime updatedClockInTime = LocalDateTime.parse("2023-11-16T09:30");
        hoursToUpdate.setClockInTime(updatedClockInTime);

        dao.saveOrUpdate(hoursToUpdate);

        Hours updatedHours = (Hours) dao.getById(1);

        assertNotNull(updatedHours);
        assertEquals(updatedClockInTime, updatedHours.getClockInTime());
    }

    @Test
    void deleteHoursSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }
}
