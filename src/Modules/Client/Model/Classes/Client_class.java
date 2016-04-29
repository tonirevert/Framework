package Modules.Client.Model.Classes;

import Classes.Date_class;
import Classes.Singleton_app;
import Modules.Users.Model.Classes.User_class;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import Utils.Currency;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;



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

                public Client_class() {

                }
	
                /**
                 * Used to load a Client from a MySQL data base
                 * @param dBObjectClient a dB object to get from data base
                 * @return a Client class user with all the parameters set
                 */
                public Client_class Client_from_DB(DBObject dBObjectClient) {
                            this.setDni((String)dBObjectClient.get("dni"));
                            this.setName((String)  dBObjectClient.get("name"));
                            this.setSurname((String)  dBObjectClient.get("surname"));
                            this.setBirthday(new Date_class((String) dBObjectClient.get("birthday")));
                            this.setMobile((String) dBObjectClient.get("mobile"));
                            this.setEmail((String) dBObjectClient.get("email"));
                            this.setUser((String) dBObjectClient.get("user"));
                            this.setPass((String) dBObjectClient.get("password"));
                            this.setAvatar((String) dBObjectClient.get("avatar"));
                            this.setState((boolean) dBObjectClient.get("state"));
                            this.setAge((int)dBObjectClient.get("age"));
                            this.reg_date= new Date_class((String) dBObjectClient.get("reg_date"));
                            this.antique=(int)dBObjectClient.get("antiquity");
                            this.shopping=(double) dBObjectClient.get("shopping");
                            this.premium=(boolean) dBObjectClient.get("premium");
                            this.client_type=(String) dBObjectClient.get("client_type");
        
        
                            return new Client_class(this.getDni(),this.getName(), this.getSurname(),this.getBirthday(),this.getMobile(),this.getEmail(),
                                    this.getUser(),this.getPass(),this.getAvatar(),this.isState(),this.reg_date,this.shopping,this.premium,this.client_type);
                }

                /**
                 * Used to save a Client user to a My SQL data base
                 * @return a DB Object with the data from a Client user
                 */
                public BasicDBObject Client_to_DB() {
	BasicDBObject dBObjectClient = new BasicDBObject();
                dBObjectClient.append("dni", this.getDni());
                dBObjectClient.append("name", this.getName());
	dBObjectClient.append("surname", this.getSurname());
                dBObjectClient.append("birthday", this.getBirthday().toString());
                dBObjectClient.append("mobile", this.getMobile());
                dBObjectClient.append("email", this.getEmail());
                dBObjectClient.append("user", this.getUser());
                dBObjectClient.append("password", this.getPass());
                dBObjectClient.append("avatar", this.getAvatar());
                dBObjectClient.append("state", this.isState());
                dBObjectClient.append("age", this.getAge());
                dBObjectClient.append("reg_date", this.getReg_date().toString());
                dBObjectClient.append("antiquity", this.getAntique());
                dBObjectClient.append("shopping", this.getShopping());
                dBObjectClient.append("premium", this.isPremium());
                dBObjectClient.append("client_type", this.getClient_type());
	return dBObjectClient;
    }
        
                /**
                 * Primary key Client_class Constructor
                 * @param dni a String with a DNI number+letter primary key
                 */
	public Client_class(String dni){
		super(dni);
	}
	
                /**
                 * Personalized constructor initialization
                 * @param i an integer to choose the desired parameter
                 * @param client the object to use for create an client
                 */
	 public Client_class(int i, Object client){
		 		 
		 switch(i){
		 
		 case 16:
			 this.reg_date=(Date_class)client;
			 break;
		 case 17:
			 this.antique=(int)client;
			 break;
		 case 18:
			 this.shopping=(double)client;
			 break;
		 case 19:
			 this.premium=(boolean)client;
			 break;
		 case 20:
			 this.client_type=(String)client;
			 break;
		 
		 }
	 }
	 /*End personalised constructor initialisation*/

                /**
                 * Registration date Client getter
                 * @return a registration date (Date class) object from client
                 */
	public Date_class getReg_date() {
		return reg_date;
	}

                /**
                 * Registration date Client setter
                 * @param reg_date a Date class object to set the registration date
                 */
	public void setReg_date(Date_class reg_date) {
		this.reg_date = reg_date;
		this.setAntique(reg_date.intyearstoday());
	}

                /**
                 * Antique Client getter
                 * @return an integer with the amount of years
                 */
	public int getAntique() {
		return antique;
	}
	
                /**
                 * Antique Client setter
                 * @param antique an integer with the aniquity to set
                 */
	public void setAntique(int antique) {
		this.antique = antique;
		
	}
	
                /**
                 * Shopping Client getter
                 * @return a number in double format with the amount of shopping
                 */
	public double getShopping() {
		return shopping;
	}
	
                /**
                 * Shopping Client setter
                 * @param shopping a number in double format with the shopping to set
                 */
	public void setShopping(double shopping) {
		this.shopping = shopping;
	}

                /**
                 * Premium String Client getter
                 * @return a boolean if is premium or not
                 */
	public boolean isPremium() {
		return premium;
	}

                /**
                 * Premium String Client setter
                 * @param premium a boolean to set if is premium or not
                 */
	public void setPremium(boolean premium) {
		this.premium = premium;
		super.setBenefit(calc_benefit());
	}

                /**
                 * Client type String Client getter
                 * @return a String with the type of Client
                 */
	public String getClient_type() {
		return client_type;
	}

                /**
                 * Client type String Client setter
                 * @param client_type a String with the type of Client
                 */
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	/*End of CLient getters and setters declaration*/
	
                /**
                 * Stores all the Client class attributes in one String
                 * @return a String with all the Client data
                 */
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(super.toString());
		out.append(Singleton_app.lang.getProperty("c_regdate")+" "+this.getReg_date().toString(1)+"\n");
		out.append(Singleton_app.lang.getProperty("c_antique")+" "+this.getAntique()+"\n");
		out.append(Singleton_app.lang.getProperty("c_shopping")+" "+Currency.autocurrency(this.getShopping())+"\n");
		out.append(Singleton_app.lang.getProperty("c_premium")+" "+this.isPremium()+"\n");
		out.append(Singleton_app.lang.getProperty("c_clitype")+" "+this.getClient_type()+"\n");
				
		return out.toString();
	}
	
                /**
                 * Initialisation Client_class primary key toString
                 * @param dni a DNI numbers+letter
                 * @return a String with the primary key of the user
                 */
	public String toString(String dni){
			
		return super.toString(dni)+"\n";
				
		}
	/*End of Client_class primary key toString*/
	
                /**
                 * Client_class personalised toString
                 * @param i an integer with the desired output option
                  * @return a String with the user data
                 */
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
	
                /**
                 * Used to calculate the Client benefit
                 * @return a number in double type with the benefit of the user
                 */
	 public double calc_benefit() {
			
			if (premium==true){
				return (0.05d * getShopping());	
			}else{
				return (0.01d * getShopping());
			}
			
			
	 }
}
