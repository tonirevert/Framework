/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.DAO;

import Classes.Singleton_app;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 *
 * @author antonio
 */
public class DAO_Mongo_client {
  
    
    public static void insert_Client(Client_class c){
        DBCollection table=Singleton_app.collection;
        table.insert(c.Client_to_DB());
    }
    
    public static void insert_Client(){
        DBCollection table=Singleton_app.collection;
        Client_class c=Singleton_client.cl;
        table.insert(c.Client_to_DB());
    }
    
    public static void load_Clients(){
        DBCollection table=Singleton_app.collection;
        DBCursor cursor=null;
        Client_class client=new Client_class();
        
        try {
            cursor=table.find();
            if(cursor.count()!=0){
                        while(cursor.hasNext()){
                        BasicDBObject document=(BasicDBObject)cursor.next();
                        Singleton_client.cli.add(client.Client_from_DB(document));
                    }
            }else{
                System.out.println("NO DATA");
            }
            
        } finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        
    }//End of print table
    
    public static Client_class load_client_dni(String dni){
        DBCollection table=Singleton_app.collection;
        DBCursor cursor=null;
        Client_class c=new Client_class();
//        System.out.println("Modules.Client.Model.DAO.DAO_Mongo_client.load_client_dni()");
        try{
            BasicDBObject query = new BasicDBObject();
            query.put("dni",dni);
            
            cursor=table.find(query);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document=(BasicDBObject) cursor.next();
                    c=c.Client_from_DB(document);
                    
                }
            }else{
//                System.out.println("NO DATA");
            }
        }finally{
            if(cursor!=null){
                cursor.close();
            }
        }
        
        return c;
        
    }//End og print table where
    
    public static void update_client(Client_class client){
        DBCollection table=Singleton_app.collection;
        //Prepares user data to update
        BasicDBObject clientdata=new BasicDBObject();
        clientdata.append("name",client.getName());
        clientdata.append("surname",client.getSurname());
        clientdata.append("birthday",client.getBirthday().toString());
        clientdata.append("mobile",client.getMobile());
        clientdata.append("email",client.getEmail());
        clientdata.append("user",client.getUser());
        clientdata.append("password",client.getPass());
        clientdata.append("avatar",client.getAvatar());
        clientdata.append("state",client.isState());
        clientdata.append("regdate",client.getReg_date().toString());
        clientdata.append("shopping",client.getShopping());
        clientdata.append("premium",client.isPremium());
        clientdata.append("client_type",client.getClient_type());
        
        //Prepares to set the update
        BasicDBObject updateclient=new BasicDBObject();
        updateclient.append("$set",clientdata);
        
        //Search for records with the desired data
        BasicDBObject searchById=new BasicDBObject();
        searchById.append("dni",client.getDni());
        
        //Executes the update
        table.updateMulti(searchById, updateclient);
        
    }//End of update client
    
    public static void update_client(){
        DBCollection table=Singleton_app.collection;
        Client_class client=Singleton_client.cl;
        
        //Prepares user data to update
        BasicDBObject clientdata=new BasicDBObject();
        clientdata.append("name",client.getName());
        clientdata.append("surname",client.getSurname());
        clientdata.append("birthday",client.getBirthday().toString());
        clientdata.append("mobile",client.getMobile());
        clientdata.append("email",client.getEmail());
        clientdata.append("user",client.getUser());
        clientdata.append("password",client.getPass());
        clientdata.append("avatar",client.getAvatar());
        clientdata.append("state",client.isState());
        clientdata.append("regdate",client.getReg_date().toString());
        clientdata.append("shopping",client.getShopping());
        clientdata.append("premium",client.isPremium());
        clientdata.append("client_type",client.getClient_type());
        
        //Prepares to set the update
        BasicDBObject updateclient=new BasicDBObject();
        updateclient.append("$set",clientdata);
        
        
        
        //Search for records with the desired data
        BasicDBObject searchById=new BasicDBObject();
        searchById.append("dni",client.getDni());
        
        //Executes the update
        table.updateMulti(searchById, updateclient);
        
    }//End of update client
    
    public static void remove_client(Client_class cli){
        DBCollection table=Singleton_app.collection;
        table.remove(new BasicDBObject().append("dni", cli.getDni()));
    }
    
    public static void remove_client(){
        DBCollection table=Singleton_app.collection;
        Client_class cli=Singleton_client.cl;
        table.remove(new BasicDBObject().append("dni", cli.getDni()));
    }
    
    public static void remove_client_dni(String dni){
        DBCollection table=Singleton_app.collection;
        table.remove(new BasicDBObject().append("dni", dni));
    }//End remove client
}
