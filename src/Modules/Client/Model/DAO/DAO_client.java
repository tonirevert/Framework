/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.DAO;

import Modules.Config.Model.Classes.Config_class;
import Classes.Date_class;
import Classes.Singleton_app;
import Modules.Client.Model.BLL.BLL_client;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import static Modules.Client.Model.Classes.Singleton_client.*;
import Modules.Client.View.Create_client;
import Modules.Client.View.Modify_client;
import Utils.Validate;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

 

/**
 * DAO with verify , save and fill functions for create and edit windows
 * @author Antonio Revert
 */
public class DAO_client {
    
    /**
     * Used to check the DNI of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askDni(){
        boolean correct =false;
//        System.out.println(BLL_admin.searchDniadmin());
        if(BLL_client.searchDniclient()!=-1){
        if(Create_client.fieldDNI.getText().equals("")){
            Create_client.fieldDNI.setBackground(Color.yellow);
            Create_client.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Create_client.fieldDNI.getText())==true){
            Create_client.fieldDNI.setBackground(Color.green);
            Create_client.checkDNI.setIcon(ok);
            correct = true;
        }
        }else if(BLL_client.searchDniclient()==-1){
            Create_client.fieldDNI.setBackground(Color.orange);
            Create_client.checkDNI.setIcon(exclamation);
            correct=false;
            Create_client.areaInfo.setText("ID Card already exists in database");
            Create_client.areaInfo.setBackground(Color.orange);
        }
        return correct;
    }
    
    public static void askDniClick(){
         if(Validate.validateDNI(Create_client.fieldDNI.getText())==false){
            Create_client.fieldDNI.setText("");
        }
    }
    
    /**
     * Used to check the name of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askName(){
        boolean correct=false;
        
        if(Create_client.fieldName.getText().equals("")){
            Create_client.fieldName.setBackground(Color.yellow);
            Create_client.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Create_client.fieldName.getText())==false){
                Create_client.fieldName.setBackground(Color.yellow);
                Create_client.checkName.setIcon(no_ok);
                correct=false;
                }
                else if(Validate.valname(Create_client.fieldName.getText())==true){
                Create_client.fieldName.setBackground(Color.green);
                Create_client.checkName.setIcon(ok);
                correct=true;
                }
        }
        
        return correct;
    }
    
    /**
     * Used to check the surname of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askSurname(){
        boolean correct=false;
        if(Create_client.fieldSurname.getText().equals("")){
            Create_client.fieldSurname.setBackground(Color.yellow);
            Create_client.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Create_client.fieldSurname.getText())==false){
            Create_client.fieldSurname.setBackground(Color.yellow);
            Create_client.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Create_client.fieldSurname.getText())==true){
                Create_client.fieldSurname.setBackground(Color.green);
                Create_client.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the email of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askEmail(){
        boolean correct=false;
        
        if(Create_client.fieldEmail.getText().equals("")){
            Create_client.fieldEmail.setBackground(Color.yellow);
            Create_client.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Create_client.fieldEmail.getText())==false){
            Create_client.fieldEmail.setBackground(Color.yellow);
            Create_client.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Create_client.fieldEmail.getText())==true){
                Create_client.fieldEmail.setBackground(Color.green);
                Create_client.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the mobile number of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askMobile(){
        boolean correct=false;
        if(Create_client.fieldMobile.getText().equals("")){
            Create_client.fieldMobile.setBackground(Color.yellow);
            Create_client.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Create_client.fieldMobile.getText())==false){
                Create_client.fieldMobile.setBackground(Color.yellow);
                Create_client.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Create_client.fieldMobile.getText())==true){
                Create_client.fieldMobile.setBackground(Color.green);
                Create_client.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }

    /**
     * Used to check the user name of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askUser(){
        boolean correct=false;
        
        if(Create_client.fieldUser.getText().equals("")){
                Create_client.fieldUser.setBackground(Color.yellow);
                Create_client.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Create_client.fieldUser.getText())==false){
                Create_client.fieldUser.setBackground(Color.yellow);
                Create_client.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Create_client.fieldUser.getText())==true){
                Create_client.fieldUser.setBackground(Color.green);
                Create_client.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the password of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askPassword(){
        boolean correct=false;
        
         if(Validate.valpass(Create_client.fieldPassword.getText())==false){
            Create_client.fieldPassword.setBackground(Color.yellow);
            Create_client.checkPassword.setIcon(no_ok);
            correct=false;
        }
        else if(Validate.valpass(Create_client.fieldPassword.getText())==true){
            Create_client.fieldPassword.setBackground(Color.green);
            Create_client.checkPassword.setIcon(ok);
            correct=true;
        }
         return correct;
    }
    
    /**
     * Used to verify the password of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askPassword2(){
        boolean correct=false;
        
        if(Create_client.fieldPassword.getText().equals(Create_client.fieldPassword2.getText()) && (Validate.valpass(Create_client.fieldPassword.getText())==true)){
                Create_client.fieldPassword2.setBackground(Color.green);
                Create_client.checkPassword2.setIcon(ok);
                correct=true;
        }else{
                Create_client.fieldPassword2.setBackground(Color.yellow);
                Create_client.checkPassword2.setIcon(no_ok);
                correct=false;
            }
        
        return correct;
    }
    
    /**
     * Used to check the shopping number is correct
     * @return bollean true if ferification is correct
     */
    public static boolean askShopping(){
        boolean correct=false;
        
        if(Validate.valshopping(Create_client.fieldShopping.getText())==false){
            Create_client.fieldShopping.setBackground(Color.yellow);
            Create_client.checkShopping.setIcon(no_ok);
            correct=false;
        }else{
            Create_client.fieldShopping.setBackground(Color.green);
            Create_client.checkShopping.setIcon(ok);
            correct=true;
        }
        return correct;
    }
    
