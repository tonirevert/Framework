package Classes;

import Modules.Config.Model.Classes.Language.Language;
import Modules.Config.Model.Classes.Config_class;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;


/**
 * Singleton for the application configuration, connection to database and language
 * @author antonio
 */
public class Singleton_app {

                public static BasicDataSource dataSource=null;	
                public static Config_class conf=new Config_class();
	public static Language lang;
                public static Properties prop = new Properties();
                public static InputStream input = null;
                public static String machine = null;
                public static String port = null;
                public static Mongo client = null;
                public static DB db = null;
                public static String nom_bd = null;
                public static DBCollection collection = null;
                public static String nom_table = null;
}
