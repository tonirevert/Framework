package Modules.Reg_user.Model.Classes;

import Classes.Date_class;
import Classes.Singleton_app;
import Modules.Users.Model.Classes.User_class;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;




/**Class to get all the required data from a Admin user (children class) 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */
@SuppressWarnings("serial")
@XStreamAlias("Reg_user_class")
public class Reg_user_class extends User_class implements Serializable{
	
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("karma")
	private String karma;
	
                /**
                 * Complete Reg_user_class constructor
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
                 * @param activity an integer with the amount of the activity
                 * @param karma a String with the karma of the user
                 */
	public Reg_user_class(String dni, String name, String surname, Date_class birthday, String mobile, String email,
			String user, String pass, String avatar, boolean state, int activity, String karma) {
	
		super(dni, name, surname, birthday, mobile, email, user, pass, avatar, state);
		
		this.activity = activity;
		this.karma = calc_karma();
		super.setBenefit(calc_benefit());
	}

                /**
                 * Primary key Client_class Constructor
                 * @param dni a DNI number+letter to create a user
                 */
	public Reg_user_class(String dni){
		super(dni);
	}
	
                /**
                 * Personalized constructor Reg_user_class initialization
                 * @param i an integer to choose the desired parameter
                 * @param ruser the object to use for create a client
                 */
	 public Reg_user_class(int i, Object ruser){
		 
		 super(i,ruser);
		 
		 switch(i){
		 
		 case 22:
			 this.activity=(int)ruser;
			 break;
		 		 		 
		 }
	 }
	 /*End personalized constructor initialization*/

                /**
                 * Activity Registered User getter
                 * @return an integer with the amount of the activity
                 */
	public int getActivity() {
		return activity;
	}
	
                /**
                 * Activity Registered User setter
                 * @param activity the amount of activity to set
                 */
	public void setActivity(int activity) {
		this.activity = activity;
		this.setKarma(calc_karma());
	}
	
                /**
                 * Karma Registered User getter
                 * @return a String with the karma
                 */
	public String getKarma() {
		return karma;
	}
	
                /**
                 * Karma Registered User setter
                 * @param karma a String with the akrma to set
                 */
	public void setKarma(String karma) {
		this.karma = karma;
		
	}
	/*End getters and setters declaration*/
        
	/**
                 * Stores all the Reg_user_class attributes in one String
                 * @return a String with all the data from the registered user
                 */
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("r_activity")+" "+this.getActivity()+"\n");
		out.append(Singleton_app.lang.getProperty("r_karma")+" "+this.getKarma()+"\n");
				
		return out.toString();
	}

                /**
                 * Initialization Client_class primary key toString
                 * @param dni a String with a DNI number+letter
                 * @return a String of the primary key
                 */
	public String toString(String dni){
			
		return super.toString(dni)+"\n";
				
		}
	/*End of Client_class primary key toString*/
	
                /**
                 * Client_class personalized toString
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
			 case 12:
				 out.append(Singleton_app.lang.getProperty("r_activity")+" "+this.getActivity()+"\n");
				 break;
			 case 13:
				 out.append(Singleton_app.lang.getProperty("r_karma")+" "+this.getKarma()+"\n");	 
				 break;

			 }
		 }
		 return out.toString();
	 }
	 
                /**
                 * Calculates the karma of the user from their activity
                 * @return a String with the calculated karma
                 */
	 public String calc_karma(){
		 StringBuffer out=new StringBuffer();
		 
		 if((getActivity())>=5000){
                                                out.append("High");
//			 out.append(Singleton_app.lang.getProperty("r_high"));
		 }else if((getActivity())>=3000){
                                                out.append("Medium");
//			 out.append(Singleton_app.lang.getProperty("r_medium"));
		 }else
                                                out.append("Low");
//			 out.append(Singleton_app.lang.getProperty("r_low"));
		 return out.toString();
	 }
         
                /**
                 * Calculates the benefit of a user from their karma
                 * @return a double number with the benefit
                 */
	public double calc_benefit() {
		double benefit=0.0d;	
		
		if ((double)getActivity()==0.0){
			benefit=0.0d;
		}else{
			if(getKarma().equals("High")){
				benefit=5.0d *(double)getActivity();
			}else if (getKarma().equals("Medium")){
				 benefit=3.0d *(double)getActivity();	
			}else if(getKarma().equals("Low")){
				benefit=1.0d *(double)getActivity();	
			}	
		}
			return benefit;
	 }//End of calc_benefit 
	 
}
