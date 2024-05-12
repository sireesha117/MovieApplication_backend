package com.MovieApplication.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data

public class Ticket {
	@Transient
	@JsonIgnore
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Id
	@GeneratedValue
	private int transactionId;
	private int movie_id_fk;
	private String user_name_fk;
	private String theatreName;
	private int no_of_tickets;
	private String issueAt = formatter.format(new Date());
	private String showTime;
	private double totalPrice;

	public Ticket() {
	}

	public Ticket(int movie_id_fk, int no_of_tickets, String showTime, double totalPrice) {
		super();

		this.movie_id_fk = movie_id_fk;
		this.user_name_fk = user_name_fk;
		this.no_of_tickets = no_of_tickets;

		this.showTime = showTime;
		this.totalPrice = totalPrice;
	}

	public Ticket(int movie_id_fk, int no_of_tickets) {
		super();

		this.movie_id_fk = movie_id_fk;
		this.user_name_fk = user_name_fk;
		
		this.no_of_tickets = no_of_tickets;

	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getUser_name_fk() {
		return user_name_fk;
	}

	public void setUser_name_fk(String user_name_fk) {
		this.user_name_fk = user_name_fk;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getMovie_id_fk() {
		return movie_id_fk;
	}

	public void setMovie_id_fk(int movie_id_fk) {
		this.movie_id_fk = movie_id_fk;
	}

	public int getNo_of_tickets() {
		return no_of_tickets;
	}

	public void setNo_of_tickets(int no_of_tickets) {
		this.no_of_tickets = no_of_tickets;
	}

	public String getIssueAt() {
		return issueAt;
	}

	public void setIssueAt(String issueAt) {
		this.issueAt = issueAt;
	}

	@Override
	public String toString() {
		return "Ticket [transactionId=" + transactionId + ", movie_id_fk=" + movie_id_fk + ", user_name_fk="
				+ user_name_fk + ", theatreName=" + theatreName + ", no_of_tickets=" + no_of_tickets + ", issueAt="
				+ issueAt + ", showTime=" + showTime + ", totalPrice=" + totalPrice + "]";
	}

	

}
