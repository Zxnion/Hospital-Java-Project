/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Reteracion Karl Zion Demandaco
 * Student ID: {22027336}
 * Class: {E65D}
 * Date/Time created: Wednesday 30-11-2022 14:44
 */

/**
 * @author 22027336
 *
 */
public class Patient {
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	private String category;
	
	public Patient(String nr, String n, String w, int b, String C, String dW, String dD, int vC) {
		this.nric4 = nr;
		this.name = n;
		this.ward = w;
		this.bed = b;
		this.dateWarded = dW;
		this.dateDischarged = dD;
		this.visitorCount = vC;
		this.category = C;
	}
	public Patient(String nr, String n, String w, int b, String dW, String dD, int vC) {
		this.nric4 = nr;
		this.name = n;
		this.ward = w;
		this.bed = b;
		this.dateWarded = dW;
		this.dateDischarged = dD;
		visitorCount = vC;
		category = "0";
	}
	
// Constructor overload
	public Patient(String nr, String n, String w, int b, String dW) {
		this.nric4 = nr;
		this.name = n;
		this.ward = w;
		this.bed = b;
		this.dateWarded = dW;
		this.dateDischarged = "";
		this.visitorCount = 0;
		this.category = "0";
	}
	
	public Patient(String nr, String n, String w, int b, String C, String dW) {
		this.nric4 = nr;
		this.name = n;
		this.ward = w;
		this.bed = b;
		this.dateWarded = dW;
		this.dateDischarged = "";
		this.visitorCount = 0;
		this.category = C;
	}
	
	public String getNric4() {
		return nric4;
	}
	
    public String getName() {
		return name;
	}

    public String getWard() {
    	return ward;
    }
    
    public int getBed() {
		return bed;
	}
    
    public String getDateWarded() {
    	return dateWarded;
    }
    
    public String getDateDischarged() {
    	return dateDischarged;
    }
    
    public void setDateDischarged(String dateDischarged) {
    	this.dateDischarged = dateDischarged;
    }
    
    public int getVisitorCount() {
    	return visitorCount;
    }
    
    public void setVisitorCount(int visitorCount) {
    	this.visitorCount = visitorCount;
    }
    public String getCategory() {
    	return category;
    }
    public void setCategory (String C) {
    	this.category = C;
    }
    
    public void display() {
    	System.out.println("Patient Name      : " + getName());
    	System.out.println("Ward              : " + getWard());
    	System.out.println("Bed               : " + getBed());
    	System.out.println("Category          : " + getCategory());
    	System.out.println("Date Warded       : " + getDateWarded());
    	System.out.println("Date Discharged   : " + getDateDischarged());
    	System.out.println("No of visitor(s)  : " + getVisitorCount());
    	
    }

	
}
