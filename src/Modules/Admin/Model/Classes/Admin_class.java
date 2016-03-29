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
	
	
	/**Complete Admin_class constructor initialisation*/
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
	/**Primary key Admin_class constructor*/
	public Admin_class (String dni){
			super(dni);
		}
	/**Personalised constructor*/	
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
		
	
	/**Contract date admin_class getter*/
	public Date_class getCont_date() {
		return cont_date;
	}
	/**Contract date admin_class setter*/
	public void setCont_date(Date_class cont_date) {
		this.cont_date = cont_date;
		this.setAntiquity(cont_date.intyearstoday());
	}
	/**Antiquity date admin_class getter*/
	public int getAntiquity() {
		return antiquity;
	}
	/**Antiquity date admin_class setter*/
	public void setAntiquity(int antiquy) {
		this.antiquity = antiquy;
		this.setSalary(calc_salary());
		super.setBenefit(calc_benefit());
	}
	/**Salary admin_class getter*/
	public double getSalary() {
		return salary;
	}
	/**Salary admin_class setter*/
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**Activity admin_class getter*/
	public int getActivity() {
		return activity;
	}
	/**Activity admin_class setter*/
	public void setActivity(int activity) {
		this.activity = activity;
		this.setSalary(calc_salary());
		super.setBenefit(calc_benefit());
		
	}
	/*End of getters and setters*/
	
	/** Stores all the Admin_class attributes in one String*/
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("a_contdate")+this.getCont_date().toString(1)+"\n");
		out.append(Singleton_app.lang.getProperty("a_antiquity")+this.getAntiquity()+"\n");
		out.append(Singleton_app.lang.getProperty("a_salary")+Currency.autocurrency(this.getSalary())+"\n");
		out.append(Singleton_app.lang.getProperty("a_activity")+this.getActivity()+"\n");
		
		return out.toString();
	}
	
	//**Initialisation Admin_class primary key toString */
	public String toString(String dni){
		
		return super.toString(dni)+"\n";
	}
	
	/**Initialisation Admin_class personalised toString */
	 public String toString(int i){
		 StringBuffer out=new StringBuffer();
		 
		 if(i<12){
			 out.append(super.toString(i)+"\n");
		 }
		 else{
		 
			 switch(i){
			 
			 case 13:
				 out.append(Singleton_app.lang.getProperty("a_contdate")+this.getCont_date().toString(1)+"\n");
				 break;
			 case 14:
				 out.append(Singleton_app.lang.getProperty("a_antiquity")+this.getAntiquity()+"\n");
				 break;
			 case 15:
//				out.append(Singleton_app.lang.getProperty("a_salary:")+Currency.autocurrency(this.getSalary())+"\n");
                                                                out.append(Currency.autocurrency(this.getSalary()));
				 break;
			 case 16:
				 out.append(Singleton_app.lang.getProperty("a_activity")+this.getActivity()+"\n");
				 break;
			 		 
			 }
		 }
		 return out.toString();
		/*End of the switch case*/
	 }
	/*End personalised toString */
	
	 /**
	 *Used to calculate the benefit for Admin using their Activity and Antiquity
	 *@return A float benefit for Admin user
	 */
	public double calc_benefit() {
	
		return (0.5d * getActivity() + 10 * (double)getAntiquity());
		 
	}
	/**
	 * Used to calculate the benefit for Admin using their benefit
	 * @return A float salary for Admin user
	 */
	public double calc_salary(){
		
		return (this.calc_benefit()+1000d);
	}
	
}
