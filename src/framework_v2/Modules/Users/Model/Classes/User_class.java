package framework_v2.Modules.Users.Model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework_v2.Classes.*;
import framework_v2.Utils.Currency;



/**Class to get all the required data from a user (mother class) 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */

@SuppressWarnings("serial")
@XStreamAlias("User_class")
public abstract class User_class implements Comparable<User_class>, Serializable{

	/**Private attributes initialisation*/
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("surname")
	private String surname;
	@XStreamAlias("birthday")
	private Date_class birthday;
	@XStreamAlias("mobile")
	private String mobile;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("user")
	private String user;
	@XStreamAlias("pass")
	private String pass;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("state")
	private boolean state;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("benefit")
	private double benefit;
	/*Private attributes end*/
	
	/**Complete User_class constructor initialisation*/
	public User_class (String dni,String name,String surname,Date_class birthday,String mobile,String email,
			String user,String pass, String avatar,boolean state){
		this.dni=dni;
		this.name=name;
		this.surname=surname;
		this.birthday=birthday;
		this.mobile=mobile;
		this.email=email;
		this.user=user;
		this.pass=pass;
		this.avatar=avatar;
		this.setAge(birthday.intyearstoday());
		this.state=state;
		
		
		
	}
	/*End of complete User_class constructor*/
	
	/**Primary key constructor initialisation*/
	public User_class(String dni){
		this.dni=dni;
	}
	/*End of primary key constructor*/
	
	/**Default constructor initialisation*/
	public User_class(){
		
	}
	/*End of default constructor*/
	
	/**Personalised constructor initialisation */
	 public User_class(int i, Object param){
		 /*int i, String s, boolean state, int age*/
		 switch(i){
		 
		 case 0:
			 this.dni=(String)param;
			 break;
		 case 1:
			 this.name=(String)param;
			 break;
		 case 2:
			 this.surname=(String)param;
			 break;
		 case 3:
			 this.birthday=(Date_class)param;
			 break;
		 case 4:
			 this.mobile=(String)param;
			 break;
		 case 5:
			 this.email=(String)param;
			 break;
		 case 6:
			 this.user=(String)param;
			 break;
		 case 7:
			 this.pass=(String)param;
			 break;
		 case 8:
			 this.avatar=(String)param;
			 break;
		 case 9:
			 this.state=(boolean)param;
			 break;
		 

		 }
		//*End of the switch case*/
	 }
	/*End personalised constructor initialisation*/
	 
	/**User DNI getter*/
	public String getDni() {
		return dni;
	}
	/**User DNI setter*/
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**User Name getter*/
	public String getName() {
		return name;
	}
	/**User Name setter*/
	public void setName(String name) {
		this.name = name;
	}
	/**User Surname getter*/
	public String getSurname() {
		return surname;
	}
	/**User Surname setter*/
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**User Birthday getter*/
	public Date_class getBirthday() {
		return birthday;
	}
	/**User Birthday setter*/
	public void setBirthday(Date_class birthday) {
		this.birthday = birthday;
		this.setAge(birthday.intyearstoday());
	}
	/**User Mobile getter*/
	public String getMobile() {
		return mobile;
	}
	/**User Mobile setter*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**User Email getter*/
	public String getEmail() {
		return email;
	}
	/**User Email setter*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**User User getter*/
	public String getUser() {
		return user;
	}
	/**User User setter*/
	public void setUser(String user) {
		this.user = user;
	}
	/**User Password getter*/
	public String getPass() {
		return pass;
	}
	/**User Password setter*/
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**User Avatar getter*/
	public String getAvatar() {
		return avatar;
	}
	/**User Avatar setter*/
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**User State getter*/
	public boolean isState() {
		return state;
	}
	/**User State setter*/
	public void setState(boolean state) {
		this.state = state;
	}
	/**User Age getter*/
	public int getAge() {
		return age;
	}
	/**User Age setter*/
	public void setAge(int age) {
		this.age = age;
	}
	/**User Calculate benefit setter*/
	public double getBenefit()	{
		return benefit;
	}
	/**User Calculate benefit getter*/
	public void setBenefit(double benefit){
		this.benefit = benefit;
	}
	 /*End of getters and setters*/
	
