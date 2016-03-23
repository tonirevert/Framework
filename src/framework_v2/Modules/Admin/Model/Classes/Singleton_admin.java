package framework_v2.Modules.Admin.Model.Classes;

import java.util.ArrayList;
import javax.swing.ImageIcon;




public class Singleton_admin {
	public static ArrayList <Admin_class> adm;
	public static Admin_class ad;
                public static String DNI=" ";
                public static String window="";
	public static ImageIcon ok = new ImageIcon("src/framework_v2/Modules/Admin/View/img/ok.png");
                public static ImageIcon no_ok = new ImageIcon("src/framework_v2/Modules/Admin/View/img/not_ok.png");
                public static ImageIcon exclamation = new ImageIcon("src/framework_v2/Modules/Admin/View/img/excl.png");
                public static ImageIcon defaultavatar = new ImageIcon("src/framework_v2/Modules/Admin/View/img/avatar/default.png");
                public static ImageIcon background = new ImageIcon ("src/framework_v2/Modules/Admin/View/img/brushedmetal.jpg");
                public static ImageIcon addicon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/add_no_over.png");
                public static ImageIcon addicon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/add_over.png");
                public static ImageIcon editicon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/edit_no_over.png");
                public static ImageIcon editicon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/edit_over.png");
                public static ImageIcon delicon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/minus_no_over.png");
                public static ImageIcon delicon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/minus_over.png");
                public static ImageIcon jsonicon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/json_no_over.png");
                public static ImageIcon jsonicon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/json_over.png");
                public static ImageIcon txticon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/txt_no_over.png");
                public static ImageIcon txticon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/txt_over.png");
                public static ImageIcon xmlicon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/xml_no_over.png");
                public static ImageIcon xmlicon_over = new ImageIcon("src/framework_v2/Modules/Admin/View/img/xml_over.png");
                public static String avatarsroute="src/framework_v2/Modules/Admin/View/img/avatar/";
                public static boolean adminavatar=false;
                public static String routeAvataradmin="";
                
                public static int saved=1;
	
}
