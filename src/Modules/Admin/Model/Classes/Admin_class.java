package Modules.Admin.Model.Classes;

import Classes.Date_class;
import Classes.Singleton_app;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import Modules.Users.Model.Classes.User_class;
import Utils.Currency;



/**Class to get all the required data from a Admin user (children class) 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */
@SuppressWarnings("serial")
@XStreamAlias("Admin_class")
public class Admin_class extends User_class implements Serializable{

	/**Private attributes initialisation*/
	@XStreamAlias("cont_date")
	private Date_class cont_date;
	@XStreamAlias("antiquity")
	private int antiquity;
	@XStreamAlias("salary")
	private double salary;
	@XStreamAlias("activity")
	private int activity;
	
                /**
                 * Complete Admin_class constructor initialisation
                 * @param dni a string with the user dni
                 * @param name a string with the user name
                 * @param surname a string with the user surname
                 * @param birthday a string with the user birthday using Date class
                 * @param mobile a string with the user mobile number
                 * @param email a string with the user email address
                 * @param user a string with the username
                 * @param pass a string with the user password
                 * @param avatar a string with the avatar location and name
                 * @param state a boolean with the state of the user
                 * @param cont_date a string with the user contract date using Date class
                 * @param activity a integer with the amount of the activity of the user
                 */
	public Admin_class (String dni,String name,String surname,Date_class birthday,
			String mobile,String email,String user,String pass, String avatar,boolean state,
			Date_class cont_date, int activity){
		
		super(dni,name,surname,birthday,mobile,email,user,pass,avatar,state);
		
		this.cont_date=cont_date;
		this.activity=activity;
		this.setSalary(calc_salary());
		this.setAntiquity(cont_date.intyearstoday());
		super.setBenefit(calc_benefit());
		
	}
        
                /**Empty Admin_class constructor*/
                public Admin_class(){
                }
        
	/**Primary key Admin_class constructor*/
                /**
                 * Constructor with primary key
                 * @param dni a DNI number to create a user
                 */
	public Admin_class (String dni){
			super(dni);
	}
	
                /**
                 * Personalised constructor
                 * @param i an integer to choose the desired parameter
                 * @param admin the object to use for create an admin
                 */
	public Admin_class(int i, Object admin){
					
			super(i,admin);
		
		
			switch(i){
			
			case 10:
				this.cont_date=(Date_class)admin;
				break;
			case 11:
				this.antiquity=(int)admin;
				break;
			case 12:
				this.salary=(float)admin;
				break;
			case 13:
				this.activity=(int)admin;
				break;
			}
		
			
	} /*End personalised class*/
		
                /**
                 * Contract date admin_class getter
                 * @return a contract date (Date class) object from admin
                 */
	public Date_class getCont_date() {
		return cont_date;
	}
	
                /**
                 * Contract date admin_class setter
                 * @param cont_date a Date class object to set the contract date
                 */
	public void setCont_date(Date_class cont_date) {
		this.cont_date = cont_date;
		this.setAntiquity(cont_date.intyearstoday());
	}
	
                /**
                 * Antiquity date admin_class getter
                 * @return an integer with the amount of years
                 */
	public int getAntiquity() {
		return antiquity;
	}
	
                /**
                 * Antiquity date admin_class setter
                 * @param antiquy an integer with the aniquity to set
                 */
	public void setAntiquity(int antiquy) {
		this.antiquity = antiquy;
		this.setSalary(calc_salary());
		super.setBenefit(calc_benefit());
	}
	
                /**
                 * Salary admin_class getter
                 * @return a number in double type with the salary
                 */
	public double getSalary() {
		return salary;
	}
	
                /**
                 * Salary admin_class setter
                 * @param salary the salary to set in double format
                 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
                /**
                 * Activity admin_class getter
                 * @return an integer with the activity of the user
                 */
	public int getActivity() {
		return activity;
	}
	
                /**
                 * Activity admin_class setter
                 * @param activity an integer with the activity of the user
                 */
	public void setActivity(int activity) {
		this.activity = activity;
		this.setSalary(calc_salary());
		super.setBenefit(calc_benefit());
		
	}
	/*End of getters and setters*/
	
                /**
                 * Stores all the Admin_class attributes in one String
                 * @return a String with all the data from the admin user
                 */
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("a_contdate")+" "+this.getCont_date().toString(1)+"\n");
		out.append(Singleton_app.lang.getProperty("a_antiquity")+" "+this.getAntiquity()+"\n");
		out.append(Singleton_app.lang.getProperty("a_salary")+" "+Currency.autocurrency(this.getSalary())+"\n");
		out.append(Singleton_app.lang.getProperty("a_activity")+" "+this.getActivity()+"\n");
		
		return out.toString();
	}
	
                /**
                 * Initialisation Admin_class primary key toString
                 * @param dni a String with a DNI number+letter
                 * @return a String of the primary key
                 */
	public String toString(String dni){
		
		return super.toString(dni)+"\n";
	}
	
	/**
                  * Admin_class personalised toString
                  * @param i an integer with the desired output option
                  * @return a String with the user data
                  */
	 public String toString(int i){
		 StringBuffer out=new StringBuffer();
		 
		 if(i<12){
			 out.append(super.toString(i)+"\n");
		 }
		 else{
		 
			 switch(i){
			 
			 case 13:
				 out.append(Singleton_app.lang.getProperty("a_contdate")+" "+this.getCont_date().toString(1)+"\n");
				 break;
			 case 14:
				 out.append(Singleton_app.lang.getProperty("a_antiquity")+" "+this.getAntiquity()+"\n");
				 break;
			 case 15:
//				out.append(Singleton_app.lang.getProperty("a_salary:")+" "+Currency.autocurrency(this.getSalary())+"\n");
                                                                out.append(Currency.autocurrency(this.getSalary()));
				 break;
			 case 16:
				 out.append(Singleton_app.lang.getProperty("a_activity")+" "+this.getActivity()+"\n");
				 break;
			 		 
			 }
		 }
		 return out.toString();
		/*End of the switch case*/
	 }
	/*End personalised toString */
	
	 /**
	 *Used to calculate the benefit for Admin using their Activity and Antiquity
	 *@return A double benefit for Admin user
	 */
	public double calc_benefit() {
	
		return (0.5d * getActivity() + 10 * (double)getAntiquity());
		 
	}
	/**
	 * Used to calculate the benefit for Admin using their benefit
	 * @return A double salary for Admin user
	 */
	public double calc_salary(){
		
		return (this.calc_benefit()+1000d);
	}
	
}
