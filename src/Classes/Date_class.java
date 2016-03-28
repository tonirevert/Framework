package Classes;


import Modules.Config.Classes.Config_class;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author Antonio Revert
 * @version 0.3
 *
 */
@SuppressWarnings("serial")
@XStreamAlias("date_class")
public class Date_class implements Serializable{
	
	/**Private attributes initialisation*/
	@XStreamAlias("day")
	private int day=0;
	@XStreamAlias("month")
	private int month=0;
	@XStreamAlias("year")
	private int year=0;
	@XStreamAlias("date")
	private String date="";
	@XStreamAlias("dateform")
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 *Create a vector object Date_class object 
	 * @param date Gets a String with date format dd/MM/yyy 
	 */
	public Date_class(String date){
		String[] a_date=null;
				
		a_date=date.split("/");
		this.day=Integer.parseInt(a_date[0]);
		this.month=Integer.parseInt(a_date[1]);
		this.year=Integer.parseInt(a_date[2]);
		
		this.date=this.day+"/"+this.month+"/"+this.year;
		
	}
	
//                public Date_class(Calendar dat){
//
//                                        this.day=dat.get(Calendar.DATE);
//                                        this.month=dat.get(Calendar.MONTH);
//                                        this.year=dat.get(Calendar.YEAR);
//                                        this.date=this.day+"/"+this.month+"/"+this.year;
//                }

	/**
	 * Constructor switch case to take in account the date format
	 * @param date Gets a date from a string
	 * @param format To change the date format
	 */
	public Date_class(String date,int number){
		String[] a_date=null;
		
		switch (Config_class.getinstance().getDate_format()) {
		case "dd/MM/yyyy":
			a_date=date.split("/");
			this.day=Integer.parseInt(a_date[0]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[2]);
			this.date=this.day+"/"+this.month+"/"+this.year;
			break;

		case "yyyy/MM/dd":
			a_date=date.split("/");
			this.day=Integer.parseInt(a_date[2]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[0]);
			this.date=this.year+"/"+this.month+"/"+this.day;
			break;
		case "dd-MM-yyyy":
			a_date=date.split("-");
			this.day=Integer.parseInt(a_date[0]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[2]);
			this.date=this.day+"-"+this.month+"-"+this.year;
			break;
		case "yyyy-MM-dd":
			a_date=date.split("-");
			this.day=Integer.parseInt(a_date[2]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[0]);
			this.date=this.year+"-"+this.month+"-"+this.day;
			break;
		default:
			a_date=date.split("/");
			this.day=Integer.parseInt(a_date[0]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[2]);
			this.date=this.day+"/"+this.month+"/"+this.year;
			break;
		}
		
		
	}
	
	/**
	 * Constructor switch case to take in account the date format
	 * @param date Gets a date from a string
	 * @param other Used to create dummy's
	 */
	public Date_class(String date,String Dummy){
		String[] a_date=null;
		
			a_date=date.split("-");
			this.day=Integer.parseInt(a_date[2]);
			this.month=Integer.parseInt(a_date[1]);
			this.year=Integer.parseInt(a_date[0]);
			this.date=this.year+"-"+this.month+"-"+this.day;
	}
	
//        /**
//	 * Constructor switch case to take in account the date format
//	 * @param date Gets a date from a string
//	 * @param format To change the date format
//	 */
//	public graphicdate(String date){
//		String[] a_date=null;
//		
//                        a_date=date.split("-");
//			this.day=Integer.parseInt(a_date[0]);
//			this.month=Integer.parseInt(a_date[1]);
//			this.year=Integer.parseInt(a_date[2]);
//			this.date=this.day+"-"+this.month+"-"+this.year;
//		
//		}
//		
//		
//	}
        
        
	/**Day getter for Date_class*/
	public int getDay() {
		return day;
	}

	/**Day setter for Date_class*/
	public void setDay(int day) {
		this.day = day;
	}

	/**Month getter for Date_class*/
	public int getMonth() {
		return month;
	}

	/**Month setter for Date_class*/
	public void setMonth(int month) {
		this.month = month;
	}

	/**Year getter for Date_class*/
	public int getYear() {
		return year;
	}

	/**Year setter for Date_class*/
	public void setYear(int year) {
		this.year = year;
	}

