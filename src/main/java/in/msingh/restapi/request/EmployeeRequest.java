package in.msingh.restapi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private String name;
	
	private String organization;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	

}
