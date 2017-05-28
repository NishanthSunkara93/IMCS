package com.assessment2.imcs.classes;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreditCardDetails {
    
	private Passenger passenger;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PassengerProfileId", referencedColumnName="profileId")
	private int profileId;
    private long cardNumber;
    private String cardType;
    private int expirationMonth;
    private int expirationYear;
	
    
    public CreditCardDetails() {
		super();
	}
	public CreditCardDetails(Passenger passengerprofile, int profileId, long cardNumber, String cardType,
			int expirationMonth, int expirationYear) {
		super();
		this.passenger = passengerprofile;
		this.profileId = profileId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}
	public Passenger getPassengerprofile() {
		return passenger;
	}
	public void setPassengerprofile(Passenger passengerprofile) {
		this.passenger = passengerprofile;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public int getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cardNumber ^ (cardNumber >>> 32));
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + expirationMonth;
		result = prime * result + expirationYear;
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
		result = prime * result + profileId;
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
		CreditCardDetails other = (CreditCardDetails) obj;
		if (cardNumber != other.cardNumber)
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (expirationMonth != other.expirationMonth)
			return false;
		if (expirationYear != other.expirationYear)
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		if (profileId != other.profileId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreditCardDetails [passengerprofile=" + passenger + ", profileId=" + profileId + ", cardNumber="
				+ cardNumber + ", cardType=" + cardType + ", expirationMonth=" + expirationMonth + ", expirationYear="
				+ expirationYear + "]";
	}
    
		 
}
