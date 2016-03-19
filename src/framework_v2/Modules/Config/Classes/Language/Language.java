package framework_v2.Modules.Config.Classes.Language;

import java.io.IOException;
import java.util.Properties;


public class Language extends Properties{
	private static final long serialVersionUID = 1L;
	private String lang;

	public Language (String lang){
		
	    switch(lang){
	    case "en":
	        getProperties("english.properties");
	        break;
	    case "es":
	        getProperties("spanish.properties");
	        break;
	    case "val":
	    	getProperties("valencian.properties");
	    	break;
	    }
	}

	public String getLanguage() {
		return lang;
	}
	
	public void setLanguage(String lang) {

		this.lang = lang;
		switch(lang){
	    case "en":
//	    	System.out.println("set language en");
	        getProperties("english.properties");
	        break;
	    case "es":
//	    	System.out.println("set language es");
	        getProperties("spanish.properties");
	        break;
	    case "val":
	        getProperties("valencian.properties");
	        break;
		}
	}

	
	public void getProperties(String lang) {
		try {
            this.load(getClass().getResourceAsStream(lang) );
        } catch (IOException ex) {
        }
	}
	
	/*
	public static void main(String[] args){
		Language lang = new Language("en");
		System.out.print(lang.getProperty("bye"));
		lang.setLanguage("Spanish");
		System.out.print(lang.getProperty("bye"));
	}
	*/
	
}
