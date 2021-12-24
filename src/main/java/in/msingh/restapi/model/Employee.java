package in.msingh.restapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.msingh.restapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
		
	//@JsonProperty("full_name")
	@Column(name="name")
	@NotBlank(message="Name should not be equal to null")
	private String name;
	
	//@JsonIgnore
	@Column(name="age")
	@NotNull(message="Age should not be equal to null")
	private Long age;
	
	@Column(name="location")
	@NotEmpty(message="Location should not be equal to null")
	private String location;
	
	@Column(name="email")
	@NotEmpty(message="Email should not be equal to null")
	@Email(message="Please enter the valid email")
	private String email;
	
	@Column(name="department")
	@NotBlank(message="Department should not be equal to null")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + "]";
	}
	
	

}
