/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Client.Model.DAO;

import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Classes.Date_class;
import framework_v2.Modules.Admin.View.Modify_admin;
import framework_v2.Modules.Client.Model.BLL.BLL_client;
import framework_v2.Modules.Client.Model.Classes.Client_class;
import framework_v2.Modules.Client.Model.Classes.Singleton_client;
import static framework_v2.Modules.Client.Model.Classes.Singleton_client.*;

import static framework_v2.Modules.Client.View.Create_client.*;

import framework_v2.Modules.Client.View.Create_client;
import framework_v2.Modules.Client.View.Modify_client;

import framework_v2.Utils.Validate;
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
 *
 * @author Antonio Revert
 */
public class DAO_client {
    
    public static boolean askDni(){
        boolean correct =false;
//        System.out.println(BLL_admin.searchDniadmin());
        if(BLL_client.searchDniaclient()!=-1){
        if(Create_client.fieldDNI.getText().equals("")){
            Create_client.fieldDNI.setBackground(Color.yellow);
            Create_client.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Create_client.fieldDNI.getText())==true){
            Create_client.fieldDNI.setBackground(Color.green);
            Create_client.checkDNI.setIcon(ok);
            correct = true;
        }
        }else if(BLL_client.searchDniaclient()==-1){
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
    
    public static boolean askConnected(){
        boolean connected=false;
        if (radioStateYes.isSelected()){
            connected=true;
        }else if(radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }

    public static boolean askCientType(){
        boolean correct=false;
        
        if(Create_client.fieldClientType.getText().equals("")){
            Create_client.fieldClientType.setBackground(Color.yellow);
            Create_client.checkClientType.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Create_client.fieldClientType.getText())==false){
                    Create_client.fieldClientType.setBackground(Color.yellow);
                    Create_client.checkClientType.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Create_client.fieldClientType.getText())==true){
                    Create_client.fieldClientType.setBackground(Color.green);
                    Create_client.checkClientType.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }

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
            Create_client.areaInfo.setText("No birth date selected");
            Create_client.checkDatebirth.setIcon(no_ok);
       }
        return correct;
    }
    
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
            routeAvataradmin=file;
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
    
    public static boolean askDatecontract(){
        boolean correct=false;
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
        int comp_contract=cont.compare_birth_contract(birth, 16);
        
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
            Create_client.areaInfo.setText("No contract date selected");
            Create_client.checkDateRegistration.setIcon(no_ok);
        }
        return correct;
    }
    
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
        Create_client.areaInfo.setText("");
        Create_client.areaInfo.removeAll();
        Create_client.areaInfo.setBackground(Color.decode("#d6d6d6"));
        BLL_client.askAdmindata("dni");
        BLL_client.askAdmindata("name");
        BLL_client.askAdmindata("surname");
        BLL_client.askAdmindata("email");
        BLL_client.askAdmindata("mobile");
        BLL_client.askAdmindata("user");
        BLL_client.askAdmindata("password");
        BLL_client.askAdmindata("password2");
        BLL_client.askAdmindata("activity");
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
    
    public static Client_class create(){
        Client_class client;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="",clitype="";
        int activity=0;
        float shopping=0.0f;
        Date_class birth;
        Date_class registration;
        boolean connected=false;
        boolean premium=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fiavatar,fdbirth,fdcont,ficlityp,
                fishopp;
        Calendar birthdate,dateregistration;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirth();
        fdcont=askDatecontract();
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
               fipassword2==true && fiavatar==true && fdbirth==true && fdcont==true && ficlityp==true && fishopp==true){
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
                    Files.copy(Paths.get(routeAvataradmin),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
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
    ////                                                                EDIT ADMIN                                                                                     ////
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
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
    
    public static void askDniClickMod(){
         if(Validate.validateDNI(Modify_client.fieldDNI.getText())==false){
            Modify_client.fieldDNI.setText("");
        }
    }
    
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
    
    public static boolean askConnectedMod(){
        boolean connected=false;
        if (Modify_client.radioStateYes.isSelected()){
            connected=true;
        }else if(Modify_client.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
    
    public static boolean askActivityMod(){
        boolean correct=false;
        
        if(Modify_client.editfieldActivity.getText().equals("")){
            Modify_client.editfieldActivity.setBackground(Color.yellow);
            Modify_client.checkActivity.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Modify_client.editfieldActivity.getText())==false){
                    Modify_client.editfieldActivity.setBackground(Color.yellow);
                    Modify_client.checkActivity.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Modify_client.editfieldActivity.getText())==true){
                    Modify_client.editfieldActivity.setBackground(Color.green);
                    Modify_client.checkActivity.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }
    
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
            Modify_client.editareaInfo.setText("No birth date selected");
            Modify_client.checkDatebirth.setIcon(no_ok);
       }
        return correct;
    }
    
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
            routeAvataradmin=file;//toString? con el funciona
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
    
    public static boolean askDatecontractMod(){
        boolean correct=false;
        Calendar contract,birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_client.editdateContract.setDateFormatString(dateform);
        Modify_client.editdateBirth.setDateFormatString(dateform);
        Modify_client.editdateContract.getDateEditor().setEnabled(false);
       
        try{
        contract=Modify_client.editdateContract.getCalendar();
        String c=contract.get(Calendar.DATE)+"/"+(contract.get(Calendar.MONTH)+1)+"/"+contract.get(Calendar.YEAR);
        Date_class cont= new Date_class(c);
        
        birthdate=Modify_client.editdateBirth.getCalendar();
        String b=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(b);
        int comp_contract=cont.compare_birth_contract(birth, 16);
        
        switch (comp_contract) {
            case 2:
                Modify_client.checkDatecontract.setIcon(ok);
//                datetype=1;
                correct=true;
                break;
            case 1:
                Modify_client.checkDatecontract.setIcon(ok);
//                datetype=1;
                correct=true;
                break;
            case 0:
                Modify_client.checkDatecontract.setIcon(no_ok);
//                datetype=0;
                correct=false;
                break;
        }
        }catch(Exception e){
            Modify_client.editdateContract.setBackground(Color.yellow);
            Modify_client.editareaInfo.setText("No contract date selected");
            Modify_client.checkDatecontract.setIcon(no_ok);
        }
        return correct;
    }
    
    public static void resetFieldsMod(){
        Modify_client.fieldDNI.setText("");
        Modify_client.editfieldName.setText("");
        Modify_client.editfieldSurname.setText("");
        Modify_client.editfieldEmail.setText("");
        Modify_client.editfieldMobile.setText("");
        Modify_client.editfieldUser.setText("");
        Modify_client.editfieldPassword.setText("");
        Modify_client.editfieldPassword2.setText("");
        Modify_client.editfieldPassword2.setBackground(Color.yellow);
        Modify_client.checkPassword2.setIcon(no_ok);
        Modify_client.editfieldActivity.setText(" ");
        Modify_client.fieldDNI.removeAll();
        Modify_client.editfieldName.removeAll();
        BLL_client.modClientdata("activity");
        BLL_client.modClientdata("dni");
        BLL_client.modClientdata("email");
        BLL_client.modClientdata("mobile");
        BLL_client.modClientdata("name");
        BLL_client.modClientdata("password");
        BLL_client.modClientdata("surname");
        BLL_client.modClientdata("user");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(YEAR);//Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = calendar.get(MONTH);//Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= calendar.get(DATE);//Calendar.getInstance().get(Calendar.DATE);
        calendar.set(currentYear , currentMonth-1 , currentDate);
        date.setTime(calendar.getTimeInMillis());
        Modify_client.editdateBirth.setDate(date);
        Modify_client.editdateContract.setDate(date);
    }
    
    public static Client_class saveClientMod(){
        Client_class admin;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="";
        int activity=0, position=0;
        Date_class birth;
        Date_class contract;
        boolean connected=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fiavatar,fdbirth,fdcont,factiv;
        Calendar birthdate,datecontract;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirthMod();
        fdcont=askDatecontractMod();
        fidni=askDniMod();
        finame=askNameMod();
        fisurname=askSurnameMod();
        fiemail=askEmailMod();
        fimobile=askMobileMod();
        fiuser=askUserMod();
        fipassword=askPasswordMod();
        fipassword2=askPassword2Mod();
        
        connected=askConnectedMod();
        
        factiv=askActivityMod();
       
         if(fidni==true && finame==true && fisurname== true && fiemail==true &&fimobile==true && fiuser==true && fipassword==true &&
                fipassword2==true && fdbirth==true && fdcont==true && factiv==true){
            dni=Modify_admin.fieldDNI.getText();
            name=Modify_admin.editfieldName.getText();
            surname=Modify_admin.editfieldSurname.getText();
            email=Modify_admin.editfieldEmail.getText();
            mobile=Modify_admin.editfieldMobile.getText();
            user=Modify_admin.editfieldUser.getText();
            password=Modify_admin.editfieldPassword.getText();
            activity=Integer.parseInt(Modify_admin.editfieldActivity.getText());
            
            if(clientavatar==true){
                try {
                    Files.copy(Paths.get(routeAvataradmin),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_client.class.getName()).log(Level.SEVERE, null, ex);
                }
            avatar=avatarsroute+dni;
            }else{
                avatar=defaultavatar.toString();
            }
            
            birthdate=Modify_admin.editdateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
            
            datecontract=Modify_admin.editdateContract.getCalendar();
            String c=datecontract.get(Calendar.DATE)+"/"+(datecontract.get(Calendar.MONTH)+1)+"/"+datecontract.get(Calendar.YEAR);
            contract=new Date_class(c);
          
            admin=new Admin_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,contract,activity);
            Singleton_client.saved=0;
        
         }else{
            admin=null;
            Singleton_client.saved=1;
        }
        clientavatar=false;
        return admin;
        
    }
    
    public static void fillClientMod(Client_class cli){
        String dni2="";
        int position=0;
        Date dateBirth = new Date();
        Date dateCont = new Date();
        Date_class birth=null;
        Calendar calendarBirth = Calendar.getInstance();
        Date_class cont=null;
        Calendar calendarCont = Calendar.getInstance();
        String file="";
//        Admin_class admin=((Admin_class) adm);
        
//        Admin_class admin = new Admin_class(dni);
//        position=BLL_admin.searchadminMod((Admin_class) admin);
//        
//        admin=Singleton_admin.adm.get(position);
        
        
//        System.out.println(admin.getDni());
        Modify_admin.fieldDNI.setText(cli.getDni());
        Modify_admin.editfieldName.setText(cli.getName());
        Modify_admin.editfieldSurname.setText(cli.getSurname());
        Modify_admin.editfieldEmail.setText(cli.getEmail());
        Modify_admin.editfieldMobile.setText( cli.getMobile());
        Modify_admin.editfieldUser.setText(cli.getUser());
        Modify_admin.editfieldPassword.setText(cli.getPass());
        Modify_admin.editfieldPassword2.setText(cli.getPass());
        Modify_admin.editfieldActivity.setText(String.valueOf(cli.getActivity()));
        file=cli.getAvatar();
        birth=cli.getBirthday();
        
        Modify_admin.avatar.setIcon(new ImageIcon(file));
        ImageIcon icon = new ImageIcon(file);
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        Modify_admin.avatar.setIcon(newIcon);
        Modify_admin.avatar.setSize(100,100);
        Modify_admin.avatar.setToolTipText(file);
        
        cont=cli.getCont_date();
        
        if(cli.isState()==true){
            Modify_admin.radioStateYes.setSelected(true);
        }else{
            Modify_admin.radioStateNo.setSelected(true);
        }
        
        BLL_admin.modAdmindata("activity");
        BLL_admin.modAdmindata("dni");
        BLL_admin.modAdmindata("email");
        BLL_admin.modAdmindata("mobile");
        BLL_admin.modAdmindata("name");
        BLL_admin.modAdmindata("password");
        BLL_admin.modAdmindata("password2");
        BLL_admin.modAdmindata("surname");
        BLL_admin.modAdmindata("user");
        

        
        calendarBirth.set(birth.getYear() , birth.getMonth()-1 , birth.getDay());
        dateBirth.setTime(calendarBirth.getTimeInMillis());
        Modify_admin.editdateBirth.setDate(dateBirth);

        
        calendarCont.set(cont.getYear() , cont.getMonth()-1 , cont.getDay());
        dateCont.setTime(calendarCont.getTimeInMillis());
        Modify_admin.editdateContract.setDate(dateCont);
       
        BLL_admin.modAdmindata("birthdate");
        BLL_admin.modAdmindata("datecontract");
        
    }
    
}//End public class DAO_client
