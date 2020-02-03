package com.cg.capcafe.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;
	
	@Column(name = "cafe_id")
	private int cafeId;
	
	private int rating;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	private String review;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafe(int cafeId) {
		this.cafeId = cafeId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getEmployee() {
		return employeeId;
	}

	public void setEmployee(int employeeID) {
		this.employeeId = employeeID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Review(int reviewId, int cafeId, int rating, int employeeId, String review) {
		super();
		this.reviewId = reviewId;
		this.cafeId = cafeId;
		this.rating = rating;
		this.employeeId = employeeId;
		this.review = review;
	}
	
	public Review() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cafeId;
		result = prime * result + employeeId;
		result = prime * result + rating;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + reviewId;
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
		Review other = (Review) obj;
		if (cafeId != other.cafeId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (rating != other.rating)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (reviewId != other.reviewId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", cafeId=" + cafeId + ", rating=" + rating + ", employeeId="
				+ employeeId + ", review=" + review + "]";
	}

	
	
	

}
