package in.msitprogram.iiit.paypal.accounts;

import java.io.Serializable;

public class Profile implements Serializable
{
	
	private String name;
	private String address;
	@SuppressWarnings("unused")
	private String phone1;
	private int type;
	private String email;
	private String phone;
	
	public int getType() {
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}
    public String getphone()
    {
    	return phone;
    }
    public void setphone(String phone)
    {
    	this.phone = phone;
    }
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