	/**Date getter for Date_class*/
	public String getDate() {
		return date;
	}
	/**Date setter for Date_class*/
	public void setDate(String date) {
		this.date = date;
	}

	public String toString(){
		String d="";
		d=this.date=getDate();
		return d;
	}
	
	public String toString(int number){
		String d="";
		
		switch (Config_class.getinstance().getDate_format()) {
		case "dd/MM/yyyy":
			//this.day+"/"+this.month+"/"+this.year;
			this.date=this.day+"/"+this.month+"/"+this.year;
			d=this.date=getDate();
			break;
		case "yyyy/MM/dd":
			this.date=this.year+"/"+this.month+"/"+this.day;
			d=this.date=getDate();
			break;
		case "dd-MM-yyyy":
			this.date=this.day+"-"+this.month+"-"+this.year;
			d=this.date=getDate();
			break;
		case "yyyy-MM-dd":
			this.date=this.year+"-"+this.month+"-"+this.day;
			d=this.date=getDate();
			break;
		}
		return d;
	}
	
	public static String CalendartoString(Calendar date){
		String cal=sdf.format(date);
	      return cal;
	}
	
	/**
	 * Convert a String to Calendar
	 * @return A Calendar object
	 */
	public Calendar StringtoCalendar() {
		Calendar cal = Calendar.getInstance();
		Date dat = null;
		try{
			dat=sdf.parse(this.date);
			cal.setTime(dat);
		} catch(Exception e){
			return cal;
		}
		
		return cal;
	}
	
	/**
	 * Returns a integer with the years between this date and input other date
	 * @param date get an object from date_class
	 * @return An integer with the amount of years between date and today
	 */
	public int restdates(Date_class date){
		LocalDate today = LocalDate.of(date.year,date.month,date.day);
		LocalDate date2 = LocalDate.of(this.year, this.month, this.day);

		Period p = Period.between(date2, today);
		return p.getYears();
	}
	
	/**
	 * Returns a String with the years, months, and days old of a date
	 * @return String with the years, months, and days old of a date
	 */
	public String Stringbirth(){
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(this.year, this.month, this.day);

		Period p = Period.between(birthday, today);
		long p2 = ChronoUnit.DAYS.between(birthday, today);
		return "You are "+ p.getYears()+" years, " + p.getMonths() +" months, and " + p.getDays() +" days old. (" + p2 + " days total)";
	}
	
	/**Returns a integer with the years from today*/
	public int intyearstoday(){
		LocalDate today = LocalDate.now();
		LocalDate date = LocalDate.of(this.year, this.month, this.day);
		Period p = Period.between(date, today);
		return p.getYears();
	}
	
	public String actualdate() {
        Calendar date = Calendar.getInstance();
        return sdf.format(date.getTime());    
    }
	
	/**
	 * Used to compare if a date is before, equal or after today
	 * @return 0 if date is before, 1 if date is equal, 2 is date is after
	 */
	public int comp_today(){
		int out=0;
		LocalDate today = LocalDate.now();
		LocalDate date = LocalDate.of(this.year, this.month, this.day);
		long p2 = ChronoUnit.DAYS.between(date, today);
		
		if(p2>=1){
			out=0;
		}else if(p2==0){
			out=1;
		}else if(p2<0){
			out=2;
		}
//		          System.out.println("out: "+out+" p2: "+p2);
		return out;
	}
	
	/**
	 * Used to compare if a date is before, equal or after other date
	 * @param date A date to compare with the current date
	 * @return 1 if date is before, -1 if date is equal, 0 is date is after
	 */
	public int compare_dates(Date_class date){
		int out=0;
		LocalDate date1 = LocalDate.of(date.year,date.month,date.day);
		LocalDate date2 = LocalDate.of(this.year, this.month, this.day);
		long p2 = ChronoUnit.DAYS.between(date2, date1);
//		System.out.println("compare dates: date1= "+date1+" date2= "+date2+" period: "+p2);
		if(p2<=1){
			out=0; //Returns 1 if date1 is after date2
		}
		if(p2==0){
			out=1; //Returns 1 if date1 is equals date2
		}
		if(p2>0){
			out=-1; //Returns -1 if date1 is before date2
		}
		
		return out;
	}
	
//	/**
//	 * Used to compare if a date is before, equal or after other date
//	 * @param date A date to compare with the current date
//	 * @return 1 if date is before, -1 if date is equal, 0 is date is after
//	 */
//	public int compare_dates(Date_class date){
//		int out=0;
//		LocalDate date1 = LocalDate.of(date.year,date.month,date.day);
//		LocalDate date2 = LocalDate.of(this.year, this.month, this.day);
//		long p2 = ChronoUnit.DAYS.between(date2, date1);
//		
//		if(p2>1){
//			out=1; //Returns 1 if date2 is before date1
//		}else if(p2==0){
//			out=-1; //Returns -1 if date2 is equal date1
//		}else{
//			out=0; //Returns 0 if date2 is after date1
//		}
//		
//		return out;
//	}
	
	
	
