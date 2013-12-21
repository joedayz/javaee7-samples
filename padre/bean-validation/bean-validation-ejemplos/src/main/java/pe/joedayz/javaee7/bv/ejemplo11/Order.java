package pe.joedayz.javaee7.bv.ejemplo11;

import java.util.Date;

import javax.validation.constraints.Pattern;


public class Order {
	 // ======================================
	  // =             Attributes             =
	  // ======================================

	  @Pattern.List({
	          @Pattern(regexp = "[C,D,M][A-Z][0-9]*"),
	          @Pattern(regexp = ".[A-Z].*?")
	  })
	  private String orderId;
	  private Date creationDate;
	  private Double totalAmount;
	  private Date paymentDate;
	  private Date deliveryDate;

	  // ======================================
	  // =            Constructors            =
	  // ======================================

	  public Order() {
	  }

	  // ======================================
	  // =          Getters & Setters         =
	  // ======================================

	  public String getOrderId() {
	    return orderId;
	  }

	  public void setOrderId(String orderId) {
	    this.orderId = orderId;
	  }

	  public Date getCreationDate() {
	    return creationDate;
	  }

	  public void setCreationDate(Date creationDate) {
	    this.creationDate = creationDate;
	  }

	  public Double getTotalAmount() {
	    return totalAmount;
	  }

	  public void setTotalAmount(Double totalAmount) {
	    this.totalAmount = totalAmount;
	  }

	  public Date getPaymentDate() {
	    return paymentDate;
	  }

	  public void setPaymentDate(Date paymentDate) {
	    this.paymentDate = paymentDate;
	  }

	  public Date getDeliveryDate() {
	    return deliveryDate;
	  }

	  public void setDeliveryDate(Date deliveryDate) {
	    this.deliveryDate = deliveryDate;
	  }
}
