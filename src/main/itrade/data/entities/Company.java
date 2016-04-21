package main.itrade.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String country;

    /*
      self join relation
     */
    @OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Company> children;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Company.class)
    private Company parent;


    @OneToMany(mappedBy="company")
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<LimitInfo> limitInfos;


    public Company() {
    }

    public Company(String code, String name) {
        this.code = code;
        this.name = name;
    }


    public static Company createCompanyByCodeName(String code, String name){
        return new Company(code,name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setChildren(List<Company> children) {
        this.children = children;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public List<Company> getChildren() {
        if(children == null){
            children = new ArrayList<>();
        }
        return children;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<LimitInfo> getLimitInfos() {
        return limitInfos;
    }

    public void setLimitInfos(List<LimitInfo> limitInfos) {
        this.limitInfos = limitInfos;
    }
}
