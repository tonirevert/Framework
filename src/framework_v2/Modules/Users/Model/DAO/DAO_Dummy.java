package framework_v2.Modules.Users.Model.DAO;


import framework_v2.Modules.Reg_user.Model.Classes.Reg_user_class;
import framework_v2.Modules.Client.Model.Classes.Client_class;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import framework_v2.Modules.Admin.Model.Classes.Admin_class;
import framework_v2.Modules.Users.Model.Utils.Funct_Dummy;


public class DAO_Dummy {

//	/**
//	 * Function for create dummy users
//	 * @param quantity Used to choose the amount of Dummy to create
//	 */
//	public static void createDummys(int quantity){
//		String name="";
//		String surname="";
////		String card="";
////		char idcard=' ';
//		String karma="";
//		
//		
//		//For to add Admin Dummy's to Singleton_admin.adm
//		for (int i=1;i<=quantity;i++){
//			name=Funct_Dummy.RandomName();
//			surname=Funct_Dummy.RandomSurname();
////			card=Funct_Dummy.randomDni();
////			idcard=Funct_Dummy.nifnie(Integer.parseInt(card));
//			
//			Singleton_admin.adm.add(new Admin_class(/*card+idcard*/Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
//					Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
//					"Avatar",Funct_Dummy.randmoboolean(),Funct_Dummy.randomAfter98(),5));
//		}
//		
//		//For to add Client Dummy's to Singleton_admin.cli
//		for (int i=1;i<=quantity;i++){
//			name=Funct_Dummy.RandomName();
//			surname=Funct_Dummy.RandomSurname();
////			card=Funct_Dummy.randomDni();
////			idcard=Funct_Dummy.nifnie(Integer.parseInt(card));
//			
//			Singleton_admin.cli.add(new Client_class(Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
//					Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
//					"Avatar",Funct_Dummy.randmoboolean(),Funct_Dummy.randomAfter98(),Funct_Dummy.randomShopping(),Funct_Dummy.randmoboolean(),"Type"));
//		}
//		
//		//For to add Registered User Dummy's to Singleton_admin.rus
//		for (int i=1;i<=quantity;i++){
//			name=Funct_Dummy.RandomName();
//			surname=Funct_Dummy.RandomSurname();
////			card=Funct_Dummy.randomDni();
////			idcard=Funct_Dummy.nifnie(Integer.parseInt(card));
//			
//			Singleton_admin.rus.add(new Reg_user_class(Funct_Dummy.nif(Funct_Dummy.randomDni()),name,surname,Funct_Dummy.randomBirth(),
//					Funct_Dummy.randomMobile(),Funct_Dummy.randomEmail(name,surname),name+Funct_Dummy.randomusername(),Funct_Dummy.generatePasswd(),
//					"Avatar",Funct_Dummy.randmoboolean(),Funct_Dummy.randomActivity(),karma));
//		}
//	}
	
}
