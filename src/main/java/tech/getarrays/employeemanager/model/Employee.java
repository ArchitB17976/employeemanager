package tech.getarrays.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee implements Serializable
{
    @Id
    @SequenceGenerator(name = "id_gen", initialValue = 10110, allocationSize = 1)
    @GeneratedValue(generator = "id_gen")
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String codeName;

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getCodeName() { return codeName; }
    public void setCodeName(String codeName) { this.codeName = codeName; }

    // Constructors
    public Employee() {}
    public Employee(
        long id, 
        String name, String email, String jobTitle, 
        String phone, String imageUrl, String codeName
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.codeName = codeName;
    }

    // toString implementation
    @Override
    public String toString() 
    {
        return "Employee{" + 
                "id" + id + "/" + 
                "name" + name + "/" + 
                "email" + email + "/" + 
                "jobTitle" + jobTitle + "/" + 
                "phone" + phone + "/" + 
                "imageUrl" + imageUrl + "/";
    }
}
