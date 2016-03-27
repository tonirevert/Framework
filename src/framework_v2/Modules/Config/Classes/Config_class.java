package framework_v2.Modules.Config.Classes;
import framework_v2.Modules.Config.Utils.Files_lib.Funct_files_config;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import framework_v2.Modules.Admin.Model.Classes.Admin_class;
import java.io.Serializable;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework_v2.Classes.Singleton_app;
import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Client.Model.BLL.BLL_client;
import framework_v2.Modules.Client.Model.Classes.Client_class;
import framework_v2.Modules.Client.Model.Classes.Singleton_client;
import framework_v2.Modules.Reg_user.Model.BLL.BLL_ruser;
import framework_v2.Modules.Reg_user.Model.Classes.Reg_user_class;
import framework_v2.Modules.Reg_user.Model.Classes.Singleton_ruser;



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
	
                

	public static Config_class getinstance(){
                                
                                
		if (instance == null){
			instance = new Config_class();
                                                instance = Funct_files_config.loadjsonconfig();                        
                                                BLL_admin.autoloadAdmin();
                                                BLL_client.autoloadClient();
                                                BLL_ruser.autoloadRuser();
//			instance = Funct_files_config.loadxmlconfig();
			theme_class.selectedtheme(Config_class.getinstance().getTheme());
//			Singleton_app.lang = new Language(Config_class.getinstance().getLanguage());
		}	
                                
			return instance;
			
	}
		
		
	
	
	public Config_class(){
		
		this.date_format="dd/MM/yyyy";
		this.currency='€';
		this.file_format="json";
		this.language="en";
		this.theme="Metal";
		this.decimals=2;
		this.dummy=false;
		
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
