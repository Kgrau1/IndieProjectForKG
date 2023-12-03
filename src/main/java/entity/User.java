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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private LocalDateTime currentTime;
    private boolean isClockedIn;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Hours> loggedHours;

    /**
     * Instantiates a new User.
     */
    public User() {
        loggedHours = new ArrayList<>();
    }

    public User(int userId, String firstName, String lastName, boolean isClockedIn) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isClockedIn = isClockedIn;
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
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
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

    public void addLoggedHours(Hours hours) {
        loggedHours.add(hours);
        hours.setUser(this);
    }

    public void removeLoggedHours(Hours hours) {
        loggedHours.remove(hours);
        hours.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                isClockedIn == user.isClockedIn &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, isClockedIn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isClockedIn=" + isClockedIn +
                ", loggedHours=" + loggedHours.size() +
                '}';
    }
}