    /**
     * Used to check if the radio button is yes or no
     * @return bollean true if ferification is correct
     */
    public static boolean askConnected(){
        boolean connected=false;
        if (Create_client.radioStateYes.isSelected()){
            connected=true;
        }else if(Create_client.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }

    /**
     * Used to check a String for the client type
     * @return bollean true if ferification is correct
     */
    public static boolean askCientType(){
        boolean correct=false;
        
        if(Create_client.fieldClientType.getText().equals("")){
            Create_client.fieldClientType.setBackground(Color.yellow);
            Create_client.checkClientType.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valclitype(Create_client.fieldClientType.getText())==false){
                    Create_client.fieldClientType.setBackground(Color.yellow);
                    Create_client.checkClientType.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valclitype(Create_client.fieldClientType.getText())==true){
                    Create_client.fieldClientType.setBackground(Color.green);
                    Create_client.checkClientType.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }

    /**
     * Used to check if the Premium radio button is yes or no
     * @return bollean true if ferification is correct
     */
   public static boolean askPremium(){
        boolean connected=false;
        if (Create_client.radioPremiumYes.isSelected()){
            connected=true;
        }else if(Create_client.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
    
    /**
     * Used to check the birth date from date picker
     * @return bollean true if ferification is correct
     */
    public static boolean askBirth(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Create_client.dateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Create_client.dateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
//           System.out.println("years: "+years);
        if(years>=18){
            Create_client.checkDatebirth.setIcon(ok);
            Create_client.dateRegistration.setEnabled(true);
            Create_client.dateRegistration.getDateEditor().setEnabled(false);
            correct=true;
        }else{
            Create_client.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Create_client.areaInfo.setText(Singleton_app.lang.getProperty("dao_nobirth"));
            Create_client.checkDatebirth.setIcon(no_ok);
       }
        return correct;
    }
    
    /**
     * Used to get the avatar and sets it into the window
     * @return a String with the avatar route / name
     */
    public static String askAvatar(){
        String route="";
        String file="";
        
        JFileChooser dialog = new JFileChooser();
        dialog.setAcceptAllFileFilterUsed(false);
        dialog.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        dialog.addChoosableFileFilter(new FileNameExtensionFilter("PNG (*.png)", "png"));

        if(clientavatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvatarclient=file;
            Create_client.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Create_client.avatar.setIcon(newIcon);
            Create_client.avatar.setSize(100,100);
            Create_client.avatar.setToolTipText(file);
            clientavatar=true;
            
        }else{
            clientavatar=false;
            route=defaultavatar.toString();
        }
        }
//        System.out.println(route);
        return route;
    }
    
    /**
     * Used to check the registration date from date picker
     * @return bollean true if ferification is correct
     */
    public static boolean askDateRegistration(){
        boolean correct=false;
        int years=18;
        Calendar contract,birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Create_client.dateRegistration.setDateFormatString(dateform);
        Create_client.dateBirth.setDateFormatString(dateform);
//        dateContract.getDateEditor().setEnabled(false);
       
        try{
        contract=Create_client.dateRegistration.getCalendar();
        String c=contract.get(Calendar.DATE)+"/"+(contract.get(Calendar.MONTH)+1)+"/"+contract.get(Calendar.YEAR);
        Date_class cont= new Date_class(c);
        
        birthdate=Create_client.dateBirth.getCalendar();
        String b=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(b);
        int comp_contract=cont.compare_birth_contract(birth, years);
        
        switch (comp_contract) {
            case 2:
                if(cont.comp_today()==2){
                    Create_client.checkDateRegistration.setIcon(no_ok);
                    correct=false;
                }else{
                    Create_client.checkDateRegistration.setIcon(ok);
                    correct=true;
                }
                break;
            case 1:
                if(cont.comp_today()==2){
                    Create_client.checkDateRegistration.setIcon(no_ok);
                    correct=false;
                }else{
                    Create_client.checkDateRegistration.setIcon(ok);
                    correct=true;
                }
                break;
            case 0:
                Create_client.checkDateRegistration.setIcon(no_ok);
                correct=false;
                break;
        }
        }catch(Exception e){
            Create_client.dateRegistration.setBackground(Color.yellow);
            Create_client.areaInfo.setText(Singleton_app.lang.getProperty("dao_noreg"));
            Create_client.checkDateRegistration.setIcon(no_ok);
        }
        return correct;
    }
    
    /**
     * Sets the create window fields to defauls (empty) state
     */
    public static void resetFields(){
        Create_client.fieldDNI.setText("");
        Create_client.fieldName.setText("");
        Create_client.fieldSurname.setText("");
        Create_client.fieldEmail.setText("");
        Create_client.fieldMobile.setText("");
        Create_client.fieldUser.setText("");
        Create_client.fieldPassword.setText("");
        Create_client.fieldPassword2.setText("");
        Create_client.fieldPassword2.setBackground(Color.yellow);
        Create_client.checkPassword2.setIcon(no_ok);
        Create_client.fieldShopping.setText("");
        Create_client.fieldClientType.setText("");
        Create_client.fieldDNI.removeAll();
        Create_client.fieldName.removeAll();
        Create_client.radioStateNo.setSelected(true);
        Create_client.radioPremiumNo.setSelected(true);
        Create_client.fieldClientType.setText("");
        Create_client.areaInfo.setText("");
        Create_client.areaInfo.removeAll();
        Create_client.areaInfo.setBackground(Color.decode("#d6d6d6"));
        BLL_client.askClientdata("dni");
        BLL_client.askClientdata("name");
        BLL_client.askClientdata("surname");
        BLL_client.askClientdata("email");
        BLL_client.askClientdata("mobile");
        BLL_client.askClientdata("user");
        BLL_client.askClientdata("password");
        BLL_client.askClientdata("password2");
        BLL_client.askClientdata("activity");
        BLL_client.askClientdata("shopping");
        BLL_client.askClientdata("clienttype");
        Create_client.avatar.setIcon(defaultavatar);
        clientavatar=false;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(YEAR);//Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = calendar.get(MONTH);//Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= calendar.get(DATE);//Calendar.getInstance().get(Calendar.DATE);
        calendar.set(currentYear , currentMonth-1 , currentDate);
        date.setTime(calendar.getTimeInMillis());
        Create_client.dateBirth.setDate(date);
        Create_client.dateRegistration.setDate(date);
    }//End reset fields
    
    /**
     * Function that checks all the create window fields and get the
     * information from them
     * @return a Client user with all the data from the fields
     */
    public static Client_class create(){
        Client_class client;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="",clitype="";
        int activity=0;
        float shopping=0.0f;
        Date_class birth;
        Date_class registration;
        boolean connected=false;
        boolean premium=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fiavatar,fdbirth,fdreg,ficlityp,
                fishopp;
        Calendar birthdate,dateregistration;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirth();
        fdreg=askDateRegistration();
        fidni=askDni();
        finame=askName();
        fisurname=askSurname();
        fiemail=askEmail();
        fimobile=askMobile();
        fiuser=askUser();
        fipassword=askPassword();
        fipassword2=askPassword2();
        fishopp=askShopping();
        fiavatar=true;
        connected=askConnected();
        
        ficlityp=askCientType();
       
         if(fidni==true && finame==true && fisurname== true && fiemail==true &&fimobile==true && fiuser==true && fipassword==true &&
               fipassword2==true && fiavatar==true && fdbirth==true && fdreg==true && ficlityp==true && fishopp==true){
            dni=Create_client.fieldDNI.getText();
            name=Create_client.fieldName.getText();
            surname=Create_client.fieldSurname.getText();
            email=Create_client.fieldEmail.getText();
            mobile=Create_client.fieldMobile.getText();
            user=Create_client.fieldUser.getText();
            password=Create_client.fieldPassword.getText();
            shopping=Float.parseFloat(Create_client.fieldShopping.getText());
            clitype=Create_client.fieldClientType.getText();
            
            
            if(Create_client.radioStateYes.isSelected()){
                connected=true;
            }else if(Create_client.radioStateNo.isSelected()){
                connected=false;
            }
            
             if(Create_client.radioPremiumYes.isSelected()){
                premium=true;
            }else if(Create_client.radioPremiumNo.isSelected()){
                premium=false;
            }
            
            birthdate=Create_client.dateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
            
            dateregistration=Create_client.dateRegistration.getCalendar();
            String c=dateregistration.get(Calendar.DATE)+"/"+(dateregistration.get(Calendar.MONTH)+1)+"/"+dateregistration.get(Calendar.YEAR);
            registration=new Date_class(c);
          
            if(clientavatar==true){
                try {
                    Files.copy(Paths.get(routeAvatarclient),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_client.class.getName()).log(Level.SEVERE, null, ex);
                }
                avatar=avatarsroute+dni;
            }else{
                avatar=defaultavatar.toString();
            }
            
            client=new Client_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,registration
                    ,shopping,premium,clitype);
            clientavatar=false;
        }else{
            client=null;
             clientavatar=false;
        }
       
        return client;
        
    }//En create admin
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////                                                                EDIT CLIENT                                                                                     ////
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    /**
     * Used to check the DNI of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askDniMod(){
        boolean correct =false;
        
        if(Modify_client.fieldDNI.getText().equals("")){
            Modify_client.fieldDNI.setBackground(Color.yellow);
            Modify_client.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Modify_client.fieldDNI.getText())==true){
            Modify_client.fieldDNI.setBackground(Color.green);
            Modify_client.checkDNI.setIcon(ok);
            correct = true;
        }
        
        return correct;
    }
  
     /**
     * Used to check the name of a user in the modify window
     * @return bollean true if ferification is correct
     */
   public static boolean askNameMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldName.getText().equals("")){
            Modify_client.editfieldName.setBackground(Color.yellow);
            Modify_client.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Modify_client.editfieldName.getText())==false){
                Modify_client.editfieldName.setBackground(Color.yellow);
                Modify_client.checkName.setIcon(no_ok);
                correct=false;
            }
                else if(Validate.valname(Modify_client.editfieldName.getText())==true){
                Modify_client.editfieldName.setBackground(Color.green);
                Modify_client.checkName.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
   /**
     * Used to check the surname of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askSurnameMod(){
        boolean correct=false;
        if(Modify_client.editfieldSurname.getText().equals("")){
            Modify_client.editfieldSurname.setBackground(Color.yellow);
            Modify_client.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Modify_client.editfieldSurname.getText())==false){
            Modify_client.editfieldSurname.setBackground(Color.yellow);
            Modify_client.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Modify_client.editfieldSurname.getText())==true){
                Modify_client.editfieldSurname.setBackground(Color.green);
                Modify_client.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the email of a user  in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askEmailMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldEmail.getText().equals("")){
            Modify_client.editfieldEmail.setBackground(Color.yellow);
            Modify_client.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Modify_client.editfieldEmail.getText())==false){
            Modify_client.editfieldEmail.setBackground(Color.yellow);
            Modify_client.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Modify_client.editfieldEmail.getText())==true){
                Modify_client.editfieldEmail.setBackground(Color.green);
                Modify_client.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the mobile number of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askMobileMod(){
        boolean correct=false;
        if(Modify_client.editfieldMobile.getText().equals("")){
            Modify_client.editfieldMobile.setBackground(Color.yellow);
            Modify_client.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Modify_client.editfieldMobile.getText())==false){
                Modify_client.editfieldMobile.setBackground(Color.yellow);
                Modify_client.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Modify_client.editfieldMobile.getText())==true){
                Modify_client.editfieldMobile.setBackground(Color.green);
                Modify_client.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }
    
    /**
     * Used to check the user name of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askUserMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldUser.getText().equals("")){
                Modify_client.editfieldUser.setBackground(Color.yellow);
                Modify_client.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Modify_client.editfieldUser.getText())==false){
                Modify_client.editfieldUser.setBackground(Color.yellow);
                Modify_client.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Modify_client.editfieldUser.getText())==true){
                Modify_client.editfieldUser.setBackground(Color.green);
                Modify_client.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to check the password of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askPasswordMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldPassword.getText().equals("")){
            Modify_client.editfieldPassword.setBackground(Color.yellow);
            Modify_client.checkPassword.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valpass(Modify_client.editfieldPassword.getText())==false){
                Modify_client.editfieldPassword.setBackground(Color.yellow);
                Modify_client.checkPassword.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valpass(Modify_client.editfieldPassword.getText())==true){
                Modify_client.editfieldPassword.setBackground(Color.green);
                Modify_client.checkPassword.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    /**
     * Used to verify the password of a user in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askPassword2Mod(){
        boolean correct=false;
        
        if(Modify_client.editfieldPassword.getText().equals(Modify_client.editfieldPassword2.getText()) && (Validate.valpass(Modify_client.editfieldPassword2.getText())==true)){
            Modify_client.editfieldPassword2.setBackground(Color.green);
            Modify_client.checkPassword2.setIcon(ok);
            correct=true;    
        }else{
            Modify_client.editfieldPassword2.setBackground(Color.yellow);
            Modify_client.checkPassword2.setIcon(no_ok);
            correct=false;
        }
        
        
        return correct;
    }
    
    
    /**
     * Used to check the shopping number is correct
     * @return bollean true if ferification is correct
     */
    public static boolean askShoppingMod(){
        boolean correct=false;
        
        if(Validate.valshopping(Modify_client.editfieldShopping.getText())==false){
            Modify_client.editfieldShopping.setBackground(Color.yellow);
            Modify_client.checkShopping.setIcon(no_ok);
            correct=false;
        }else{
            Modify_client.editfieldShopping.setBackground(Color.green);
            Modify_client.checkShopping.setIcon(ok);
            correct=true;
        }
        return correct;
    }
    
    /**
     * Used to check if the radio button is yes or no in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askConnectedMod(){
        boolean connected=false;
        if (Modify_client.radioStateYes.isSelected()){
            connected=true;
        }else if(Modify_client.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
    
    /**
     * Used to check a String for the client type in the modify window
     * @return bollean true if ferification is correct
     */
        public static boolean askCientTypeMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldClientType.getText().equals("")){
            Modify_client.editfieldClientType.setBackground(Color.yellow);
            Modify_client.checkClientType.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valclitype(Modify_client.editfieldClientType.getText())==false){
                    Modify_client.editfieldClientType.setBackground(Color.yellow);
                    Modify_client.checkClientType.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valclitype(Modify_client.editfieldClientType.getText())==true){
                    Modify_client.editfieldClientType.setBackground(Color.green);
                    Modify_client.checkClientType.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }

