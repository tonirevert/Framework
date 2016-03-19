package framework_v2.Modules.Reg_user.Model.Classes;

import framework_v2.Modules.Users.Model.Classes.User_class;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework_v2.Classes.*;




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
	
	/**Complete Reg_user_class constructor*/
	public Reg_user_class(String dni, String name, String surname, Date_class birthday, String mobile, String email,
			String user, String pass, String avatar, boolean state, int activity, String karma) {
	
		super(dni, name, surname, birthday, mobile, email, user, pass, avatar, state);
		
		this.activity = activity;
		this.karma = calc_karma();
		super.setBenefit(calc_benefit());
	}

	/**Primary key Client_class Constructor*/
	public Reg_user_class(String dni){
		super(dni);
	}
	
	/**Personalized constructor Reg_user_class initialization */
	 public Reg_user_class(int i, Object param){
		 
		 super(i,param);
		 
		 switch(i){
		 
		 case 22:
			 this.activity=(int)param;
			 break;
		 		 		 
		 }
	 }
	 /*End personalized constructor initialization*/

	 /**Activity Registered User getter*/
	public int getActivity() {
		return activity;
	}
	/**Activity Registered User setter*/
	public void setActivity(int activity) {
		this.activity = activity;
		this.setKarma(calc_karma());
	}
	/**Karma Registered User getter*/
	public String getKarma() {
		return karma;
	}
	/**Karma Registered User setter*/
	public void setKarma(String karma) {
		this.karma = karma;
		
	}
	/*End getters and setters declaration*/
	
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("r_activity")+this.getActivity()+"\n");
		out.append(Singleton_app.lang.getProperty("r_karma")+this.getKarma()+"\n");
				
		return out.toString();
	}

	//**Initialization Client_class primary key toString */
	public String toString(String dni){
			
		return super.toString(dni)+"\n";
				
		}
	/*End of Client_class primary key toString*/
	
	/**Initialization Client_class personalized toString */
	 public String toString(int i){
		 StringBuffer out=new StringBuffer();
		 
		 if(i<12){
			 out.append(super.toString(i)+"\n");
		 }
		 else{		 
		 
			 switch(i){
			 case 12:
				 out.append(Singleton_app.lang.getProperty("r_activity")+this.getActivity()+"\n");
				 break;
			 case 13:
				 out.append(Singleton_app.lang.getProperty("r_karma")+this.getKarma()+"\n");	 
				 break;

			 }
		 }
		 return out.toString();
	 }
	 
	 public String calc_karma(){
		 StringBuffer out=new StringBuffer();
		 
		 if((getActivity())>=5000){
			 out.append(Singleton_app.lang.getProperty("r_high"));
		 }else if((getActivity())>=3000){
			 out.append(Singleton_app.lang.getProperty("r_medium"));
		 }else
			 out.append(Singleton_app.lang.getProperty("r_low"));
		 
		 return out.toString();
	 }
	 
	 public double calc_benefit() {
		double benefit=0.0d;	
		
		if ((double)getActivity()==0.0){
			benefit=0.0d;
		}else{
			if(getKarma().equals(Singleton_app.lang.getProperty("r_high"))){
				benefit=5.0d *(double)getActivity();
			}else if (getKarma().equals(Singleton_app.lang.getProperty("r_medium"))){
				 benefit=3.0d *(double)getActivity();	
			}else if(getKarma().equals(Singleton_app.lang.getProperty("r_low"))){
				benefit=1.0d *(double)getActivity();	
			}	
		}
			return benefit;
	 }//End of calc_benefit
	 
}
