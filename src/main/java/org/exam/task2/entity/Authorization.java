package org.exam.task2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Configure the Authorization class as a hibernate entity.
 * 
 * @author Felipe Perez
 *
 */

@Entity
@Table(name = "authorization")
public class Authorization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "description")
	@NotNull(message = "description is required")
	private String description;

	@Column(name = "amount")
	@NotNull(message = "amount is required")
	private Double amount;

	@Column(name = "status")
	@NotNull(message = "status is required")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Authorization [id=" + id + ", description=" + description + ", amount=" + amount + ", status=" + status
				+ "]";
	}

	
}
