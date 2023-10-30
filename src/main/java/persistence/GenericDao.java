package persistence;

import entity.Hours;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.*;
import static persistence.SessionFactoryProvider.sessionFactory;

public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    public GenericDao() {

    }

    public Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public boolean getClockedInStatus(int id) {
        Session session = getSession();
        User entity = (User)session.get(type, id);
        session.close();
        return entity != null && entity.isClockedIn();
    }

    /**
     * Gets an entity by id.
     * @param id entity id to search by
     * @return the entity
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Clock in.
     *
     * @param hours the hours
     */
    public void clockIn(Hours hours) {
        LocalDateTime currentTime = LocalDateTime.now();
        hours.setClockInTime(currentTime);
    }

    /**
     * Clock out.
     *
     * @param hours the hours
     */
    public void clockOut(Hours hours) {
        LocalDateTime currentTime = LocalDateTime.now();
        hours.setClockOutTime(currentTime);
    }
    /**
     * Delete the entity.
     * @param entity the entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all entities.
     * @return all entities
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }
}
