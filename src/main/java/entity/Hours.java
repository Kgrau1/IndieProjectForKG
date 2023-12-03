package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity(name = "Hours")
@Table(name = "hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "jobId")
    private String jobId;

    @Column(name = "clockInTime")
    private LocalDateTime clockInTime;

    @Column(name = "clockOutTime")
    private LocalDateTime clockOutTime;
    @Column(name = "userId")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "userTableId")
    private User user;

    public Hours() {
    }

    public Hours(String jobId, LocalDateTime clockInTime, LocalDateTime clockOutTime, int userId, User user) {
        this.jobId = jobId;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.userId = userId;
        this.user = user;
    }

    /**
     * Gets clock in time.
     *
     * @return the clock in time
     */
    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    /**
     * Sets clock in time.
     *
     * @param clockInTime the clock in time
     */
    public void setClockInTime(LocalDateTime clockInTime) {
        this.clockInTime = clockInTime;
    }

    /**
     * Gets clock out time.
     *
     * @return the clock out time
     */
    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    /**
     * Sets clock out time.
     *
     * @param clockOutTime the clock out time
     */
    public void setClockOutTime(LocalDateTime clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
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
     * Gets id.
     *
     * @return the id
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Sets id.
     *
     * @param jobId the id
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
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

    @Override
    public String toString() {
        return "Hours{" +
                "id=" + id +
                ", jobId=" + jobId +
                ", clockInTime=" + clockInTime +
                ", clockOutTime=" + clockOutTime +
                ", user=" + user +
                '}';
    }
}
