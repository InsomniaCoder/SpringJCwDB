package main.itrade.data.entities;

import main.itrade.data.dtos.helper.UserRole;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class User {

    @ManyToOne
    private Company company;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String role;

    //for DTO purpose
    @Transient
    private String company_code;

    @OneToMany(mappedBy = "user")
    private List<LC> lcs;



    /**
     * Constructor
     */
    public User() {
    }

    public User( String role,String userId,String password) {
        this.role = role;
        this.userId = userId;
        this.password = password;
    }

    public User(String userId,String password){
        this.userId = userId;
        this.password = password;
    }

    public static User createUser(UserRole userRole, String userId, String password){
        return new User(userRole.toString(),userId,password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany_code() {
        return company_code;
    }

    public void setCompany_code(String company_code) {
        this.company_code = company_code;
    }

    public List<LC> getLcs() {
        return lcs;
    }

    public void setLcs(List<LC> lcs) {
        this.lcs = lcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
