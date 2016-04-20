package Modules.Config.Model.Classes;
import Classes.DBConnection;
import Classes.Mongo_DB;
import Modules.Config.Model.Utils.Files_lib.Funct_files_config;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Admin.Model.Classes.Admin_class;
import java.io.Serializable;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Classes.Singleton_app;
import Modules.Client.Model.BLL.BLL_client;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Config.Model.Classes.Language.Language;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import Modules.Reg_user.Model.Classes.Singleton_ruser;


/**
 * Class to have a app configuration 
 * @author antonio
 */
@SuppressWarnings("serial")
@XStreamAlias("Config_class")
public class Config_class implements Serializable{
	
	@XStreamAlias("date_format")
	private String date_format;
	@XStreamAlias("currency")
	private char currency;
	@XStreamAlias("file_format")
	private String file_format;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("decimals")
	private int decimals;
	@XStreamAlias("dummy")
	private boolean dummy;

private static Config_class instance;
	
                
                /**
                 * Creates a configuration instance if is null and loads the config file and
                 * users client and reg user into the array lists.
                 * @return an instance with the loaded configuration
                 */
	public static Config_class getinstance(){
                                
                                
		if (instance == null){
			instance = new Config_class();
                                                instance = Funct_files_config.loadjsonconfig();
//			instance = Funct_files_config.loadxmlconfig();
//                                                BLL_client.autoloadClient();
                                                BLL_ruser.autoloadRuser();
			theme_class.selectedtheme(Config_class.getinstance().getTheme());
			Singleton_app.lang = new Language(Config_class.getinstance().getLanguage());
                                                
		}	
                                
			return instance;
			
	}
		
		
	
	/**
                * Deafault configuration constructor
                */
	public Config_class(){
		
		this.date_format="dd/MM/yyyy";
		this.currency='€';
		this.file_format="json";
		this.language="en";
		this.theme="Metal";
		this.decimals=2;
		this.dummy=false;
		
                                DBConnection.init_BasicDataSourceFactory();
                                Singleton_app.mongo=new Mongo_DB();
                                Singleton_app.nom_bd=Singleton_app.mongo.getNom_bd();
                                Singleton_app.nom_table=Singleton_app.mongo.getNom_table();
                                Singleton_app.client=Mongo_DB.connect();
                                if(Singleton_app.client!=null){
                                    Singleton_app.db=Singleton_app.mongo.getDb();
                                    Singleton_app.collection=Singleton_app.mongo.getCollection();
                                }
                                                                                                
		Singleton_admin.adm = new ArrayList<Admin_class>();
		Singleton_client.cli = new ArrayList<Client_class>();
		Singleton_ruser.rus = new ArrayList<Reg_user_class>();
		theme_class.selectedtheme("Metal");
		
	}	
	
	public String getDate_format() {
		return date_format;
	}
	public void setDate_format(String date_format) {
		this.date_format = date_format;
	}
	public char getCurrency() {
		return currency;
	}
	public void setCurrency(char currency) {
		this.currency = currency;
	}
	public String getFile_format() {
		return file_format;
	}
	public void setFile_format(String file_format) {
		this.file_format = file_format;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
		Singleton_app.lang.setLanguage(language);
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getDecimals() {
		return decimals;
	}
	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}
	public boolean isDummy() {
		return dummy;
	}
	public void setDummy(boolean dummy) {
		this.dummy = dummy;
	}
	
        
                /**
                 * Used to list the current configuration using toString
                 * @return A String with all the current configuration set
                 */
	public String toString(){
		StringBuffer out=new StringBuffer();
		
		out.append(Singleton_app.lang.getProperty("dateform")+": "+this.getDate_format()+", ");
		out.append(Singleton_app.lang.getProperty("currency")+": "+this.getCurrency()+", ");
		out.append(Singleton_app.lang.getProperty("fileform")+": "+this.getFile_format()+", ");
		out.append(Singleton_app.lang.getProperty("language")+": "+this.getLanguage()+", ");
		out.append(Singleton_app.lang.getProperty("theme")+": "+this.getTheme()+", ");
		out.append(Singleton_app.lang.getProperty("decformat")+": "+this.getDecimals());
		
		return out.toString();
	}	
	
}