        /**
     * Used to check if the Premium radio button is yes or no
     * in the modify window
     * @return bollean true if ferification is correct
     */
        public static boolean askPremiumMod(){
        boolean connected=false;
        if (Modify_client.radioPremiumYes.isSelected()){
            connected=true;
        }else if(Modify_client.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
       
    /**
     * Used to check the birth date from date picker in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askBirthMod(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_client.editdateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Modify_client.editdateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
        if(years>=18){
            Modify_client.checkDatebirth.setIcon(ok);
            correct=true;
        }else{
            Modify_client.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Modify_client.editdateBirth.setBackground(Color.yellow);
            Modify_client.editareaInfo.setText(Singleton_app.lang.getProperty("dao_nobirth"));
            Modify_client.checkDatebirth.setIcon(no_ok);
       }
        return correct;
    }
    
    /**
     * Used to get the avatar and sets it into the modify window
     * @return a String with the avatar route / name
     */
     public static String askAvatarMod(){
        String route="";
        String file="";
        
        JFileChooser dialog = new JFileChooser();
        dialog.setAcceptAllFileFilterUsed(false);
        dialog.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        dialog.addChoosableFileFilter(new FileNameExtensionFilter("PNG (*.png)", "png"));

        if(clientavatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvatarclient=file;//toString? con el funciona
            Modify_client.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Modify_client.avatar.setIcon(newIcon);
            Modify_client.avatar.setSize(100,100);
            Modify_client.avatar.setToolTipText(file);
            clientavatar=true;
            
        }else{
            clientavatar=false;
            route=defaultavatar.toString();
        }
        }
        return route;
    }
    
     /**
     * Used to check the registration date from date picker in the modify window
     * @return bollean true if ferification is correct
     */
    public static boolean askDateRegistrationMod(){
        boolean correct=false;
        int years=18;
        Calendar contract,birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_client.editdateRegistration.setDateFormatString(dateform);
        Modify_client.editdateBirth.setDateFormatString(dateform);
        Modify_client.editdateRegistration.getDateEditor().setEnabled(false);
       
        try{
        contract=Modify_client.editdateRegistration.getCalendar();
        String c=contract.get(Calendar.DATE)+"/"+(contract.get(Calendar.MONTH)+1)+"/"+contract.get(Calendar.YEAR);
        Date_class cont= new Date_class(c);
        
        birthdate=Modify_client.editdateBirth.getCalendar();
        String b=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(b);
        int comp_contract=cont.compare_birth_contract(birth, years);
        
        switch (comp_contract) {
            case 2:
                Modify_client.checkDateRegistration.setIcon(ok);
                correct=true;
                break;
            case 1:
                Modify_client.checkDateRegistration.setIcon(ok);
                correct=true;
                break;
            case 0:
                Modify_client.checkDateRegistration.setIcon(no_ok);
                correct=false;
                break;
        }
        }catch(Exception e){
            Modify_client.editdateRegistration.setBackground(Color.yellow);
            Modify_client.editareaInfo.setText(Singleton_app.lang.getProperty("dao_noreg"));
            Modify_client.checkDateRegistration.setIcon(no_ok);
        }
        return correct;
    }
        
    /**
     * Function that checks all the modify window fields and get the
     * information from them
     * @return a Client user with all the data from the fields
     */
    public static Client_class saveClientMod(){
        Client_class client;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="",clitype="";
        float shopping=0.0f;
        Date_class birth;
        Date_class registration;
        boolean connected=false;
        boolean premium=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fdbirth,fdreg,ficlityp,fishopp;
        Calendar birthdate,datecontract;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirthMod();
        fdreg=askDateRegistrationMod();
        fidni=askDniMod();
        finame=askNameMod();
        fisurname=askSurnameMod();
        fiemail=askEmailMod();
        fimobile=askMobileMod();
        fiuser=askUserMod();
        fipassword=askPasswordMod();
        fipassword2=askPassword2Mod();
        fishopp=askShoppingMod();
        connected=askConnectedMod();
        ficlityp=askCientTypeMod();
       
         if(fidni==true && finame==true && fisurname== true && fiemail==true &&fimobile==true && fiuser==true && 
            fipassword==true && fipassword2==true && fdbirth==true && fdreg==true && ficlityp==true && fishopp==true){
            dni=Modify_client.fieldDNI.getText();
            name=Modify_client.editfieldName.getText();
            surname=Modify_client.editfieldSurname.getText();
            email=Modify_client.editfieldEmail.getText();
            mobile=Modify_client.editfieldMobile.getText();
            user=Modify_client.editfieldUser.getText();
            password=Modify_client.editfieldPassword.getText();
            shopping=Float.parseFloat(Modify_client.editfieldShopping.getText());
            clitype=Modify_client.editfieldClientType.getText();
            
            if(clientavatar==true){
                try {
                    Files.copy(Paths.get(routeAvatarclient),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_client.class.getName()).log(Level.SEVERE, null, ex);
                }
            avatar=avatarsroute+dni;
            }else{
                avatar=avatarMod;
            }
            
            if(Modify_client.radioPremiumYes.isSelected()){
                premium=true;
            }else if(Modify_client.radioPremiumNo.isSelected()){
                premium=false;
            }
            
            birthdate=Modify_client.editdateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
            
            datecontract=Modify_client.editdateRegistration.getCalendar();
            String c=datecontract.get(Calendar.DATE)+"/"+(datecontract.get(Calendar.MONTH)+1)+"/"+datecontract.get(Calendar.YEAR);
            registration=new Date_class(c);
          
            client=new Client_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,registration
                    ,shopping,premium,clitype);
            Singleton_client.saved=0;
        
         }else{
            client=null;
            Singleton_client.saved=1;
        }
        avatarMod="";
        clientavatar=false;
        return client;
        
    }
    
