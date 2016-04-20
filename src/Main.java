

import Classes.Mongo_DB;
import Classes.Singleton_app;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Client.Model.DAO.DAO_client;
import Modules.Config.Model.Classes.Config_class;
import Modules.Menu.Controller.MenuController;
import Modules.Menu.View.Mainmenu;
import java.sql.SQLException;


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
    
    public static void main(String args[]) throws SQLException {

        Config_class.getinstance();
//        for(Client_class c:Singleton_client.cli){
//            DAO_client.insert_Client(Singleton_app.db, Singleton_app.collection, c);
//            System.out.println(c.getDni());
//        }
//        Mongo_DB.disconnect();

        new MenuController(new Mainmenu(), 0).Init(0);
//        DB_Dummy.cargarAdmin();
//        DB_Dummy.loadAdminArray();

    }
}
