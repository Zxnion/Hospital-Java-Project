import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Reteracion Karl Zion Demandaco
 * Student ID: 22027336
 * Class: E65D
 * Date/Time Last modified: 1/5/2023
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		
		//-------------------
		// Complete code here
		//-------------------
		
		wardArr[0] = new Ward("A", "1 Bed, attached bath/toilet", 10, 535.00);
		wardArr[1] = new Ward("B1", "4 Bed, attached bath/toilet", 20, 263.43);
		wardArr[2] = new Ward("B2", "6 Bed, common bath/toilet", 20, 83.00);
		wardArr[3] = new Ward("C", "8 Bed, common bath/toilet", 50, 37.00);

		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		//-------------------
		// Complete code here
		//-------------------
		
		patientList.add(new Patient("111A", "John Lee", "A", 2, "01/12/2022"));
		patientList.add(new Patient("222B", "Mary Jane", "B1", 11, "02/12/2022"));
		patientList.add(new Patient("333C", "Abdul Musri", "B1", 12, "03/12/2022"));
		patientList.add(new Patient("444D", "Jane Tan", "B2", 2, "12/12/2022", "", 3));
		patientList.add(new Patient("555E", "Paul Tan", "C", 2, "02/11/2022", "", 4));
		patientList.add(new Patient("666F", "Paul Ng", "C", 3, "-", "03/11/2022", "09/11/2022", 0));
		patientList.add(new Patient("777G", "Wong Kuan", "C", 4, "02/12/2022"));
		
		
		
		
		
		

		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 10) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				patientfound = setPatientCategory(patientList);
			} else if (option == 10) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			
			

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("******   PATIENT  MANAGEMENT  MENU     ******");
		Helper.line(45, "*");
		
		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println("1. View all Ward Info\n2. Display Patient List\n3. Admit Patient\n4. Discharge Patient\n5. Remove Patient\n6. Register Visit\n7. End Visit\n8. Display Ward Overview\n9. Update Patient Category\n10. Logout");
		
	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******      VIEW ALL WARD INFO       *******");
		Helper.line(45, "*");
		
		String line = "_";
		System.out.println(" " + line.repeat(82) );
		String output = String.format("|%-17s %-30s %-20s %s  |\n|%s|", "Ward", "Description", "Bed Count", "Bed Charge", line.repeat(82));
		for (int i = 0; i < wardArr.length; i++) {
			
			output += String.format("\n|%-10s %-40s %-20d%-10.2f| \n",wardArr[i].getWard(), wardArr[i].getDescription(), wardArr[i].getBedCount(), wardArr[i].getBedCharge());
			output += String.format("|%s|" , line.repeat(82));
			
		}
		System.out.println(output);
		
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******     DISPLAY PATIENT LIST      *******");
		Helper.line(45, "*");
		
		String line = "_";
		System.out.println(" " + line.repeat(130) );
		
		String output = String.format("|%-10s %-30s %-10s %-7s %-12s %-20s %-20s %s |\n|%s|", "NRIC4", "Name", "Ward", "Bed", "Category", "Date Warded", "Date Discharged", "Visitor Count", line.repeat(130));
		for (int i = 0; i < patientList.size(); i++) {
			
				String Nric4 = patientList.get(i).getNric4();
				String Name = patientList.get(i).getName();
				String Ward = patientList.get(i).getWard();
				int Bed = patientList.get(i).getBed();
				String DateWarded = patientList.get(i).getDateWarded();
				String DateDischarged = patientList.get(i).getDateDischarged();
				int VC = patientList.get(i).getVisitorCount();
				String C = patientList.get(i).getCategory();
			
				output += String.format("\n|%-10s %-30s %-10s %-10d %-9s %-22s %-25s %-7d| \n",Nric4, Name, Ward, Bed, C, DateWarded, DateDischarged, VC);
				output += String.format("|%s|" , line.repeat(130));
		}
		System.out.println(output);
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		//-------------------
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******         ADMIT PATIENT         *******");
		Helper.line(45, "*");
		
		String nric = Helper.readString("\nEnter patient 4 digit NRIC > ");
		String patient = Helper.readString("Enter patient name > ");
		String ward = Helper.readString("Enter ward > ");
		int bed = Helper.readInt("Enter bed > ");
		String dateWarded = Helper.readString("Enter date warded > ");
		String category = Helper.readString("Enter category > ");
		System.out.println();
		
		if (category.equalsIgnoreCase("1") == true || category.equalsIgnoreCase("2") == true || category.equalsIgnoreCase("3") == true) {
		patientList.add(new Patient(nric, patient, ward, bed, category, dateWarded));
		}
		if (category.equalsIgnoreCase("0") == true) {
		patientList.add(new Patient(nric, patient, ward, bed, dateWarded));
		System.out.println("*** Please wait for diagnosis on patient ***\n");
		}
		
		
		for (int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getNric4() == nric) {
				patientList.get(i).display();
				System.out.println("\n *** Patient has been added ***");
			}
		}
		
		
		
	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******       DISCHARGE PATIENT       *******");
		Helper.line(45, "*");
		
		String patient_4 = Helper.readString("\nEnter patient name > ");
		int DC = 0;
		for (int i = 0; i < patientList.size(); i++) {
			boolean TOF = patientList.get(i).getName().equalsIgnoreCase(patient_4);
			if (TOF != patientfound && patientList.get(i).getDateDischarged() == "") {
				System.out.println();
				patientList.get(i).display();
				
				String DD = Helper.readString("\nEnter date discharged > ");
				patientList.get(i).setDateDischarged(DD);
				patientList.get(i).setVisitorCount(0);
				patientList.get(i).setCategory("-");
				System.out.println("\n*** Patient is discharged ***");
				DC += 1;
			}
				
			else if (TOF != patientfound && patientList.get(i).getDateDischarged() != "") {
				System.out.println("\n*** Patient has already been discharged ***");
				DC += 1;
			}
		}
		
		if (patientfound == false && DC == 0) {
			System.out.println("\n*** No such patient in ward ***");
		}
		
		if (DC != 0) {
			patientfound = true;
		}
		
		return patientfound;
	}





	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******        REMOVE PATIENT         *******");
		Helper.line(45, "*");
		
		String patient_4 = Helper.readString("\nEnter patient name > ");
		int DC = 0;
		for (int i = 0; i < patientList.size(); i++) {
			boolean TOF = patientList.get(i).getName().equalsIgnoreCase(patient_4);
			if (TOF != patientfound) {
				System.out.println();
				patientList.get(i).display();
				
				String YN = Helper.readString("\nConfirm deletion (y/n) >  ");
				
				if (YN.equalsIgnoreCase("y")) {
					patientList.remove(i);
					System.out.println("\n*** Patient has been deleted ***");
					DC += 1;
					}
				
				else if (YN.equalsIgnoreCase("n")) {
					DC += 1;
					}	
			}
		}
		
		if (patientfound == false && DC == 0) {
			System.out.println("\n*** No such patient in ward ***");
		}
		
		if (DC != 0) {
			patientfound = true;
		}
		
		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******        REGISTER VISIT         *******");
		Helper.line(45, "*");
		
		String patient_4 = Helper.readString("\nEnter patient name > ");
		int DC = 0;
		for (int i = 0; i < patientList.size(); i++) {
			boolean TOF = patientList.get(i).getName().equalsIgnoreCase(patient_4);
			if (TOF != patientfound && patientList.get(i).getDateDischarged() == "") {
				System.out.println();
				patientList.get(i).display();
				int V = 4 - patientList.get(i).getVisitorCount();
				
				if (V > 0 && patientList.get(i).getDateDischarged() == "") {
				System.out.println("\n*** Only " + V + " visitor(s) allowed ***\n");
				int YN = Helper.readInt("\nEnter number of new visitors  >  ");
				
				if (0 < YN && YN <= 4 && YN <= V) {
					int current_v = patientList.get(i).getVisitorCount();
					patientList.get(i).setVisitorCount(current_v + YN);
					System.out.println("\n*** Please proceed to ward ***");
					DC += 1;
					}
				else if (YN > V) {
					System.out.println("\n*** Visitors excedeed ***");
					DC += 1;
				   }
				}
				
				if (V == 0) {
					System.out.println("\n*** No additional visitor allowed ***");
					DC += 1;
				}
				
			}
			else if (TOF != patientfound && patientList.get(i).getDateDischarged() != "") {
				System.out.println();
				patientList.get(i).display();
				System.out.println("\n*** Patient has been discharged ***");
				DC += 1;
			}
		}
		
		if (patientfound == false && DC == 0) {
			System.out.println("\n*** No such patient in ward ***");
		} 
		if (DC != 0) {
			patientfound = true;
		}
		
		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******         ENDING VISIT          *******");
		Helper.line(45, "*");
		
		String patient_4 = Helper.readString("\nEnter patient name > ");
		int DC = 0;
		for (int i = 0; i < patientList.size(); i++) {
			boolean TOF = patientList.get(i).getName().equalsIgnoreCase(patient_4);
			if (TOF != patientfound && patientList.get(i).getDateDischarged() != "") {
				System.out.println();
				patientList.get(i).display();
				System.out.println("\n*** Patient has been discharged ***");
				DC += 1;
			}
			
			if (TOF != patientfound && patientList.get(i).getDateDischarged() == "") {
				System.out.println();
				patientList.get(i).display();
				int V = patientList.get(i).getVisitorCount();
				
				if (V <= 4) {
				int YN = Helper.readInt("\nEnter number of new visitor(s) leaving  >  ");
				
				if (0 < YN && YN < 5 && YN <= V) {
					int current_v = patientList.get(i).getVisitorCount();
					patientList.get(i).setVisitorCount(current_v - YN);
					int remain = patientList.get(i).getVisitorCount();
					System.out.println("\n*** No of visitor(s) still at ward : " + remain + " ***");
					DC += 1;	
					}
				else if (YN > V) {
					System.out.println("\n*** Visitor(s) leaving is more than visited ***");
					DC += 1;
				}
			  }
			}
		}
		
		if (patientfound == false && DC == 0) {
			System.out.println("\n*** No such patient in ward ***");
		}
		if (DC != 0) {
			patientfound = true;
		}
		
		return patientfound;
	}

	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] WardArr) {

		//-------------------
		// Complete code here
		//-------------------
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******   DISPLAYING WARD OVERVIEW    *******");
		Helper.line(45, "*");
		String line = "_";
		System.out.println(" " + line.repeat(125) );
		String output = String.format("|%-15s %-25s %-20s %-20s %-20s %-19s |\n|%s|", "Ward", "Description", "Total Patients","Total Visitors","Total Bed Count", "Total Bed Charge",line.repeat(125));
		
		int total_VC = 0;
		int total_patient = 0;
		int total_BC = 0;
		double total_charge = 0;
		int[] wardno = {0, 0 ,0 ,0};
		int[] wardVC = {0, 0 ,0 ,0};
		double[] wardCharge = {0.0, 0.0, 0.0, 0.0};
		

		
		for (int x = 0; x < patientList.size(); x++) {
			String PWard = patientList.get(x).getWard();
			int VC = patientList.get(x).getVisitorCount();
			
			
			if (patientList.get(x).getDateDischarged() == "") {
				
				if (PWard.equalsIgnoreCase("A")) {
					wardno[0] += 1;
					total_patient += 1;
					wardVC[0] += VC;
					total_VC += VC;
					wardCharge[0] += 535.00;
					total_charge += 535.00;
				}
				
				if (PWard.equalsIgnoreCase("B1")) {
					wardno[1] += 1;
					total_patient += 1;
					wardVC[1] += VC;
					total_VC += VC;
					wardCharge[1] += 266.43;
					total_charge += 266.43;
				}
				
				if (PWard.equalsIgnoreCase("B2")) {
					wardno[2] += 1;
					total_patient += 1;
					wardVC[2] += VC;
					total_VC += VC;
					wardCharge[2] += 83.00;
					total_charge += 83.00;
				}
				
				if (PWard.equalsIgnoreCase("C")) {
					wardno[3] += 1;
					total_patient += 1;
					wardVC[3] += VC;
					total_VC += VC;
					wardCharge[3] += 37.00;
					total_charge += 37.00;
				}
			}
		}
		
		for (int i = 0; i < WardArr.length; i++) {
			String Ward = WardArr[i].getWard();
			String Description = WardArr[i].getDescription();
			int Bed = WardArr[i].getBedCount();
				if (Bed != 0) {
					total_BC += Bed;
				}		
				output += String.format("\n|%-10s %-36s %-20d %-20d %-20d %-14.2f| \n", Ward, Description, wardno[i], wardVC[i], Bed, wardCharge[i]);
				output += String.format("|%s|" , line.repeat(125));
		}
		System.out.println(output);
		
		System.out.println(String.format("\nTotal Patients for all wards: %d \nTotal Visitors for all wards: %d \nTotal Bed Count for all wards: %d \nTotal Bed Charge for all wards: $%.2f", total_patient, total_VC, total_BC, total_charge));
	}
	
	
	public static boolean setPatientCategory(ArrayList<Patient> patientList) {
		boolean patientfound = false;
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*******   DISPLAYING CATEGORY MENU    *******");
		Helper.line(45, "*");
		
		System.out.println("* - is for discharged patients");
		System.out.println("* 0 is for undiagnosed patients");
		System.out.println("* 1 is for mild which include fever, cough ,etc;");
		System.out.println("* 2 is for moderate which include fainting, dislocation, etc;");
		System.out.println("* 3 is for severe which include fractures, covid-19 etc;");
		
		String patient_4 = Helper.readString("\nEnter patient name > ");
		int DC = 0;
		for (int i = 0; i < patientList.size(); i++) {
			boolean TOF = patientList.get(i).getName().equalsIgnoreCase(patient_4);
			if (TOF != patientfound && patientList.get(i).getDateDischarged() != "") {
				System.out.println();
				patientList.get(i).display();
				System.out.println("\n*** Patient has been discharged ***");
				DC += 1;
			}
			
			if (TOF != patientfound && patientList.get(i).getDateDischarged() == "") {
				System.out.println();
				patientList.get(i).display();
				
				String new_C = Helper.readString("\nEnter category > ");
				if (new_C.equalsIgnoreCase("1") || new_C.equalsIgnoreCase("2") || new_C.equalsIgnoreCase("3")) {
				patientList.get(i).setCategory(new_C);
				System.out.println("\n*** Category has been updated ***");
				DC += 1;
				}
				else {
				System.out.println("\n*** Invalid category entered ***");
				DC += 1;
				}
				
			}
			
		}
		
		if (patientfound == false && DC == 0) {
			System.out.println("\n*** No such patient in ward ***");
		}
		if (DC != 0) {
			patientfound = true;
		}
		
		
		return patientfound;
		
	}


}