    /**
     * Used to fill Modify Client window with a client data
     * @param cli is a client with all their data
     */
    public static void fillClientMod(Client_class cli){
        Date dateBirth = new Date();
        Date dateCont = new Date();
        Date_class birth=null;
        Calendar calendarBirth = Calendar.getInstance();
        Date_class reg=null;
        Calendar calendarReg = Calendar.getInstance();
        String file="";

        Modify_client.fieldDNI.setText(cli.getDni());
        Modify_client.editfieldName.setText(cli.getName());
        Modify_client.editfieldSurname.setText(cli.getSurname());
        Modify_client.editfieldEmail.setText(cli.getEmail());
        Modify_client.editfieldMobile.setText( cli.getMobile());
        Modify_client.editfieldUser.setText(cli.getUser());
        Modify_client.editfieldPassword.setText(cli.getPass());
        Modify_client.editfieldPassword2.setText(cli.getPass());
        Modify_client.editfieldShopping.setText(String.valueOf(cli.getShopping()));
        Modify_client.editfieldClientType.setText(cli.getClient_type());
        file=cli.getAvatar();
        birth=cli.getBirthday();
        avatarMod=file;
        
        Modify_client.avatar.setIcon(new ImageIcon(file));
        ImageIcon icon = new ImageIcon(file);
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        Modify_client.avatar.setIcon(newIcon);
        Modify_client.avatar.setSize(100,100);
        Modify_client.avatar.setToolTipText(file);
        
        reg=cli.getReg_date();
        
        if(cli.isState()==true){
            Modify_client.radioStateYes.setSelected(true);
        }else{
            Modify_client.radioStateNo.setSelected(true);
        }
        
        if(cli.isPremium()==true){
            Modify_client.radioPremiumYes.setSelected(true);
        }else{
            Modify_client.radioPremiumNo.setSelected(true);
        }

        calendarBirth.set(birth.getYear() , birth.getMonth()-1 , birth.getDay());
        dateBirth.setTime(calendarBirth.getTimeInMillis());
        Modify_client.editdateBirth.setDate(dateBirth);

        
        calendarReg.set(reg.getYear() , reg.getMonth()-1 , reg.getDay());
        dateCont.setTime(calendarReg.getTimeInMillis());
        Modify_client.editdateRegistration.setDate(dateCont);
        
        
        BLL_client.modClientdata("dni");
        BLL_client.modClientdata("name");
        BLL_client.modClientdata("surname");
        BLL_client.modClientdata("email");
        BLL_client.modClientdata("mobile");
        BLL_client.modClientdata("user");
        BLL_client.modClientdata("password");
        BLL_client.modClientdata("password2");
        BLL_client.modClientdata("birthdate");
        BLL_client.modClientdata("datereg");
        BLL_client.modClientdata("shopping");
        BLL_client.modClientdata("clienttype");
    }
    
    
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     ////                                                              CLIENT  MONGO DB                                                                            ////
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
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
        String out= "";
        Client_class c=new Client_class();
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
                System.out.println("NO DATA");
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

}//End public class DAO_client
