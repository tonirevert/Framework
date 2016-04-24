/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.BLL;

import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Client.Model.DAO.DAO_Mongo_client;

/**
 *
 * @author antonio
 */
public class BLL_Mongo_client {
    
    
    public static void insert_Client(Client_class client){
        DAO_Mongo_client.insert_Client(client);
    }
    
    public static void insert_Client(){
        DAO_Mongo_client.insert_Client(Singleton_client.cl);
    }
    
    public static void load_Clients(){
        DAO_Mongo_client.load_Clients();
    }
    
    public static Client_class load_Client_dni(String dni){
        Client_class client=null;
        
        client=DAO_Mongo_client.load_client_dni(dni);
//        System.out.println(client.toString());
                return client;
    }
    
    public static void update_Client(Client_class client){
        DAO_Mongo_client.update_client(client);
    }
    
    public static void update_Client(){
        DAO_Mongo_client.update_client();
    }
    
    public static void remove_Client(Client_class client){
        DAO_Mongo_client.remove_client(client);
    }
    
    public static void remove_Client(){
        DAO_Mongo_client.remove_client();
    }
    
    public static void remove_Client_dni(String dni){
        DAO_Mongo_client.remove_client_dni(dni);
    }
}
