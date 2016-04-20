package Classes;

import Modules.Config.Model.Classes.Language.Language;
import Modules.Config.Model.Classes.Config_class;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.apache.commons.dbcp.BasicDataSource;


/**
 * Singleton for the application configuration, connection to database and language
 * @author antonio
 */
public class Singleton_app {

                public static BasicDataSource dataSource=null;	
                public static Config_class conf=new Config_class();
	public static Language lang;
                public static Mongo_DB mongo = null;
                public static Mongo client = null;
                public static String nom_bd = "";
                public static String nom_table = "";
                public static DB db = null;
                public static DBCollection collection = null;
}
