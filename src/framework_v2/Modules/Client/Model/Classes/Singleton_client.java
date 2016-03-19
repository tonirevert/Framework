package framework_v2.Modules.Client.Model.Classes;

import java.util.ArrayList;
import javax.swing.ImageIcon;




public class Singleton_client {
	public static ArrayList <Client_class> cli;
	public static String DNI=" ";
	public static ImageIcon ok = new ImageIcon("src/framework_v2/Modules/Users/View/img/ok.png");
                public static ImageIcon no_ok = new ImageIcon("src/framework_v2/Modules/Users/View/img/not_ok.png");
                public static ImageIcon exclamation = new ImageIcon("src/framework_v2/Modules/Users/View/img/excl.png");
                public static ImageIcon defaultavatar = new ImageIcon("src/framework_v2/Modules/Users/View/img/avatar/default.png");
                public static boolean adminavatar=false;
                public static String routeAvataradmin="";
                public static int saved=1;
	
}
