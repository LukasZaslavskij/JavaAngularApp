package tech.getarrays.employeemanager.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity //mapuju tuhle tridu do databaze, abych mohl pridavat, upravovat
public class Employee implements Serializable { //Serializable, protoze to budu prevadet na JSON a zase tak atd.
    @Id //urcuji primarni klic
    @GeneratedValue(strategy= GenerationType.IDENTITY) //strategie, jak se bude primarni klic urcovat, v tehle jednoduche appce by to bylo jedno, ktery bychom pouzili
    @Column(nullable = false,updatable = false)  //nesmi byt nula a jakmile je to prideleno, neda se zmenit, kdyz tam nic nedam tak se to asi vygeneruje samo
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;


//konstruktory
    public Employee() {}

    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }
//vygenerovane gettery a settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
//kdyby chtel nekdo videt employee tak at to vypada hezky
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

