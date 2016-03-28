package Modules.Users.Model.Utils;




public class Funct_Dummy {
	
//	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
//
//	
////	public static String randomDni() {
////        String idnumbers = "";
////        long milis = new java.util.GregorianCalendar().getTimeInMillis();
////        Random r = new Random(milis);
////        while (idnumbers.length() < 8) {
////            char c = (char) r.nextInt(255);
////            if ((c >= '0' && c <= '8')) {
////                idnumbers += c;
////            }
////
////        }
////        return idnumbers;
////    }
//	
//	
//	public static String randomDni(){
//		StringBuffer mobile=new StringBuffer();
//		String nums = "1234567890";
//		int length1=8;
//		int numsLength1 = nums.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * numsLength1;
//			mobile.append(nums.charAt((int) index));
//		}
//		return mobile.toString();
//	}
////	public static String randIdcard(){
////		StringBuffer out= new StringBuffer();
////		String id=Funct_Dummy.randomDni();
////		char word=Funct_Dummy.nifnie(Integer.parseInt(id));
////		out.append(id+word);
////		
////		return out.toString();
////	}
//	
////	public static char nifnie(int dni) {
////        return NIF_STRING_ASOCIATION.charAt(dni % 23);
////    }
////	
//	public static String nif(String dni) {
//        return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(Integer.parseInt(dni) % 23);
//    }
//	
//	public static boolean randmoboolean(){
//		return Math.random()< 0.5;
//	}
//	
////	public static String generatemail(int length) {
////	    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
////	            "1234567890";   //numbers
////
////	    String email="";
////	    String temp=RandomStringUtils.random(length,allowedChars);
////	    email=temp.substring(0,temp.length()-9)+"@test.org";
////	    return email;
////	}
//	
//	public static String generatePasswd(){
//
//		StringBuffer buffer = new StringBuffer();
//		String characters1 = "abcdefghijklmnopqrstuvwxyz";
//		String characters2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String characters3 = "1234567890";
//		int length1=1;
//		int length2=1;
//		int length3=1;
//		int charactersLength1 = characters1.length();
//		int charactersLength2 = characters2.length();
//		int charactersLength3 = characters3.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * charactersLength1;
//			buffer.append(characters1.charAt((int) index));
//		}
//		for (int i = 0; i < length2; i++) {
//			double index = Math.random() * charactersLength2;
//			buffer.append(characters2.charAt((int) index));
//		}
//		for (int i = 0; i < length3; i++) {
//			double index = Math.random() * charactersLength3;
//			buffer.append(characters3.charAt((int) index));
//		}
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * charactersLength1;
//			buffer.append(characters1.charAt((int) index));
//		}
//		for (int i = 0; i < length3; i++) {
//			double index = Math.random() * charactersLength3;
//			buffer.append(characters3.charAt((int) index));
//		}
//		for (int i = 0; i < length2; i++) {
//			double index = Math.random() * charactersLength2;
//			buffer.append(characters2.charAt((int) index));
//		}
//		for (int i = 0; i < length3; i++) {
//			double index = Math.random() * charactersLength3;
//			buffer.append(characters3.charAt((int) index));
//		}
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * charactersLength1;
//			buffer.append(characters1.charAt((int) index));
//		}
//		return buffer.toString();
//	}
//	
//	public static String RandomName() {// Random names
//		Random rand = new Random();
//		int max=41;
//		int min=1;
//        @SuppressWarnings("unused")
//		String name = "";
//        String[] names = {"","Vicent","Walter","Joan","Maria","Daniel","Josep","Sara","Pepa","Felipe","David",
//            "Jaume","Sergio","Toni","Paco","Emilio","Nando","Alfonso","Eduardo","Natalia","Veronica","Fina","Pepe",
//            "Oscar","German","Cristina","Lola","Roser","Ismael","Jordi","Ramon","Javier","Nuria","Elena",
//            "Pedro","Pablo","Juanjo","Santiago","Miguel","Joana","Salva","Antonio"};
//
////        int position = (int) (Math.random() * 20) % 10;
//
//        int position= rand.nextInt((max - min) + 1) + min;
//        return name = names[position];
//    }
//	
//	public static String RandomSurname(){
//		Random rand = new Random();
//		int max=41;
//		int min=1;
//        @SuppressWarnings("unused")
//		String name = "";
//        String[] names = {"","Revert","Fernandez","Diaz","Moreno","Vidal","Vellber","Calabuig","Dominguez","Molla","Hoyos",
//            "Alonso","Tortosa","Rueda","Navalon","Donat","Hinojosa","Ventura","Carril","Soriano","Alonso","Francés","Tortosa",
//            "Ruiz","Luque","Esteller","Segrelles","Gil","Coll","Carmelo","Gramage","Pindado","Soto","Camos",
//            "Morcillo","Mira","Ferri","Palomares","Raga","Beneyto","Soler","Mesas"};
//
////        int position = (int) (Math.random() * 20) % 10;
//
//        int position= rand.nextInt((max - min) + 1) + min;
//        return name = names[position];
//		
//	}
//	
//	public static String randomMobile(){
//		StringBuffer mobile=new StringBuffer();
//		String nums = "1234567890";
//		int length1=9;
//		int numsLength1 = nums.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * numsLength1;
//			mobile.append(nums.charAt((int) index));
//		}
//		return "34"+mobile.toString();
//	}
//	
//	public static String randomEmail(String part1,String part2){
//		
//		return part1+part2+"@dummy.org";
//	}
//	
//	public static Date_class randomBirth(){
//		Random random = new Random();
//		int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();//Date from random date
//		int maxDay = (int) LocalDate.of(1998, 1, 1).toEpochDay();//Date to random date
//		long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//
////		System.out.println(randomBirthDate);
//		return new Date_class(randomBirthDate.toString(),"");
//	}
//		
//	public static Date_class randomAfter98(){
//		Random random = new Random();
//		int minDay = (int) LocalDate.of(1998, 1, 1).toEpochDay();//Date from random date
//		int maxDay = (int) LocalDate.of(2016, 1, 1).toEpochDay();//Date to random date
//		long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//
////		System.out.println(randomBirthDate);
//		return new Date_class(randomBirthDate.toString(),"");
//	}
//	
//	public static float randomShopping(){
//		StringBuffer mobile=new StringBuffer();
//		String nums = "1234567890";
//		int length1=4;
//		int numsLength1 = nums.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * numsLength1;
//			mobile.append(nums.charAt((int) index));
//		}
//		return Float.parseFloat(mobile.toString());
//	}
//	
//	public static String randomusername(){
//		StringBuffer number=new StringBuffer();
//		
//		String nums = "1234567890";
//		int length1=4;
//		int numsLength1 = nums.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * numsLength1;
//			number.append(nums.charAt((int) index));
//		}
//		return number.toString();
//	}
//	
//	public static int randomActivity(){
//		StringBuffer mobile=new StringBuffer();
//		String nums = "1234567890";
//		int length1=4;
//		int numsLength1 = nums.length();
//		
//		for (int i = 0; i < length1; i++) {
//			double index = Math.random() * numsLength1;
//			mobile.append(nums.charAt((int) index));
//		}
//		return Integer.parseInt(mobile.toString());
//	}
//	
//	public static void Dummy_old() {
//		
//		
//		
//		String [] testdni={"48292470Z","48722473D","28554926N","26599039E","42470829H","32648520C","48520326D","28485527G","33582562D","21059874Q"};
//		String [] testnames={"Antonio","Jose","Pepe","Marta","Manuel","Andreu","Angela","Jorge","Felipe","Iñaki"};
//		String [] testsur={"Revert","Gonzalez","Fernandez","Moran","Sanchis","Tormo","Valls","Hinojosa","Calabuig","Bertomeu"};
//		String [] birthdates={"24/05/1981","22/03/1987","23/02/1983","12/04/1973","20/05/1985","20/12/1986","14/03/1980","23/07/1989","25/11/1978","29/12/1977"};
//		String [] testmobile={"34651936114","34625896321","34632548985","34962388320","34962383904","34676025489","34696201458","34702963218","34620859624","34624125951"};
//		String [] testmail={"test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com"};
//		String [] testuname={"Thorin","Glados","Frodo","Test4","Test5","Test6","Test7","Test8","Test9","Test10"};
//		String [] testpasswd={"1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35"};
//		String [] testavatar={"avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar"};
//		String [] contdates={"13/01/2016","20/04/2014","23/02/2000","27/09/2011","29/11/2015","20/01/2012","20/03/2014","25/03/2008","24/05/2009","26/07/2009"};
//		boolean[] testboolean={true,false,false,true,true,true,false,true,true,false};
//		String karma="";
//		int men=0;
//		String [] mendummy={"Create Admin Dummy's","Create Client Dummy's","Create Reg User Dummy's"};
//		
//				men = Funct_menus.menu_but(mendummy, "Choose type to create:", "Dummy creator");
//				switch(men){
//				case 0:
//					for(int i=0;i<=9;i++){
//						Singleton_admin.adm.add(new Admin_class(testdni[i],testnames[i],testsur[i],new Date_class(birthdates[i]),
//								testmobile[i],testmail[i],testuname[i],testpasswd[i],testavatar[i],true,
//								new Date_class(contdates[i]),30));
//					} //End for
//				break;
//		
//				case 1:
//					for(int i=0;i<=9;i++){
//						Singleton_admin.cli.add(new Client_class(testdni[i],testnames[i],testsur[i],new Date_class(birthdates[i]),
//								testmobile[i],testmail[i],testuname[i],testpasswd[i],testavatar[i],true,
//								new Date_class(contdates[i]),200.00f,testboolean[i],"test"));
//					} //End for
//				break;
//						
//				case 2:
//					for(int i=0;i<=9;i++){
//						Singleton_admin.rus.add(new Reg_user_class(testdni[i],testnames[i],testsur[i],new Date_class(birthdates[i]),
//								testmobile[i],testmail[i],testuname[i],testpasswd[i],testavatar[i],true,20,karma));
//					} //End for
//				break;
//				}
//			
////		for (int i=1;i<=30;i++){
////		String dni= Main_Dummy.randomDni();
////			JOptionPane.showMessageDialog(null,i+"\n"+Main_Dummy.RandomName()+" "+Main_Dummy.RandomSurname()+" "+ dni+Main_Dummy.nifnie(Integer.parseInt(dni))+" "+Main_Dummy.randomBirth()+"\n"+Main_Dummy.randomafter98(), "Test", JOptionPane.INFORMATION_MESSAGE);
////		}
//		
//			
//	}//End of Dummy
		
		

}
