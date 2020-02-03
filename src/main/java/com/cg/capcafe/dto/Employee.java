package com.cg.capcafe.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int empId;
	
	@Column(name = "capgemini_id", nullable = false, unique = true)
	private int capgeminiId;
	
	@Column(length = 25)
	private String email;
	
	private String password;
	
	private double wallet;
	
	// Uni Directional
	@OneToMany(fetch = FetchType.LAZY,
			   cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "employee_id")
	private List<Review> pastReviews;
	
	//Bi Directional
	@OneToMany(fetch = FetchType.LAZY,
			   cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			   mappedBy = "employee")
	private List<Order> pastOrders;
	
	@Column(length = 15)
	private String name;
	
	@Column(length = 10)
	private String gender;
	
	@Column(name = "subscription_date")
	private LocalDate subscriptionDate;
	
	@OneToMany(fetch = FetchType.LAZY,
			   cascade = CascadeType.ALL,
			   mappedBy = "employee")
	@Column(name = "tickets_raised")
	private List<Ticket> ticketsRaised;

	public Employee(int empId, int capgeminiId, String email, String password, double wallet, List<Review> pastReviews,
			List<Order> pastOrders, String name, String gender, LocalDate subscriptionDate) {
		super();
		this.empId = empId;
		this.capgeminiId = capgeminiId;
		this.email = email;
		this.password = password;
		this.wallet = wallet;
		this.pastReviews = pastReviews;
		this.pastOrders = pastOrders;
		this.name = name;
		this.gender = gender;
		this.subscriptionDate = subscriptionDate;
	}
	
	public Employee() {}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCapgeminiId() {
		return capgeminiId;
	}

	public void setCapgeminiId(int capgeminiId) {
		this.capgeminiId = capgeminiId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public List<Review> getPastReviews() {
		return pastReviews;
	}

	public void setPastReviews(List<Review> pastReviews) {
		this.pastReviews = pastReviews;
	}

	public List<Order> getPastOrders() {
		return pastOrders;
	}

	public void setPastOrders(List<Order> pastOrders) {
		this.pastOrders = pastOrders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capgeminiId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empId;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pastOrders == null) ? 0 : pastOrders.hashCode());
		result = prime * result + ((pastReviews == null) ? 0 : pastReviews.hashCode());
		result = prime * result + ((subscriptionDate == null) ? 0 : subscriptionDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(wallet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (capgeminiId != other.capgeminiId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empId != other.empId)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pastOrders == null) {
			if (other.pastOrders != null)
				return false;
		} else if (!pastOrders.equals(other.pastOrders))
			return false;
		if (pastReviews == null) {
			if (other.pastReviews != null)
				return false;
		} else if (!pastReviews.equals(other.pastReviews))
			return false;
		if (subscriptionDate == null) {
			if (other.subscriptionDate != null)
				return false;
		} else if (!subscriptionDate.equals(other.subscriptionDate))
			return false;
		if (Double.doubleToLongBits(wallet) != Double.doubleToLongBits(other.wallet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", capgeminiId=" + capgeminiId + ", email=" + email + ", password="
				+ password + ", wallet=" + wallet + ", pastReviews=" + pastReviews + ", pastOrders=" + pastOrders
				+ ", name=" + name + ", gender=" + gender + ", subscriptionDate=" + subscriptionDate + "]";
	}
	
	
	
	
	

}