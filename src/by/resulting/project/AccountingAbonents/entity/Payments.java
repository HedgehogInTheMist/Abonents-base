package by.resulting.project.AccountingAbonents.entity;

public class Payments {
	
	private String paymentDate;
	private long serviceId;
	private long userId;
	private boolean isPaid;
	private String description;
	
	public Payments() {
	}

	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((description == null) ? 0 : description.hashCode());
		result = 31 * result + (isPaid ? 1231 : 1237);
		result = 31 * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = 31 * result + (int) (serviceId ^ (serviceId >>> 32));
		result = 31 * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Payments)) {
			return false;
		}
		Payments other = (Payments) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (isPaid != other.isPaid) {
			return false;
		}
		if (paymentDate == null) {
			if (other.paymentDate != null) {
				return false;
			}
		} else if (!paymentDate.equals(other.paymentDate)) {
			return false;
		}
		if (serviceId != other.serviceId) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Payments [paymentDate=" + paymentDate + ", serviceId=" + serviceId + ", userId=" + userId + ", isPaid="
				+ isPaid + ", description=" + description + "]";
	}
	
	
}
