/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.BLL;

import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Client.Model.DAO.DAO_Mongo;
import Modules.Client.Model.DAO.DAO_client;

/**
 *
 * @author antonio
 */
public class BLL_Mongo {
    
    
    public static void insert_Client(Client_class client){
        DAO_Mongo.insert_Client(client);
    }
    
    public static void insert_Client(){
        DAO_Mongo.insert_Client(Singleton_client.cl);
    }
    
    public static void load_Clients(){
        DAO_Mongo.load_Clients();
    }
    
    public static Client_class load_Client_dni(String dni){
        Client_class c=null;
        
        c=DAO_Mongo.load_client_dni(dni);
        
                return c;
    }
    
    public static void update_Client(Client_class client){
        DAO_Mongo.update_client(client);
    }
    
    public static void update_Client(){
        DAO_Mongo.update_client();
    }
    
    public static void remove_Client(Client_class client){
        DAO_Mongo.remove_client(client);
    }
    
    public static void remove_Client(){
        DAO_Mongo.remove_client();
    }
    
    public static void remove_Client_dni(String dni){
        DAO_Mongo.remove_client_dni(dni);
    }
}
