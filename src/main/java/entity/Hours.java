package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity(name = "Hours")
@Table(name = "Hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Hours() {
    }

    public Hours(int id, LocalDateTime clockInTime, LocalDateTime clockOutTime, User user) {
        this.id = id;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
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

    @Override
    public String toString() {
        return "Hours{" +
                "id=" + id +
                ", clockInTime=" + clockInTime +
                ", clockOutTime=" + clockOutTime +
                ", user=" + user +
                '}';
    }
}
