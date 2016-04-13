package Classes;

import Modules.Config.Model.Classes.Language.Language;
import Modules.Config.Model.Classes.Config_class;
import org.apache.commons.dbcp.BasicDataSource;



public class Singleton_app {

                public static BasicDataSource dataSource=null;	
                public static Config_class conf=new Config_class();
	public static Language lang;
                
}
