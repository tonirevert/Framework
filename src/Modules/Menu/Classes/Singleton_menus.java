/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Classes;

import Modules.Client.Model.Classes.Client_class;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import javax.swing.ImageIcon;

/**
 *
 * @author antonio
 */
public class Singleton_menus {
                public static ImageIcon mainback = new ImageIcon("src/Modules/Menu/View/img/back.jpg");
                public static ImageIcon configback = new ImageIcon("src/Modules/Menu/View/img/blue.jpg");
                public static ImageIcon loginback = new ImageIcon("src/Modules/Menu/View/img/login.gif");
                public static ImageIcon configicon = new ImageIcon("src/Modules/Menu/View/img/conf.png");
                public static ImageIcon configicon_over = new ImageIcon("src/Modules/Menu/View/img/conf_over.gif");
                public static ImageIcon adminicon = new ImageIcon("src/Modules/Menu/View/img/admin.png");
                public static ImageIcon adminicon_over = new ImageIcon("src/Modules/Menu/View/img/admin_over.png");
                public static ImageIcon clienticon = new ImageIcon("src/Modules/Menu/View/img/client.png");
                public static ImageIcon clienticon_over = new ImageIcon("src/Modules/Menu/View/img/client_over.png");
                public static ImageIcon rusericon = new ImageIcon("src/Modules/Menu/View/img/reg_user.png");
                public static ImageIcon rusericon_over = new ImageIcon("src/Modules/Menu/View/img/reg_user_over.png");
                public static ImageIcon ok = new ImageIcon("src/Modules/Menu/View/img/ok.png");
                public static ImageIcon no_ok = new ImageIcon("src/Modules/Menu/View/img/not_ok.png");
                public static ImageIcon seteng = new ImageIcon("src/Modules/Menu/View/img/ukflag25px.png");
                public static ImageIcon unseteng = new ImageIcon("src/Modules/Menu/View/img/ukflag25px_2.png");
                public static ImageIcon setspa = new ImageIcon("src/Modules/Menu/View/img/SpainFlag25px.png");
                public static ImageIcon unsetspa = new ImageIcon("src/Modules/Menu/View/img/SpainFlag25px_2.png");
                public static ImageIcon setval = new ImageIcon("src/Modules/Menu/View/img/Valflag25px.png");
                public static ImageIcon unsetval = new ImageIcon("src/Modules/Menu/View/img/Valflag25px_2.png");
                public static Client_class cli;
                public static Reg_user_class rus;
                public static int pos_rus=0;
                public static String window="";
}
