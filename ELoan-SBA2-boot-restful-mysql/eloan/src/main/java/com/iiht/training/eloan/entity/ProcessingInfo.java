package com.iiht.training.eloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProcessingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long loanAppId;
	private Long loanClerkId;

	@NotNull(message = "Acres cannot be null. Land Acres is required!")
	@Min(value = 1, message = "Acres should be atleast 1 year!")
	private Double acresOfLand;

	@NotNull(message = "Land value cannot be null. Land value is required!")
	@Min(value = 1, message = "Land value should be greater than 0!")
	private Double landValue;

	private String appraisedBy;
	private String valuationDate;

	@NotBlank(message = "Address of property cannot be null. Property Address is required!")
	@Size(min = 3, max = 100)
	private String addressOfProperty;

	@NotNull(message = "Suggested amount cannot be null. Suggested lOAN Amount  is required!")
	@Min(value = 1, message = "Suggested loan Amount cannot be 0.")
	private Double suggestedAmountOfLoan;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLoanAppId() {
		return loanAppId;
	}
	public void setLoanAppId(Long loanAppId) {
		this.loanAppId = loanAppId;
	}
	public Long getLoanClerkId() {
		return loanClerkId;
	}
	public void setLoanClerkId(Long loanClerkId) {
		this.loanClerkId = loanClerkId;
	}
	public Double getAcresOfLand() {
		return acresOfLand;
	}
	public void setAcresOfLand(Double acresOfLand) {
		this.acresOfLand = acresOfLand;
	}
	public Double getLandValue() {
		return landValue;
	}
	public void setLandValue(Double landValue) {
		this.landValue = landValue;
	}
	public String getAppraisedBy() {
		return appraisedBy;
	}
	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}
	public String getValuationDate() {
		return valuationDate;
	}
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}
	public String getAddressOfProperty() {
		return addressOfProperty;
	}
	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}
	public Double getSuggestedAmountOfLoan() {
		return suggestedAmountOfLoan;
	}
	public void setSuggestedAmountOfLoan(Double suggestedAmountOfLoan) {
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
	}


}
