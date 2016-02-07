package by.resulting.project.AccountingAbonents.entity;

public class Abonent extends Entity {
	
	private String firstName;
	private String secondName;
	private String login;
	private String password;
	private String email;
	private String role;
	private String isActive;
	
	public Abonent() {
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + ((email == null) ? 0 : email.hashCode());
		result = 31 * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = 31 * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = 31 * result + ((login == null) ? 0 : login.hashCode());
		result = 31 * result + ((password == null) ? 0 : password.hashCode());
		result = 31 * result + ((role == null) ? 0 : role.hashCode());
		result = 31 * result + ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Abonent)) {
			return false;
		}
		Abonent other = (Abonent) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (isActive == null) {
			if (other.isActive != null) {
				return false;
			}
		} else if (!isActive.equals(other.isActive)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (role == null) {
			if (other.role != null) {
				return false;
			}
		} else if (!role.equals(other.role)) {
			return false;
		}
		if (secondName == null) {
			if (other.secondName != null) {
				return false;
			}
		} else if (!secondName.equals(other.secondName)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Abonent [firstName=" + firstName + ", secondName=" + secondName + ", login=" + login + ", password="
				+ password + ", email=" + email + ", role=" + role + ", isActive=" + isActive + "]";
	}
	
	
}
