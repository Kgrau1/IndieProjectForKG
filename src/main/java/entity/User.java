package entity;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.*;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private boolean isClockedIn;
    private List<Hours> loggedHours;

    public User() {
        loggedHours = new ArrayList<>();
    }

    public User(int id) {
        this.id = id;
    }


}
