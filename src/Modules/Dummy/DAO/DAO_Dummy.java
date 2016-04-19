package Modules.Dummy.DAO;

import Modules.Admin.Model.Classes.Admin_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Dummy.Classes.Funct_Dummy;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import Modules.Reg_user.Model.Classes.Singleton_ruser;



public class DAO_Dummy {

	/**
	 * Function for create dummy users
	 * @param quantity Used to choose the amount of Dummy to create
	 */
	public static void createDummys(String type, int quantity){
		String name="";
		String surname="";
		String karma="";
		
                        switch(type){

                                case "admin":
                                        //For to add Admin Dummy's to Singleton.adm
                                        for (int i=1;i<=quantity;i++){
                                                name=Funct_Dummy.RandomName();
                                                surname=Funct_Dummy.RandomSurname();

                                                Singleton_admin.adm.add(new Admin_class(/*card+idcard*/Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
                                                                Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
                                                                Singleton_admin.defaultavatar.toString(),Funct_Dummy.randmoboolean(),Funct_Dummy.randomAfter98(),5));
                                        }
                                break;
                                case "client":
                                        //For to add Client Dummy's to Singleton.cli
                                        for (int i=1;i<=quantity;i++){
                                                name=Funct_Dummy.RandomName();
                                                surname=Funct_Dummy.RandomSurname();

                                                Singleton_client.cli.add(new Client_class(Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
                                                                Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
                                                                Singleton_client.defaultavatar.toString(),Funct_Dummy.randmoboolean(),Funct_Dummy.randomAfter98(),Funct_Dummy.randomShopping(),Funct_Dummy.randmoboolean(),"Type"));
                                        }
                                break;
                                case "ruser":
                                        //For to add Registered User Dummy's to Singleton.rus
                                        for (int i=1;i<=quantity;i++){
                                                name=Funct_Dummy.RandomName();
                                                surname=Funct_Dummy.RandomSurname();

                                                Singleton_ruser.rus.add(new Reg_user_class(Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
                                                                Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
                                                                Singleton_ruser.defaultavatar.toString(),Funct_Dummy.randmoboolean(),Funct_Dummy.randomActivity(),karma));
                                        }
                                break;
                        }
	}
	
}
