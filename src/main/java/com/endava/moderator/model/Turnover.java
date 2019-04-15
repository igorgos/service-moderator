package com.endava.moderator.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Superclass for all payment classes.
 * @see com.andoria.entity.payment.Advance
 * @see com.andoria.entity.payment.Commitment
 * @see com.andoria.entity.payment.Receipt
 * @see com.andoria.entity.payment.Transaction
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "transactions")
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public class Turnover implements Serializable {
	public static final String TRANSACTION = "T";
	public static final String RECEIPT = "R";
	public static final String COMMITMENT = "C";
	public static final String ADVANCE = "A";
	public static final int CHARGE = 0; 
	public static final int PAYMENT = 1;
	public static final boolean PAID_NO = false; 
	public static final boolean PAID_YES = true;
	public static final boolean CANCELED_NO = false; 
	public static final boolean CANCELED_YES = true; 
	
	private Long id;
	private Long creditId;
	private Integer paymentTypeId;
	private Integer rateNumber;
	private Date paymentDate;
	private Date paidDate;
	private String payer;
	private BigDecimal amount;
	private Integer paymentCharge;
	private Boolean paid = PAID_NO;
	private Boolean canceled = CANCELED_NO;
	private String processor;
	private String comments;
	private boolean immediate;
	private Long receiptId;
	private Long splitTransactionId;
	private Date createdAt;
	private Integer createdBy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "credit_id")
	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	@Column(name = "payment_type_id")
	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	@Column(name = "rate_number")
	public Integer getRateNumber() {
		return rateNumber;
	}

	public void setRateNumber(Integer rateNumber) {
		this.rateNumber = rateNumber;
	}

	/**
	 * For payments - the date when the payment actually was made. 
	 * For charges - the date when specified amount must be payed.  
	 * @return payment date
	 */
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Se referă doar la taxe.
	 * Reprezintă data achitării taxei.
	 * @return data achitarii, sau NULL daca taxa nu e achitată.
	 */
	@Column(name = "paid_date")
	@Temporal(TemporalType.DATE)
	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	@Column(name = "payer")
	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	@Column(name = "amount")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Transient
	public BigDecimal getPaymentAmount() {
		return (getPaymentCharge().intValue() == PAYMENT ? getAmount() : BigDecimal.ZERO);
	}
	
	@Transient
	public BigDecimal getChargeAmount() {
		return (getPaymentCharge().intValue() == CHARGE ? getAmount() : BigDecimal.ZERO);
	}

	/**
	 * Admissible values:
	 * <ul>
	 * <li>0 - charge,</li>
	 * <li>1 - payment.</li>
	 * </ul> 
	 * @return
	 */
	@Column(name = "payment_charge")
	public Integer getPaymentCharge() {
		return paymentCharge;
	}

	public void setPaymentCharge(Integer paymentCharge) {
		this.paymentCharge = paymentCharge;
	}

	/**
	 * Este sau nu achitată ranzacţia dată:
	 * <ul>
	 * <li>0 - tranzacţia este achitată,</li>
	 * <li>1 - tranzacţia nu este achitată.</li>
	 * </ul> 
	 * @return TRUE dacă 1, şi FALSE dacă 0.
	 */
	@Column(name = "paid")
	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	/**
	 * Este sau nu anulată tranzacţia dată:
	 * <ul>
	 * <li>0 - tranzacţia este anulată,</li>
	 * <li>1 - tranzacţia nu este anulată.</li>
	 * </ul> 
	 * @return TRUE dacă 1, şi FALSE dacă 0.
	 */
	@Column(name = "canceled")
	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	@Column(name = "processor")
	public String getProcessor() {
		return processor;
	}
	
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	@Column(name = "comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "immediate")
	public boolean isImmediate() {
		return immediate;
	}

	public void setImmediate(boolean immediate) {
		this.immediate = immediate;
	}

	@Column(name = "receipt_id")
	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}
	
	@Column(name = "split_transaction_id")
	public Long getSplitTransactionId() {
		return splitTransactionId;
	}

	public void setSplitTransactionId(Long splitTransactionId) {
		this.splitTransactionId = splitTransactionId;
	}
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@SuppressWarnings("unchecked")
	public <T extends Turnover> T cloneTransaction() {
		T transaction = null;
		try {
			transaction = (T) getClass().newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		transaction.setCreditId(getCreditId());
		transaction.setPaymentTypeId(getPaymentTypeId());
		transaction.setRateNumber(getRateNumber());
		transaction.setAmount(getAmount());
		transaction.setPaymentDate(getPaymentDate());
		transaction.setPaidDate(getPaidDate());
		transaction.setCreatedAt(new Date());
		transaction.setCreatedBy(getCreatedBy());
		transaction.setPaymentCharge(getPaymentCharge());
		transaction.setPaid(getPaid());
		transaction.setCanceled(getCanceled());
		transaction.setProcessor(getProcessor());
		transaction.setComments(getComments());
		transaction.setImmediate(isImmediate());
		transaction.setReceiptId(getReceiptId());
		transaction.setSplitTransactionId(getSplitTransactionId());
		return transaction;
	}
	
	public <T extends Turnover> T cloneTransaction(Class<T> clazz) {
		T transaction = null;
		try {
			transaction = clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		transaction.setCreditId(getCreditId());
		transaction.setPaymentTypeId(getPaymentTypeId());
		transaction.setRateNumber(getRateNumber());
		transaction.setAmount(getAmount());
		transaction.setPaymentDate(getPaymentDate());
		transaction.setPaidDate(getPaidDate());
		transaction.setCreatedAt(new Date());
		transaction.setCreatedBy(getCreatedBy());
		transaction.setPaymentCharge(getPaymentCharge());
		transaction.setPaid(getPaid());
		transaction.setCanceled(getCanceled());
		transaction.setProcessor(getProcessor());
		transaction.setComments(getComments());
		transaction.setImmediate(isImmediate());
		transaction.setReceiptId(getReceiptId());
		transaction.setSplitTransactionId(getSplitTransactionId());
		return transaction;
	}
}
