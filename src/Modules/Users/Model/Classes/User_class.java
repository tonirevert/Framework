package Modules.Users.Model.Classes;

import Classes.Date_class;
import Classes.Singleton_app;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import Utils.Currency;



/**Class to get all the required data from a user (mother class) 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */

/**
 * Class user with the basic data for a user
 * @author antonio
 */
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
	
                /**
                 * Complete User_class constructor initialisation
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
                 */
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
	
	/**
                 * Primary key constructor initialisation
                 * @param dni a String with the DNI to set
                 */
	public User_class(String dni){
		this.dni=dni;
	}
	/*End of primary key constructor*/
	
	/**Default constructor initialisation*/
	public User_class(){
		
	}
	/*End of default constructor*/
	
                /**
                 * Personalised constructor initialisation
                 * @param i an integer with the desired value
                 * @param param an Object parameter
                 */
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
	 
               /**
                * User DNI getter
                * @return a String with the DNI number+letter
                */
	public String getDni() {
		return dni;
	}
	
                /**
                 * User DNI setter
                 * @param dni The DNI number to set using a String
                 */
	public void setDni(String dni) {
		this.dni = dni;
	}
        
	/**
                 * User Name getter
                 * @return a String with the name of the user
                 */
	public String getName() {
		return name;
	}
	
                /**
                 * User Name setter
                 * @param name The name to set using a String
                 */
	public void setName(String name) {
		this.name = name;
	}
                
	/**
                 * User Surname getter
                 * @return a String with the surname of the user
                 */
	public String getSurname() {
		return surname;
	}
                
                /**
                 * User Surname setter
                 * @param surname The surname to set using a String
                 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
        
                /**
                 * User Birthday getter
                 * @return A date using Date class
                 */
	public Date_class getBirthday() {
		return birthday;
	}
        
                /**
                 * User Birthday setter and calculates the age of the user
                 * @param birthday birthday date to set using Date class
                 */
	public void setBirthday(Date_class birthday) {
		this.birthday = birthday;
		this.setAge(birthday.intyearstoday());
	}
        
	/**
                 * User Mobile getter
                 * @return a String with the user mobile number
                 */
	public String getMobile() {
		return mobile;
	}
        
                /**
                 * User Mobile setter
                 * @param mobile A String with the desired mobile number to set to the user
                 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
        
                /**
                 * User Email getter
                 * @return a String with the user email
                 */
	public String getEmail() {
		return email;
	}
        
                /**
                 * User Email setter
                 * @param email A String with the desired email to set
                 */
	public void setEmail(String email) {
		this.email = email;
	}
        
                /**
                 * User User getter
                 * @return a String with the username
                 */
	public String getUser() {
		return user;
	}
        
                /**
                 * User User setter
                 * @param user A String with the desired username to set
                 */
	public void setUser(String user) {
		this.user = user;
	}
        
                /**
                 * User Password getter
                 * @return a String with the user password
                 */
	public String getPass() {
		return pass;
	}
        
                /**
                 * User Password setter
                 * @param pass a String with the password to set
                 */
	public void setPass(String pass) {
		this.pass = pass;
	}
        
                /**
                 * User Avatar getter
                 * @return a String with the route of the avatar
                 */
	public String getAvatar() {
		return avatar;
	}
        
                /**
                 * User Avatar setter
                 * @param avatar A String with the path of the avatar
                 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
        
                /**
                 * User State getter
                 * @return a boolean with the state of the desired user
                 */
	public boolean isState() {
		return state;
	}
                /**
                 * User State setter
                 * @param state A boolean with the state to set
                 */
	public void setState(boolean state) {
		this.state = state;
	}
        
                /**
                 * User Age getter
                 * @return a integer with the age of the user
                 */
	public int getAge() {
		return age;
	}
        
                /**
                 * User Age setter
                 * @param age An integer with the age to set
                 */
	public void setAge(int age) {
		this.age = age;
	}
        
                /**
                 * User Calculated benefit getter
                 * @return a double number with the benefit
                 */
	public double getBenefit()	{
		return benefit;
	}

                 
                /**
                 * User Calculate benefit setter
                 * @param benefit a double number with the benefit to set
                 */
	public void setBenefit(double benefit){
		this.benefit = benefit;
	}
	 /*End of getters and setters*/
	
                /**
                 * Used to order the users by their ID Card
                 * @param u a User class to compare with this
                 * @return an integer 1 if u is greather than this 0 if is less than
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
                 * @param u a User class to compare with this
                 * @return a boolean result true if it is equal false if not
                 */
	 public boolean equals(User_class u){
		 return this.getDni().equals(u.getDni());
	 }	
	
                /**
                 * Stores all the User_class attributes in one String
                 * @return a String with all the user data fro the User class
                 */
	 public String toString(){
	 	StringBuffer out= new StringBuffer();
	 	
	 	out.append(Singleton_app.lang.getProperty("u_idcard")+" "+this.getDni()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_name")+" "+this.getName()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_surname")+" "+this.getSurname()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_birthday")+" "+this.getBirthday().toString(1)+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_mobile")+" "+this.getMobile()+"\n");
	 	out.append("E-mail: "+this.getEmail()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_user")+" "+this.getUser()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_password")+" "+this.getPass()+"\n");
	 	out.append("Avatar: "+this.getAvatar()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_state")+" "+this.isState()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_age")+" "+this.getAge()+"\n");
	 	out.append(Singleton_app.lang.getProperty("u_benefit")+" "+Currency.autocurrency(this.getBenefit())+"\n");

	 	return out.toString();
	 	
	 }
	 /*End of the chain to store*/
	 
                /**
                 * Initialisation primary key toString
                 * @param dni a String with a DNI number+letter
                 * @return a String with this dni 
                 */
	 public String toString(String dni){
			
			return this.getDni()+"\n";
			
		}
	/*End of primary key toString*/
	 
	 /**
                  * User_class Personalised toString
                  * @param i an integer with the desired output
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
                  * @return a String with the desired output information
                  */
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
