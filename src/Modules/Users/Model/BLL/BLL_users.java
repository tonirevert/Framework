package Modules.Users.Model.BLL;





public class BLL_users {

	
//	/**
//	 * Function to search an Admin from an Admin ArrayList
//	 * @return the position if user is found or -1 if doesn't found it
//	 */
//	public static int searchadmin(){
//		Admin_class admin=null;
//		admin= new Admin_class(Users_core.request_data("dni"));
//		Singleton_admin.DNI=admin.getDni();
//		
//		for (int i = 0;i<=(Singleton_admin.adm.size()-1);i++){
//			if((Singleton_admin.adm.get(i)).equals(admin) )
////				System.out.println("DNI if search"+Singleton_admin.DNI);
//				return i;
//		}
////		System.out.println("DNI -1 search: "+Singleton_admin.DNI);
//		return -1;
//		
//	}//End search admin
//	
//	/**
//	 * Used to create a new admin
//	 */
//	public static void createadmin(){
////		Admin_class admin=null;
//		
//		int pos = BLL_users.searchadmin();
//		if(pos==-1){
////			DAO_users.Create_Admin_User();
//			DAO_users.Create_User("admin");
////			Singleton_admin.adm.add();
////			System.out.println("Create admin DNI: "+Singleton_admin.DNI);
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("idexists"), "Error",JOptionPane.ERROR_MESSAGE);
//		}
//	}//End create admin
//	
//	/**
//	 * Used to modify an admin from the Array List
//	 */
//	public static void modifyadmin(){
//		Admin_class admin=null;
//		
//		if(Singleton_admin.adm.size()!=0){
//			int pos = BLL_users.searchadmin();
//			if(pos!=-1){
//				admin=Singleton_admin.adm.get(pos);
//				DAO_users.Mod_Admin_User(admin);
//			}else{
//				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End modify admin
//	
//	/**
//	 * Used to remove an admin position from the Array List
//	 */
//	public static void removeadmin(){
//		
//		if(Singleton_admin.adm.size()!=0){
//			int pos = BLL_users.searchadmin();
//			if(pos!=-1){
//				Singleton_admin.adm.remove(pos);
//			}else{
//				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}	
//	}//End remove admin
//		
//	/**
//	 * Print Admin users from the array, searching one or the entire 
//	 * Array List
//	 */
//	public static void printadmin(){
//		String [] pruser={Singleton_app.lang.getProperty("prouser"),Singleton_app.lang.getProperty("pralluser")};
//		int men=0, pos=0;
//		if(Singleton_admin.adm.size()!=0){
//			men=Funct_menus.menu_but(pruser,Singleton_app.lang.getProperty("chprtype"),Singleton_app.lang.getProperty("admprnt"));
//			switch (men) {
//			case 0:
//				pos=BLL_users.searchadmin();
//				if(pos!=-1){
//					JOptionPane.showMessageDialog(null, Singleton_admin.adm.get(pos).toString(),Singleton_app.lang.getProperty("admprnt"), JOptionPane.INFORMATION_MESSAGE);
//				}
//				else{
//					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 1:
//				if(Singleton_admin.adm.isEmpty()){
//					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admnofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}else{
//					for (int i=0;i<Singleton_admin.adm.size();i++){
//						JOptionPane.showMessageDialog(null, Singleton_admin.adm.get(i).toString(),Singleton_app.lang.getProperty("admprnt"), JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//				break;
//			}//End switch menu
//		}else{
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End print Admin
//	
//	public static Client_class clientID(){	
//		Client_class c  = null;		
//		String cod = "";
//		int pos=0;
//		String cli[] = BLL_users.generateVectorClient();
//		String user = Funct_menus.menuCombo(cli, "Seleccione un cliente","Edición");	
//		if(user != ""){
//		for(int i=0; i<cli.length; i++){		//extrae del string elegido el dni
//			pos=i;		
//			cod += user.charAt(i);
//		}
//		}
//		c = new Client_class(cod);
//				DAO_users.Mod_Client_User(c);
////				Singleton_admin.cli.set(pos,c);
//		return c;
//	}
//	
//	public static int searchPosition(){		
//		Client_class c = BLL_users.clientID();
//			int pos = Singleton_admin.cli.indexOf(c);
//		return pos;
//	}
//	
//	public static void modifyClient(){
//		Client_class c=null;
//		int pos = 0; 
//			if(Singleton_admin.cli.size() != 0){
//				pos = searchPosition();
//				c= (Singleton_admin.cli.get(pos));
//				/*	c =*/ DAO_users.Mod_Client_User(c);
//					Singleton_admin.cli.set(pos, c);			
//			}else
//				JOptionPane.showMessageDialog(null,"ArrayList vacía","Información",JOptionPane.WARNING_MESSAGE);		
//	}
//	
//	public static String[] generateVectorClient(){ //Guarda el DNI, nombre y apellidos de todos los clientes en un vector
//		Client_class c;	
//		String s = "";	
//			int n = Singleton_admin.cli.size();			
//				String cli[] = new String[n];
//				for(int i=0; i<n; i++){
//					c = (Client_class)Singleton_admin.cli.get(i);
//						s =  c.getDni() + " - " + c.getName() + " " + c.getSurname();
//						cli[i] = s;
//				}				
//		return cli;
//	}
//	
//	public static void printArrayList(ArrayList<? extends User_class> l){
//		@SuppressWarnings("unchecked")
//		Iterator<User_class> it = (Iterator<User_class>) l.iterator();
//		while (it.hasNext()) {
//			User_class c = it.next();
//				JOptionPane.showMessageDialog(null, c.toString(),Singleton_app.lang.getProperty("printing"),
//													JOptionPane.INFORMATION_MESSAGE);
//		}
//	}
//	
//	public static void orderadmin(){
//		String[] men={Singleton_app.lang.getProperty("idcard"),Singleton_app.lang.getProperty("surname"),Singleton_app.lang.getProperty("bdate"),Singleton_app.lang.getProperty("age"),Singleton_app.lang.getProperty("antiquity")};
//		int menu=0;
//		if(Singleton_admin.adm.size()!=0){
//			menu=Funct_menus.menu_but(men,Singleton_app.lang.getProperty("chordtype"),Singleton_app.lang.getProperty("ordusers"));
//			switch (menu) {
//			case 0:
//				Collections.sort(Singleton_admin.adm);
//				break;
//			case 1:
//				Collections.sort(Singleton_admin.adm, new ordersurname());
//				break;
//			case 2:
//				Collections.sort(Singleton_admin.adm, new orderbirthdate());
//				break;
//			case 3:
//				Collections.sort(Singleton_admin.adm, new orderage());
//				break;
//			case 4:
//				Collections.sort(Singleton_admin.adm, new orderantiquity());
//				break;
//			}//End menu switch
//			
//		}else{
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admnodatnot"), "Error", JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End order admin
//	
//	
//	/**
//	 * Function to search an Client from an Client ArrayList
//	 * @return the position if user is found or -1 if doesn't found it
//	 */
//	public static int searchclient(){
//		Client_class client=null;
//		client= new Client_class(Users_core.request_data("dni"));
//		Singleton_admin.DNI=client.getDni();
//		
//		for (int i = 0; i<=(Singleton_admin.cli.size()-1); i++){
//			if((Singleton_admin.cli.get(i)).equals(client) )
//				return i;
//		}
//		return -1;
//	}//End search client
//	
//	/**
//	 * Used to create a new client
//	 */
//	public static void createclient(){
////		Client_class client=null;
//		
//		int pos = BLL_users.searchclient();
//		if(pos==-1){
////			DAO_users.Create_Client_User();
//			DAO_users.Create_User("client");
////			Singleton_admin.cli.add(client);
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("idexists"), "Error",JOptionPane.ERROR_MESSAGE);
//		}
//	}//End create client	
//	
//	/**
//	 * Used to modify a client from the Array List
//	 */
//	public static void modifyclient(){
//		Client_class client=null;
//		
//		if(Singleton_admin.cli.size()!=0){
//			int pos = BLL_users.searchclient();
//			if(pos!=-1){
//				client=Singleton_admin.cli.get(pos);
//				DAO_users.Mod_Client_User(client);
//			}else{
//				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clinodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End modify client
//	
//	/**
//	 * Used to remove a client position from the Array List
//	 */
//	public static void removeclient(){
//		
//		if(Singleton_admin.cli.size()!=0){
//			int pos = BLL_users.searchclient();
//			if(pos!=-1){
//				Singleton_admin.cli.remove(pos);
//			}else{
//				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clinodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//		
//	}//End remove client
//	
//	/**
//	 * Menu Print Client users from the array
//	 */
//	public static void printclient(){
//		String [] pruser={Singleton_app.lang.getProperty("prouser"),Singleton_app.lang.getProperty("pralluser")};
//		int men=0, pos=0;
//		
//		if(Singleton_admin.cli.size()!=0){
//			men=Funct_menus.menu_but(pruser, Singleton_app.lang.getProperty("chprtype"), Singleton_app.lang.getProperty("cliprnt"));
//			switch (men) {
//			case 0:
//				pos=BLL_users.searchclient();
//				if(pos!=-1){
//					JOptionPane.showMessageDialog(null, Singleton_admin.cli.get(pos).toString(),Singleton_app.lang.getProperty("cliprnt"), JOptionPane.INFORMATION_MESSAGE);
//				}
//				else{
//					JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 1:
//				if(Singleton_admin.cli.isEmpty()){
//					JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clinofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}else{
//					for (int i=0;i<Singleton_admin.cli.size();i++){
//						JOptionPane.showMessageDialog(null, Singleton_admin.cli.get(i).toString(), Singleton_app.lang.getProperty("cliprnt"),
//								JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//				break;
//			}//End switch menu
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clinodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End print client
//	
//	public static void orderclient(){
//		String[] men={Singleton_app.lang.getProperty("idcard"),Singleton_app.lang.getProperty("surname"),Singleton_app.lang.getProperty("bdate"),Singleton_app.lang.getProperty("age"),Singleton_app.lang.getProperty("antique")};
//		int menu=0;
//		if(Singleton_admin.cli.size()!=0){
//			menu=Funct_menus.menu_but(men, Singleton_app.lang.getProperty("chordtype"), Singleton_app.lang.getProperty("ordusers"));
//			switch (menu) {
//			case 0:
//				Collections.sort(Singleton_admin.cli);
//				break;
//			case 1:
//				Collections.sort(Singleton_admin.cli, new ordersurname());
//				break;
//			case 2:
//				Collections.sort(Singleton_admin.cli, new orderbirthdate());
//				break;
//			case 3:
//				Collections.sort(Singleton_admin.cli, new orderage());
//				break;
//			case 4:
//				Collections.sort(Singleton_admin.cli, new orderantique());
//				break;
//			}//End menu switch
//			
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clinodatnot"), "Error", JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End order client user
//	
//	
//	
//	/**
//	 * Function to search an registered user from an registered user ArrayList
//	 * @return the position if user is found or -1 if doesn't found it
//	 */
//	public static int searchruser(){
//		
//		Reg_user_class ruser=null;
//		ruser= new Reg_user_class(Users_core.request_data("dni"));
//		Singleton_admin.DNI=ruser.getDni();
//		
//		for (int i = 0; i<=(Singleton_admin.rus.size()-1); i++){
//			if((Singleton_admin.rus.get(i)).equals(ruser) )
//				return i;
//		}
//		return -1;
//	}//End search registered user
//	
//	/**
//	 * Used to create a new registered user
//	 */
//	public static void createruser(){
////		Reg_user_class ruser=null;
//		
//		int pos = BLL_users.searchruser();
//		if(pos==-1){
////			DAO_users.Create_Reg_User();
//			DAO_users.Create_User("r_user");
////			Singleton_admin.rus.add(ruser);
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("idexists"), "Error",JOptionPane.ERROR_MESSAGE);
//		}
//	}//End create registered user
//	
//	/**
//	 * Used to modify an registered user from the Array List
//	 */
//	public static void modifyruser(){
//		Reg_user_class ruser=null;
//		
//		if(Singleton_admin.rus.size()!=0){
//			int pos = BLL_users.searchruser();
//			if(pos!=-1){
//				ruser=Singleton_admin.rus.get(pos);
//				DAO_users.Mod_Reg_User(ruser);
//			}else{
//				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End modify registered user
//	
//	/**
//	 * Used to remove a reg. user position from the Array List
//	 */
//	public static void removeruser(){
//		
//		if(Singleton_admin.rus.size()!=0){
//			int pos = BLL_users.searchruser();
//			if(pos!=-1){
//				Singleton_admin.rus.remove(pos);
//			}else{
//				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}	
//	}//End remove registered user
//	
//	/**
//	 * Menu Print Registered Users from the array
//	 */
//	public static void printruser(){
//		String [] pruser={Singleton_app.lang.getProperty("prouser"),Singleton_app.lang.getProperty("pralluser")};
//		int men=0, pos=0;
//		if(Singleton_admin.rus.size()!=0){
//			men=Funct_menus.menu_but(pruser,Singleton_app.lang.getProperty("chprtype"), Singleton_app.lang.getProperty("rusprnt"));
//			switch (men) {
//			case 0:
//				pos=BLL_users.searchruser();
//				if(pos!=-1){
//					JOptionPane.showMessageDialog(null, Singleton_admin.rus.get(pos).toString(), Singleton_app.lang.getProperty("rusprnt"), JOptionPane.INFORMATION_MESSAGE);
//				}
//				else{
//					JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("unofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 1:
//				if(Singleton_admin.rus.isEmpty()){
//					JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnofound"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				}else{
//					for (int i=0;i<Singleton_admin.rus.size();i++){
//						JOptionPane.showMessageDialog(null, Singleton_admin.rus.get(i).toString(), Singleton_app.lang.getProperty("rusprnt"),
//								JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//				break;
//			}//End switch menu
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnodat"), "Info",JOptionPane.INFORMATION_MESSAGE);
//		}
//		
//	}//End print registered user
//	
//	public static void orderruser(){
//		String[] men={Singleton_app.lang.getProperty("idcard"),Singleton_app.lang.getProperty("surname"),Singleton_app.lang.getProperty("bdate"),Singleton_app.lang.getProperty("age"),Singleton_app.lang.getProperty("activity")};
//		int menu=0;
//		if(Singleton_admin.rus.size()!=0){
//			menu=Funct_menus.menu_but(men, Singleton_app.lang.getProperty("chordtype"), Singleton_app.lang.getProperty("ordusers"));
//			switch (menu) {
//			case 0:
//				Collections.sort(Singleton_admin.rus);
//				break;
//			case 1:
//				Collections.sort(Singleton_admin.rus, new ordersurname());
//				break;
//			case 2:
//				Collections.sort(Singleton_admin.rus, new orderbirthdate());
//				break;
//			case 3:
//				Collections.sort(Singleton_admin.rus, new orderage());
//				break;
//			case 4:
//				Collections.sort(Singleton_admin.rus, new orderactivity());
//				break;
//			}//End menu switch
//			
//		}else{
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnodatnot"), "Error", JOptionPane.INFORMATION_MESSAGE);
//		}
//	}//End order client user
	
}
