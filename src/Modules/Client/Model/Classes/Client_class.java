package Modules.Client.Model.Classes;

import Classes.Date_class;
import Classes.Singleton_app;
import Modules.Users.Model.Classes.User_class;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import Utils.Currency;



/**Class to get all the required data from a Client type user (children class) 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */
@SuppressWarnings("serial")
@XStreamAlias("Client_class")
public class Client_class extends User_class implements Serializable{

	/**Private attributes initialisation*/
	@XStreamAlias("reg_date")
	private Date_class reg_date;
	@XStreamAlias("antique")
	private int antique;
	@XStreamAlias("shopping")
	private double shopping;
	@XStreamAlias("premium")
	private boolean premium;
	@XStreamAlias("client_type")
	private String client_type;
	
	
	public Client_class(String dni, String name, String surname, Date_class birthday, String mobile, String email,
			String user, String pass, String avatar, boolean state, Date_class reg_date, double shopping,
			boolean premium, String client_type) {
		
		super(dni, name, surname, birthday, mobile, email, user, pass, avatar, state);
		
		this.reg_date = reg_date;
		this.setAntique(reg_date.intyearstoday());
		this.shopping = shopping;
		this.premium = premium;
		this.client_type = client_type;
		super.setBenefit(calc_benefit());
	}
	
	/**Primary key Client_class Constructor*/
	public Client_class(String dni){
		super(dni);
	}
	
	/**Personalized constructor initialization */
	 public Client_class(int i, Object param){
		 		 
		 switch(i){
		 
		 case 16:
			 this.reg_date=(Date_class)param;
			 break;
		 case 17:
			 this.antique=(int)param;
			 break;
		 case 18:
			 this.shopping=(double)param;
			 break;
		 case 19:
			 this.premium=(boolean)param;
			 break;
		 case 20:
			 this.client_type=(String)param;
			 break;
		 
		 }
	 }
	 /*End personalised constructor initialisation*/

	/**Registration date Client getter*/
	public Date_class getReg_date() {
		return reg_date;
	}

	/**Registration date Client setter*/
	public void setReg_date(Date_class reg_date) {
		this.reg_date = reg_date;
		this.setAntique(reg_date.intyearstoday());
	}

	/**Antique Client getter*/
	public int getAntique() {
		return antique;
	}
	/**Antique Client setter*/
	public void setAntique(int antique) {
		this.antique = antique;
		
	}
	/**Shopping Client getter*/
	public double getShopping() {
		return shopping;
	}
	/**Shopping Client setter*/
	public void setShopping(double shopping) {
		this.shopping = shopping;
	}

	/**Premium String Client getter*/
	public boolean isPremium() {
		return premium;
	}

	/**Premium String Client setter*/
	public void setPremium(boolean premium) {
		this.premium = premium;
		super.setBenefit(calc_benefit());
	}

	/**Client type String Client getter*/
	public String getClient_type() {
		return client_type;
	}

	/**Client type String Client setter*/
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	/*End of CLient getters and setters declaration*/
	
	/** Stores all the Admin_class attributes in one String*/
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("c_regdate")+this.getReg_date().toString(1)+"\n");
		out.append(Singleton_app.lang.getProperty("c_antique")+this.getAntique()+"\n");
		out.append(Singleton_app.lang.getProperty("c_shopping")+Currency.autocurrency(this.getShopping())+"\n");
		out.append(Singleton_app.lang.getProperty("c_premium")+this.isPremium()+"\n");
		out.append(Singleton_app.lang.getProperty("c_clitype")+this.getClient_type()+"\n");
				
		return out.toString();
	}
	
	//**Initialisation Client_class primary key toString */
	public String toString(String dni){
			
		return super.toString(dni)+"\n";
				
		}
	/*End of Client_class primary key toString*/
	
	/**Initialisation Client_class personalised toString */
	 public String toString(int i){
		 StringBuffer out=new StringBuffer();
		
		 if(i<12){
			 out.append(super.toString(i));
		 }
		 else{
		 
			 switch(i){
			 
			 case 13:
				 out.append(Singleton_app.lang.getProperty("c_regdate")+this.getReg_date().toString(1)+"\n");
				 break;
			 case 14:
				 out.append(Singleton_app.lang.getProperty("c_antique")+this.getAntique()+"\n");
				 break;
			 case 15:
//				 out.append(Singleton_app.lang.getProperty("c_shopping")+Currency.autocurrency(this.getShopping())+"\n");
                                                                out.append(Currency.autocurrency(this.getShopping()));
				 break;
			 case 16:
				 out.append(Singleton_app.lang.getProperty("c_premium")+this.isPremium()+"\n");
				 break;
			 case 17:
				 out.append(Singleton_app.lang.getProperty("c_clitype")+this.getClient_type()+"\n");
				 break;		 		 
			 }/*End of the switch case*/
		}	 
			 return out.toString();
			 
	 }
	/*End personalised toString */
	
	 public double calc_benefit() {
			
			if (premium==true){
				return (0.05d * getShopping());	
			}else{
				return (0.01d * getShopping());
			}
			
			
	 }
}
