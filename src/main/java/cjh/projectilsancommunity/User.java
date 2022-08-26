package cjh.projectilsancommunity;

import java.util.Date;
import java.util.Objects;

public class User {
    private int pk;
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date birth;
    private String sns;
    private Date reg_date;


    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return pk == user.pk && id.equals(user.id) && pwd.equals(user.pwd) && name.equals(user.name) && email.equals(user.email) && birth.equals(user.birth) && Objects.equals(sns, user.sns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, id, pwd, name, email, birth, sns);
    }

    @Override
    public String toString() {
        return "User{" +
                "pk=" + pk +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", sns='" + sns + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }
}
