package entity;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.*;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private LocalDateTime currentTime;

    private boolean isClockedIn;
    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets current time.
     *
     * @param currentTime the current time
     */
    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isClockedIn=" + isClockedIn +
                ", loggedHours=" + loggedHours +
                '}';
    }
}
