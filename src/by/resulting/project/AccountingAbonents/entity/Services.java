package by.resulting.project.AccountingAbonents.entity;

public class Services extends Entity {
	
	private String serviceName;
	private int serviceCost;
	private String description;
	
	public Services () {
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
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
		result = 31 * result + serviceCost;
		result = 31 * result + ((serviceName == null) ? 0 : serviceName.hashCode());
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
		if (!(obj instanceof Services)) {
			return false;
		}
		Services other = (Services) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (serviceCost != other.serviceCost) {
			return false;
		}
		if (serviceName == null) {
			if (other.serviceName != null) {
				return false;
			}
		} else if (!serviceName.equals(other.serviceName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Services [serviceName=" + serviceName + ", serviceCost=" + serviceCost + ", description=" + description
				+ "]";
	}
	
	
}