	/**
	 * Method used to compare a this date with another parameter date such as contract date
	 * @param date Object from DAte_class to compare with this date
	 * @param years Amount of years to add to parameter date
	 * @return 0 if date is before, 1 if date is equal, 2 is date is after
	 */
	public int compare_birth_contract(Date_class date,int years){
		int out=0;
		LocalDate contract = LocalDate.of(this.year, this.month, this.day);
		LocalDate birthdate = LocalDate.of(date.year,date.month,date.day);
		
		long period = ChronoUnit.DAYS.between(birthdate.plusYears(years),contract);
//                                System.out.println("period: "+period);
		if(period>=1){
			out=2; //Return 0 if contract is after birth date +18
		}else if(period==0){
			out=1; //Return 1 if contract is equals birth date +18
		}else{
			out=0; //Return 2 if contract is before birth date +18
		}
//		System.out.println("contract: "+contract+" birth date: "+birthdate+" period: "+period+"(days) out: "+out);
		return out;
		
	}
	
	/**
	 * 
	 * @param date
	 * @return Return an integer 0 if is before date, 
	 * 1 if is equals to date, and 2 if is after
	 */
	public int Compare_today(String date) {
		int out=0;
		Calendar dat = Calendar.getInstance();
        Calendar cal= this.StringtoCalendar();
		sdf.format(dat.getTime());		
		dat.set(Calendar.SECOND, 0);
        dat.set(Calendar.MILLISECOND, 0);
        dat.set(Calendar.HOUR,0);
        dat.set(Calendar.MINUTE,0);
		if (cal.before(dat)){
			out=0;  //compareTo -1
		}else if(cal.equals(dat)){
			out=1; //compareTo 1
		}else if(cal.after(dat)){
			out=2;
		}
		return out;
	}
	
	public boolean checkday(){
		GregorianCalendar calendar = new GregorianCalendar();
		int daymonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (calendar.isLeapYear(this.year)) {
			daymonth[2] = 29;
		}

		if ((this.day >= 1) && (this.day <= daymonth[this.month])) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkmonth(){
		if((this.month >=1) && (this.month <=12)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkyear(){
		if ((this.year >= 1900) && (this.year <= 2100)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Boolean to check if a date is correct or not
	 * @return true if date is correct and false if is incorrect
	 */
	public boolean checkdate2() {
	    boolean validdate=true;
	    	
			try {
				LocalDate.of(this.year, this.month, this.day);
			} catch (DateTimeException e) {
				validdate = false;
			}
			if((this.year<1900)||(this.year>2100)){
				validdate =false;
	    	}

		return validdate;
	}
	
	public boolean checkdate3(){
		Calendar cal = Calendar.getInstance();
		Date dat = null;
		boolean validdate=true;
		try {
			dat=sdf.parse(this.date);
		    cal.setTime(dat);
		}
		catch (Exception e) {
		  validdate=false;
		}
		return validdate;
	}
	
	public boolean checkdate() {
        boolean ok = true;
        GregorianCalendar date = new GregorianCalendar();
        int daymonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((this.month < 1) || (this.month > 12)) {
            ok = false;
        }

        if (ok) {
            date.set(this.year, this.month, this.day);

            if (date.isLeapYear(this.year)) {
                daymonth[2] = 29;
            }
            if ((this.day < 1) || (this.day > daymonth[this.month])) {
                ok = false;
            }
        }
        return ok;
    }

}
