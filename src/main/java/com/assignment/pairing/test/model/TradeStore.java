package com.assignment.pairing.test.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TradesStore")
public class TradeStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String tradeId;

	private int version;

	private String counterId;

	private String bookId;

	private LocalDate maturityDate;

	private LocalDate createdDate;

	private String expired;

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterId() {
		return counterId;
	}

	public void setCounterId(String counterId) {
		this.counterId = counterId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "TradeStore [tradeId=" + tradeId + ", version=" + version + ", counterId=" + counterId + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + ", expired=" + expired
				+ "]";
	}

}
