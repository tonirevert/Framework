package framework_v2;

import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Menu.View.Mainmenu;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio
 */
public class Main {
    
    public static void main(String args[]) {
//        BLL_admin.autoloadAdmin();
        Config_class.getinstance();
        new Mainmenu().setVisible(true);
    }
}
