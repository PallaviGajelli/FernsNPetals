package fernsNPetals.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

import cucumber.api.java.ca.Cal;

public class CurrentDate {

	
//		  @Test
//	      public void date() {
//		  // Instantiate a Date object by invoking its constructor
//		  Date objDate = new Date();
//		  // Display the Date & Time using toString()
//		  System.out.println(objDate);
//		  System.out.println("============================");
//		  }
//		  
//		  @Test
//		  public void simpledate() {
//	      Date objDate1 = new Date(); // Current System Date and time is assigned to objDate
//		  System.out.println(objDate1);
//		  String strDateFormat = "hh:mm:ss a dd-MMM-yyyy"; //Date format is Specified
//		  SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
//		  System.out.println(objSDF.format(objDate1)); //Date formatting is applied to the current date
//		  System.out.println("============================");
//		 }
//		  
//		  @Test
//		  public void TestDates_Compare() throws ParseException {
//	   	       SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
//			   Date dt_1 = objSDF.parse("20-08-1981");
//			   Date dt_2 = objSDF.parse("12-10-2012");
//
//			   System.out.println("Date1 : " + objSDF.format(dt_1));
//			   System.out.println("Date2 : " + objSDF.format(dt_2));
//
//			   if (dt_1.compareTo(dt_2) > 0) {
//			    System.out.println("Date 1 occurs after Date 2");
//			   } // compareTo method returns the value greater than 0 if this Date is after the Date argument.
//			   else if (dt_1.compareTo(dt_2) < 0) {
//			    System.out.println("Date 1 occurs before Date 2");
//			   } // compareTo method returns the value less than 0 if this Date is before the Date argument;
//			   else if (dt_1.compareTo(dt_2) == 0) {
//			    System.out.println("Both are same dates");
//			   } // compareTo method returns the value 0 if the argument Date is equal to the second Date;
//			   else {
//			    System.out.println("You seem to be a time traveller !!");
//			   }
//	}
//		  
		  
		  @Test
		  public void after2days() {
			  Date date =new Date();
			  SimpleDateFormat dateF = new SimpleDateFormat("yyyy/MM/dd");
			  SimpleDateFormat dateF2 = new SimpleDateFormat("dd/MM/yyyy");
			  SimpleDateFormat dateF3 = new SimpleDateFormat("dd-MM-yyyy");
			  SimpleDateFormat dateF4 = new SimpleDateFormat("dd-MMM-yyyy");
			  SimpleDateFormat dateF5 = new SimpleDateFormat("dd-MMMM-yyyy");
			  System.out.println(dateF.format(date));
			  //String d =objSDF1.format(objDate2);
			  Calendar cal=Calendar.getInstance();
			  cal.setTime(date);
			  cal.add(Calendar.DATE, 2);
			  //System.out.println("|Date| " +objSDF1.DATE_FIELD);
//			System.out.println(dateF.format(cal.getTime()));
//			System.out.println(dateF2.format(cal.getTime()));
//			System.out.println(dateF3.format(cal.getTime())); 
//			System.out.println(dateF4.format(cal.getTime()));  
//			System.out.println(dateF5.format(cal.getTime()));
			String s = dateF.format(cal.getTime());
			System.out.println(s);
			String Ad[]=s.split("/");
			String dd=Ad[0];
			String MM=Ad[1];
			String yy=Ad[2];
			System.out.println(dd);
			System.out.println(MM);
			System.out.println(yy);
			System.out.println("================");
			System.out.println(Ad[0]);
			System.out.println(Ad[1]);
			System.out.println(Ad[2]);
			
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
}

