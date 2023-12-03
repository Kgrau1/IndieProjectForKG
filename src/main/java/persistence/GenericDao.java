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

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    public GenericDao() {

    }

    /**
     * Returns an open session from the SessionFactory.
     *
     * @return the session
     */
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
     * Gets by job id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by job id
     */
    public <T>T getByJobId(String id) {
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
        hours.setClockInTime(LocalDateTime.now());
    }

    /**
     * Clock out.
     *
     * @param hours the hours
     */
    public void clockOut(Hours hours) {
        hours.setClockOutTime(LocalDateTime.now());
    }

    /**
     * Save or update.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Insert int.
     *
     * @param entity the new User
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
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
