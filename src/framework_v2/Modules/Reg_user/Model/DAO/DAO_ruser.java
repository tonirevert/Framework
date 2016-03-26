/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Reg_user.Model.DAO;

import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Classes.Date_class;
import framework_v2.Modules.Reg_user.Model.BLL.BLL_ruser;
import framework_v2.Modules.Reg_user.Model.Classes.Reg_user_class;
import framework_v2.Modules.Reg_user.Model.Classes.Singleton_ruser;
import static framework_v2.Modules.Reg_user.Model.Classes.Singleton_ruser.*;
import  framework_v2.Modules.Reg_user.View.Create_ruser;
import static framework_v2.Modules.Reg_user.View.Create_ruser.*;
import framework_v2.Modules.Reg_user.View.Modify_ruser;

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
public class DAO_ruser {
    
    public static boolean askDni(){
        boolean correct =false;
//        System.out.println(BLL_admin.searchDniruser());
        if(BLL_ruser.searchDniruser()!=-1){
        if(Create_ruser.fieldDNI.getText().equals("")){
            Create_ruser.fieldDNI.setBackground(Color.yellow);
            Create_ruser.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Create_ruser.fieldDNI.getText())==true){
            Create_ruser.fieldDNI.setBackground(Color.green);
            Create_ruser.checkDNI.setIcon(ok);
            correct = true;
        }
        }else if(BLL_ruser.searchDniruser()==-1){
            Create_ruser.fieldDNI.setBackground(Color.orange);
            Create_ruser.checkDNI.setIcon(exclamation);
            correct=false;
            Create_ruser.areaInfo.setText("ID Card already exists in database");
            Create_ruser.areaInfo.setBackground(Color.orange);
        }
        return correct;
    }
    
    public static void askDniClick(){
         if(Validate.validateDNI(Create_ruser.fieldDNI.getText())==false){
            Create_ruser.fieldDNI.setText("");
        }
    }
    
    public static boolean askName(){
        boolean correct=false;
        
        if(Create_ruser.fieldName.getText().equals("")){
            Create_ruser.fieldName.setBackground(Color.yellow);
            Create_ruser.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Create_ruser.fieldName.getText())==false){
                Create_ruser.fieldName.setBackground(Color.yellow);
                Create_ruser.checkName.setIcon(no_ok);
                correct=false;
                }
                else if(Validate.valname(Create_ruser.fieldName.getText())==true){
                Create_ruser.fieldName.setBackground(Color.green);
                Create_ruser.checkName.setIcon(ok);
                correct=true;
                }
        }
        
        return correct;
    }
    
    public static boolean askSurname(){
        boolean correct=false;
        if(Create_ruser.fieldSurname.getText().equals("")){
            Create_ruser.fieldSurname.setBackground(Color.yellow);
            Create_ruser.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Create_ruser.fieldSurname.getText())==false){
            Create_ruser.fieldSurname.setBackground(Color.yellow);
            Create_ruser.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Create_ruser.fieldSurname.getText())==true){
                Create_ruser.fieldSurname.setBackground(Color.green);
                Create_ruser.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askEmail(){
        boolean correct=false;
        
        if(Create_ruser.fieldEmail.getText().equals("")){
            Create_ruser.fieldEmail.setBackground(Color.yellow);
            Create_ruser.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Create_ruser.fieldEmail.getText())==false){
            Create_ruser.fieldEmail.setBackground(Color.yellow);
            Create_ruser.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Create_ruser.fieldEmail.getText())==true){
                Create_ruser.fieldEmail.setBackground(Color.green);
                Create_ruser.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askMobile(){
        boolean correct=false;
        if(Create_ruser.fieldMobile.getText().equals("")){
            Create_ruser.fieldMobile.setBackground(Color.yellow);
            Create_ruser.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Create_ruser.fieldMobile.getText())==false){
                Create_ruser.fieldMobile.setBackground(Color.yellow);
                Create_ruser.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Create_ruser.fieldMobile.getText())==true){
                Create_ruser.fieldMobile.setBackground(Color.green);
                Create_ruser.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }

    public static boolean askUser(){
        boolean correct=false;
        
        if(Create_ruser.fieldUser.getText().equals("")){
                Create_ruser.fieldUser.setBackground(Color.yellow);
                Create_ruser.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Create_ruser.fieldUser.getText())==false){
                Create_ruser.fieldUser.setBackground(Color.yellow);
                Create_ruser.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Create_ruser.fieldUser.getText())==true){
                Create_ruser.fieldUser.setBackground(Color.green);
                Create_ruser.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPassword(){
        boolean correct=false;
        
         if(Validate.valpass(Create_ruser.fieldPassword.getText())==false){
            Create_ruser.fieldPassword.setBackground(Color.yellow);
            Create_ruser.checkPassword.setIcon(no_ok);
            correct=false;
        }
        else if(Validate.valpass(Create_ruser.fieldPassword.getText())==true){
            Create_ruser.fieldPassword.setBackground(Color.green);
            Create_ruser.checkPassword.setIcon(ok);
            correct=true;
        }
         return correct;
    }
    
    public static boolean askPassword2(){
        boolean correct=false;
        
        if(Create_ruser.fieldPassword.getText().equals(Create_ruser.fieldPassword2.getText()) && (Validate.valpass(Create_ruser.fieldPassword.getText())==true)){
                Create_ruser.fieldPassword2.setBackground(Color.green);
                Create_ruser.checkPassword2.setIcon(ok);
                correct=true;
        }else{
                Create_ruser.fieldPassword2.setBackground(Color.yellow);
                Create_ruser.checkPassword2.setIcon(no_ok);
                correct=false;
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

    public static boolean askActivity(){
        boolean correct=false;
        
        if(Create_ruser.fieldActivity.getText().equals("")){
            Create_ruser.fieldActivity.setBackground(Color.yellow);
            Create_ruser.checkActivity.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Create_ruser.fieldActivity.getText())==false){
                    Create_ruser.fieldActivity.setBackground(Color.yellow);
                    Create_ruser.checkActivity.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Create_ruser.fieldActivity.getText())==true){
                    Create_ruser.fieldActivity.setBackground(Color.green);
                    Create_ruser.checkActivity.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }
    
    public static boolean askBirth(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Create_ruser.dateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Create_ruser.dateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
//           System.out.println("years: "+years);
        if(years>=18){
            Create_ruser.checkDatebirth.setIcon(ok);
            correct=true;
        }else{
            Create_ruser.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Create_ruser.areaInfo.setText("No birth date selected");
            Create_ruser.checkDatebirth.setIcon(no_ok);
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

        if(ruseravatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvatarruser=file;
            Create_ruser.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Create_ruser.avatar.setIcon(newIcon);
            Create_ruser.avatar.setSize(100,100);
            Create_ruser.avatar.setToolTipText(file);
            ruseravatar=true;
            
        }else{
            ruseravatar=false;
            route=defaultavatar.toString();
        }
        }
//        System.out.println(route);
        return route;
    }
    
    public static void resetFields(){
        Create_ruser.fieldDNI.setText("");
        Create_ruser.fieldName.setText("");
        Create_ruser.fieldSurname.setText("");
        Create_ruser.fieldEmail.setText("");
        Create_ruser.fieldMobile.setText("");
        Create_ruser.fieldUser.setText("");
        Create_ruser.fieldPassword.setText("");
        Create_ruser.fieldPassword2.setText("");
        Create_ruser.fieldPassword2.setBackground(Color.yellow);
        Create_ruser.checkPassword2.setIcon(no_ok);
        Create_ruser.fieldActivity.setText("");
        Create_ruser.fieldDNI.removeAll();
        Create_ruser.fieldName.removeAll();
        Create_ruser.radioStateNo.setSelected(true);
        Create_ruser.areaInfo.setText("");
        Create_ruser.areaInfo.removeAll();
        Create_ruser.areaInfo.setBackground(Color.decode("#d6d6d6"));
        BLL_ruser.askRuserdata("dni");
        BLL_ruser.askRuserdata("name");
        BLL_ruser.askRuserdata("surname");
        BLL_ruser.askRuserdata("email");
        BLL_ruser.askRuserdata("mobile");
        BLL_ruser.askRuserdata("user");
        BLL_ruser.askRuserdata("password");
        BLL_ruser.askRuserdata("password2");
        BLL_ruser.askRuserdata("activity");
        Create_ruser.avatar.setIcon(defaultavatar);
        ruseravatar=false;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(YEAR);//Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = calendar.get(MONTH);//Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= calendar.get(DATE);//Calendar.getInstance().get(Calendar.DATE);
        calendar.set(currentYear , currentMonth-1 , currentDate);
        date.setTime(calendar.getTimeInMillis());
        Create_ruser.dateBirth.setDate(date);
    }//End reset fields
    
    public static Reg_user_class create(){
        Reg_user_class ruser;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="",karma="";
        int activity=0;
        Date_class birth;
        boolean connected=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fiavatar,fdbirth,factiv;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirth();
        fidni=askDni();
        finame=askName();
        fisurname=askSurname();
        fiemail=askEmail();
        fimobile=askMobile();
        fiuser=askUser();
        fipassword=askPassword();
        fipassword2=askPassword2();
        connected=askConnected();
        factiv=askActivity();
        
       
         if(fidni==true && finame==true && fisurname== true && fiemail==true &&fimobile==true && fiuser==true && fipassword==true &&
               fipassword2==true && fdbirth==true && factiv==true){
            dni=Create_ruser.fieldDNI.getText();
            name=Create_ruser.fieldName.getText();
            surname=Create_ruser.fieldSurname.getText();
            email=Create_ruser.fieldEmail.getText();
            mobile=Create_ruser.fieldMobile.getText();
            user=Create_ruser.fieldUser.getText();
            password=Create_ruser.fieldPassword.getText();
            activity=Integer.parseInt(Create_ruser.fieldActivity.getText());
            
            
            if(Create_ruser.radioStateYes.isSelected()){
                connected=true;
            }else if(Create_ruser.radioStateNo.isSelected()){
                connected=false;
            }
            
            birthdate=Create_ruser.dateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
            
            if(ruseravatar==true){
                try {
                    Files.copy(Paths.get(routeAvatarruser),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_ruser.class.getName()).log(Level.SEVERE, null, ex);
                }
                avatar=avatarsroute+dni;
            }else{
                avatar=defaultavatar.toString();
            }
            
            ruser=new Reg_user_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,activity,karma);
            ruseravatar=false;
        }else{
            ruser=null;
             ruseravatar=false;
        }
       
        return ruser;
        
    }//En create admin
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////                                                                EDIT ADMIN                                                                                     ////
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public static boolean askDniMod(){
        boolean correct =false;
        
        if(Modify_ruser.fieldDNI.getText().equals("")){
            Modify_ruser.fieldDNI.setBackground(Color.yellow);
            Modify_ruser.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Modify_ruser.fieldDNI.getText())==true){
            Modify_ruser.fieldDNI.setBackground(Color.green);
            Modify_ruser.checkDNI.setIcon(ok);
            correct = true;
        }
        
        return correct;
    }
    
    public static void askDniClickMod(){
         if(Validate.validateDNI(Modify_ruser.fieldDNI.getText())==false){
            Modify_ruser.fieldDNI.setText("");
        }
    }
    
   public static boolean askNameMod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldName.getText().equals("")){
            Modify_ruser.editfieldName.setBackground(Color.yellow);
            Modify_ruser.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Modify_ruser.editfieldName.getText())==false){
                Modify_ruser.editfieldName.setBackground(Color.yellow);
                Modify_ruser.checkName.setIcon(no_ok);
                correct=false;
            }
                else if(Validate.valname(Modify_ruser.editfieldName.getText())==true){
                Modify_ruser.editfieldName.setBackground(Color.green);
                Modify_ruser.checkName.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askSurnameMod(){
        boolean correct=false;
        if(Modify_ruser.editfieldSurname.getText().equals("")){
            Modify_ruser.editfieldSurname.setBackground(Color.yellow);
            Modify_ruser.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Modify_ruser.editfieldSurname.getText())==false){
            Modify_ruser.editfieldSurname.setBackground(Color.yellow);
            Modify_ruser.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Modify_ruser.editfieldSurname.getText())==true){
                Modify_ruser.editfieldSurname.setBackground(Color.green);
                Modify_ruser.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askEmailMod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldEmail.getText().equals("")){
            Modify_ruser.editfieldEmail.setBackground(Color.yellow);
            Modify_ruser.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Modify_ruser.editfieldEmail.getText())==false){
            Modify_ruser.editfieldEmail.setBackground(Color.yellow);
            Modify_ruser.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Modify_ruser.editfieldEmail.getText())==true){
                Modify_ruser.editfieldEmail.setBackground(Color.green);
                Modify_ruser.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askMobileMod(){
        boolean correct=false;
        if(Modify_ruser.editfieldMobile.getText().equals("")){
            Modify_ruser.editfieldMobile.setBackground(Color.yellow);
            Modify_ruser.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Modify_ruser.editfieldMobile.getText())==false){
                Modify_ruser.editfieldMobile.setBackground(Color.yellow);
                Modify_ruser.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Modify_ruser.editfieldMobile.getText())==true){
                Modify_ruser.editfieldMobile.setBackground(Color.green);
                Modify_ruser.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }
    
    public static boolean askUserMod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldUser.getText().equals("")){
                Modify_ruser.editfieldUser.setBackground(Color.yellow);
                Modify_ruser.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Modify_ruser.editfieldUser.getText())==false){
                Modify_ruser.editfieldUser.setBackground(Color.yellow);
                Modify_ruser.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Modify_ruser.editfieldUser.getText())==true){
                Modify_ruser.editfieldUser.setBackground(Color.green);
                Modify_ruser.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPasswordMod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldPassword.getText().equals("")){
            Modify_ruser.editfieldPassword.setBackground(Color.yellow);
            Modify_ruser.checkPassword.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valpass(Modify_ruser.editfieldPassword.getText())==false){
                Modify_ruser.editfieldPassword.setBackground(Color.yellow);
                Modify_ruser.checkPassword.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valpass(Modify_ruser.editfieldPassword.getText())==true){
                Modify_ruser.editfieldPassword.setBackground(Color.green);
                Modify_ruser.checkPassword.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPassword2Mod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldPassword.getText().equals(Modify_ruser.editfieldPassword2.getText()) && (Validate.valpass(Modify_ruser.editfieldPassword2.getText())==true)){
            Modify_ruser.editfieldPassword2.setBackground(Color.green);
            Modify_ruser.checkPassword2.setIcon(ok);
            correct=true;    
        }else{
            Modify_ruser.editfieldPassword2.setBackground(Color.yellow);
            Modify_ruser.checkPassword2.setIcon(no_ok);
            correct=false;
        }
        
        
        return correct;
    }
    
    public static boolean askConnectedMod(){
        boolean connected=false;
        if (Modify_ruser.radioStateYes.isSelected()){
            connected=true;
        }else if(Modify_ruser.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
    
    public static boolean askActivityMod(){
        boolean correct=false;
        
        if(Modify_ruser.editfieldActivity.getText().equals("")){
            Modify_ruser.editfieldActivity.setBackground(Color.yellow);
            Modify_ruser.checkActivity.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Modify_ruser.editfieldActivity.getText())==false){
                    Modify_ruser.editfieldActivity.setBackground(Color.yellow);
                    Modify_ruser.checkActivity.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Modify_ruser.editfieldActivity.getText())==true){
                    Modify_ruser.editfieldActivity.setBackground(Color.green);
                    Modify_ruser.checkActivity.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }
    
    public static boolean askBirthMod(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_ruser.editdateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Modify_ruser.editdateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
        if(years>=18){
            Modify_ruser.checkDatebirth.setIcon(ok);
            correct=true;
        }else{
            Modify_ruser.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Modify_ruser.editdateBirth.setBackground(Color.yellow);
            Modify_ruser.editareaInfo.setText("No birth date selected");
            Modify_ruser.checkDatebirth.setIcon(no_ok);
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

        if(ruseravatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvatarruser=file;//toString? con el funciona
            Modify_ruser.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Modify_ruser.avatar.setIcon(newIcon);
            Modify_ruser.avatar.setSize(100,100);
            Modify_ruser.avatar.setToolTipText(file);
            ruseravatar=true;
            
        }else{
            ruseravatar=false;
            route=defaultavatar.toString();
        }
        }
        return route;
    }
    
    public static Reg_user_class saveRuserMod(){
        Reg_user_class ruser;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="";
        int activity=0;
        Date_class birth;
        String karma="";
        boolean connected=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fdbirth,factiv;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();

        fdbirth=askBirthMod();
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
                fipassword2==true && fdbirth==true && factiv==true){
            dni=Modify_ruser.fieldDNI.getText();
            name=Modify_ruser.editfieldName.getText();
            surname=Modify_ruser.editfieldSurname.getText();
            email=Modify_ruser.editfieldEmail.getText();
            mobile=Modify_ruser.editfieldMobile.getText();
            user=Modify_ruser.editfieldUser.getText();
            password=Modify_ruser.editfieldPassword.getText();
            activity=Integer.parseInt(Modify_ruser.editfieldActivity.getText());
            
            if(ruseravatar==true){
                try {
                    Files.copy(Paths.get(routeAvatarruser),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_ruser.class.getName()).log(Level.SEVERE, null, ex);
                }
            avatar=avatarsroute+dni;
            }else{
                avatar=avatarMod;
            }
            
            birthdate=Modify_ruser.editdateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
          
            ruser=new Reg_user_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,activity,karma);
            Singleton_ruser.saved=0;
        
         }else{
            ruser=null;
            Singleton_ruser.saved=1;
        }
        ruseravatar=false;
        return ruser;
        
    }
    
    public static void fillRuserMod(Reg_user_class rus){
        Date dateBirth = new Date();
        Date_class birth=null;
        Calendar calendarBirth = Calendar.getInstance();
        String file="";

        Modify_ruser.fieldDNI.setText(rus.getDni());
        Modify_ruser.editfieldName.setText(rus.getName());
        Modify_ruser.editfieldSurname.setText(rus.getSurname());
        Modify_ruser.editfieldEmail.setText(rus.getEmail());
        Modify_ruser.editfieldMobile.setText( rus.getMobile());
        Modify_ruser.editfieldUser.setText(rus.getUser());
        Modify_ruser.editfieldPassword.setText(rus.getPass());
        Modify_ruser.editfieldPassword2.setText(rus.getPass());
        Modify_ruser.editfieldActivity.setText(String.valueOf(rus.getActivity()));
        file=rus.getAvatar();
        birth=rus.getBirthday();
        avatarMod=file;
        
        Modify_ruser.avatar.setIcon(new ImageIcon(file));
        ImageIcon icon = new ImageIcon(file);
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        Modify_ruser.avatar.setIcon(newIcon);
        Modify_ruser.avatar.setSize(100,100);
        Modify_ruser.avatar.setToolTipText(file);
        

        
        if(rus.isState()==true){
            Modify_ruser.radioStateYes.setSelected(true);
        }else{
            Modify_ruser.radioStateNo.setSelected(true);
        }
        
        calendarBirth.set(birth.getYear() , birth.getMonth()-1 , birth.getDay());
        dateBirth.setTime(calendarBirth.getTimeInMillis());
        Modify_ruser.editdateBirth.setDate(dateBirth);
        
        BLL_ruser.modRuserdata("activity");
        BLL_ruser.modRuserdata("dni");
        BLL_ruser.modRuserdata("email");
        BLL_ruser.modRuserdata("mobile");
        BLL_ruser.modRuserdata("name");
        BLL_ruser.modRuserdata("password");
        BLL_ruser.modRuserdata("password2");
        BLL_ruser.modRuserdata("surname");
        BLL_ruser.modRuserdata("user");
        BLL_ruser.modRuserdata("birthdate");
        
    }
    
}//End public class DAO_admin