	/**
	 *  Used to order the users by their ID Card
	 *  
	 */
	public int compareTo(User_class u){
		 if(this.getDni().compareTo(u.getDni())>0){
			 return 1;
		 }
		 if(this.getDni().compareTo(u.getDni())<0){
			 return -1;
		 }
		 return 0;
	 }
	
	/**
	 * Used to compare two users
	 */
	 public boolean equals(User_class u){
		 return this.getDni().equals(u.getDni());
	 }	
	
	/** Stores all the User_class attributes in one String*/
	 public String toString(){
	 	StringBuffer out= new StringBuffer();
	 	
	 	out.append(Singleton_app.lang.getProperty("u_idcard")+this.getDni()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_name")+this.getName()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_surname")+this.getSurname()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_birthday")+this.getBirthday().toString(1)+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_mobile")+this.getMobile()+"\n");
	 	out.append("E-mail: "+this.getEmail()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_user")+this.getUser()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_password")+this.getPass()+"\n");
	 	out.append("Avatar: "+this.getAvatar()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_state")+this.isState()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_age")+this.getAge()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_benefit")+Currency.autocurrency(this.getBenefit())+"\n");

	 	return out.toString();
	 	
	 }
	 /*End of the chain to store*/
	 
	 /**Initialisation primary key toString */
	 public String toString(String dni){
			
			return this.getDni()+"\n";
			
		}
	/*End of primary key toString*/
	 
	 
	 /**User_class Personalised toString 
	  * 
	  * Values:
	  * 0-Return DNI
	  * 1-Return Name
	  * 2-Return Surname
	  * 3-Return Birthday
	  * 4-Return Mobile
	  * 5-Return E-mail
	  * 6-Return User
	  * 7-Return Password
	  * 8-Return Avatar
	  * 9-Return State
	  * 10-Return Age
	  * */
	 
	 public String toString(int i){
		 StringBuffer out= new StringBuffer();
		 
		 switch(i){
		 
		 case 0:
			 out.append(Singleton_app.lang.getProperty("u_idcard")+this.getDni()+"\n");
			 break;
		 case 1:
			 out.append(Singleton_app.lang.getProperty("u_name")+this.getName()+"\n");
			 break;
		 case 2:
			 out.append(Singleton_app.lang.getProperty("u_surname")+this.getSurname()+"\n");
			 break;
		 case 3:
			 out.append(Singleton_app.lang.getProperty("u_birthday")+this.getBirthday()+"\n");
			 break;
		 case 4:
			 out.append(Singleton_app.lang.getProperty("u_mobile")+this.getMobile()+"\n");
			 break;
		 case 5:
			 out.append("E-mail: "+this.getEmail()+"\n");
			 break;
		 case 6:
			 out.append(Singleton_app.lang.getProperty("u_user")+this.getUser()+"\n");
			 break;
		 case 7:
			 out.append(Singleton_app.lang.getProperty("u_password")+this.getPass()+"\n");
			 break;
		 case 8:
			 out.append("Avatar: "+this.getAvatar()+"\n");
			 break;
		 case 9:
			 out.append(Singleton_app.lang.getProperty("u_state")+this.isState()+"\n");
			 break;
		 case 10:
			 out.append(Singleton_app.lang.getProperty("u_age")+this.getAge()+"\n");
			 break;
		 case 11:
			 out.append(Singleton_app.lang.getProperty("u_benefit")+Currency.autocurrency(this.getBenefit())+"\n");

		 }
		 
		 return out.toString();
		/*End of the switch case*/
	 }
	/*End personalised toString */

	 public abstract double calc_benefit();
	 

}
