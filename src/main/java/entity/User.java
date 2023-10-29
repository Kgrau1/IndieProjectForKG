package entity;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.*;

/**
 * The type User.
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private boolean isClockedIn;
    private List<Hours> loggedHours;

    /**
     * Instantiates a new User.
     */
    public User() {
        loggedHours = new ArrayList<>();
    }

    /**
     * Instantiates a new User.
     *
     * @param id the id
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Is clocked in boolean.
     *
     * @return the boolean
     */
    public boolean isClockedIn() {
        return isClockedIn;
    }

    /**
     * Sets clocked in.
     *
     * @param clockedIn the clocked in
     */
    public void setClockedIn(boolean clockedIn) {
        isClockedIn = clockedIn;
    }

    /**
     * Gets logged hours.
     *
     * @return the logged hours
     */
    public List<Hours> getLoggedHours() {
        return loggedHours;
    }

    /**
     * Sets logged hours.
     *
     * @param loggedHours the logged hours
     */
    public void setLoggedHours(List<Hours> loggedHours) {
        this.loggedHours = loggedHours;
    }
}
