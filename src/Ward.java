/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22027336
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Wednesday 30-11-2022 14:36
 */

/**
 * @author 22027336
 *
 */
public class Ward {
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	public Ward(String w, String d, int bco, double bch) {
		this.ward = w;
		this.description = d;
		this.bedCount = bco;
		this.bedCharge = bch;
	}
	
	public String getWard() {
		return ward;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBedCount() {
		return bedCount;
	}
	
	public double getBedCharge() {
		return bedCharge;
	}
	
}
