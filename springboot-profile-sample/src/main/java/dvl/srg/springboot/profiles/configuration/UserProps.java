package dvl.srg.springboot.profiles.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("user.createation")
public class UserProps {

    private int id;
    private String fname;
    private String lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "UserProps{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname=" + lname +
                '}';
    }
}
