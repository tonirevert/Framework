/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.Model.DAO;

import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Classes.Date_class;
import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Admin.Model.Classes.Admin_class;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import static framework_v2.Modules.Admin.Model.Classes.Singleton_admin.*;
import  framework_v2.Modules.Admin.View.Create_admin;
import static framework_v2.Modules.Admin.View.Create_admin.*;
import framework_v2.Modules.Admin.View.Modify_admin;

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
public class DAO_admin {
    
    public static boolean askDni(){
        boolean correct =false;
//        System.out.println(BLL_admin.searchDniadmin());
        if(BLL_admin.searchDniadmin()!=-1){
        if(Create_admin.fieldDNI.getText().equals("")){
            Create_admin.fieldDNI.setBackground(Color.yellow);
            Create_admin.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Create_admin.fieldDNI.getText())==true){
            Create_admin.fieldDNI.setBackground(Color.green);
            Create_admin.checkDNI.setIcon(ok);
            correct = true;
        }
        }else if(BLL_admin.searchDniadmin()==-1){
            Create_admin.fieldDNI.setBackground(Color.orange);
            Create_admin.checkDNI.setIcon(exclamation);
            correct=false;
            Create_admin.areaInfo.setText("ID Card already exists in database");
            Create_admin.areaInfo.setBackground(Color.orange);
        }
        return correct;
    }
    
    public static void askDniClick(){
         if(Validate.validateDNI(Create_admin.fieldDNI.getText())==false){
            Create_admin.fieldDNI.setText("");
        }
    }
    
    public static boolean askName(){
        boolean correct=false;
        
        if(Create_admin.fieldName.getText().equals("")){
            Create_admin.fieldName.setBackground(Color.yellow);
            Create_admin.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Create_admin.fieldName.getText())==false){
                Create_admin.fieldName.setBackground(Color.yellow);
                Create_admin.checkName.setIcon(no_ok);
                correct=false;
                }
                else if(Validate.valname(Create_admin.fieldName.getText())==true){
                Create_admin.fieldName.setBackground(Color.green);
                Create_admin.checkName.setIcon(ok);
                correct=true;
                }
        }
        
        return correct;
    }
    
    public static boolean askSurname(){
        boolean correct=false;
        if(Create_admin.fieldSurname.getText().equals("")){
            Create_admin.fieldSurname.setBackground(Color.yellow);
            Create_admin.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Create_admin.fieldSurname.getText())==false){
            Create_admin.fieldSurname.setBackground(Color.yellow);
            Create_admin.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Create_admin.fieldSurname.getText())==true){
                Create_admin.fieldSurname.setBackground(Color.green);
                Create_admin.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askEmail(){
        boolean correct=false;
        
        if(Create_admin.fieldEmail.getText().equals("")){
            Create_admin.fieldEmail.setBackground(Color.yellow);
            Create_admin.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Create_admin.fieldEmail.getText())==false){
            Create_admin.fieldEmail.setBackground(Color.yellow);
            Create_admin.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Create_admin.fieldEmail.getText())==true){
                Create_admin.fieldEmail.setBackground(Color.green);
                Create_admin.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askMobile(){
        boolean correct=false;
        if(Create_admin.fieldMobile.getText().equals("")){
            Create_admin.fieldMobile.setBackground(Color.yellow);
            Create_admin.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Create_admin.fieldMobile.getText())==false){
                Create_admin.fieldMobile.setBackground(Color.yellow);
                Create_admin.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Create_admin.fieldMobile.getText())==true){
                Create_admin.fieldMobile.setBackground(Color.green);
                Create_admin.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }

    public static boolean askUser(){
        boolean correct=false;
        
        if(Create_admin.fieldUser.getText().equals("")){
                Create_admin.fieldUser.setBackground(Color.yellow);
                Create_admin.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Create_admin.fieldUser.getText())==false){
                Create_admin.fieldUser.setBackground(Color.yellow);
                Create_admin.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Create_admin.fieldUser.getText())==true){
                Create_admin.fieldUser.setBackground(Color.green);
                Create_admin.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPassword(){
        boolean correct=false;
        
         if(Validate.valpass(Create_admin.fieldPassword.getText())==false){
            Create_admin.fieldPassword.setBackground(Color.yellow);
            Create_admin.checkPassword.setIcon(no_ok);
            correct=false;
        }
        else if(Validate.valpass(Create_admin.fieldPassword.getText())==true){
            Create_admin.fieldPassword.setBackground(Color.green);
            Create_admin.checkPassword.setIcon(ok);
            correct=true;
        }
         return correct;
    }
    
    public static boolean askPassword2(){
        boolean correct=false;
        
        if(Create_admin.fieldPassword.getText().equals(Create_admin.fieldPassword2.getText()) && (Validate.valpass(Create_admin.fieldPassword.getText())==true)){
                Create_admin.fieldPassword2.setBackground(Color.green);
                Create_admin.checkPassword2.setIcon(ok);
                correct=true;
        }else{
                Create_admin.fieldPassword2.setBackground(Color.yellow);
                Create_admin.checkPassword2.setIcon(no_ok);
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
        
        if(Create_admin.fieldActivity.getText().equals("")){
            Create_admin.fieldActivity.setBackground(Color.yellow);
            Create_admin.checkActivity.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Create_admin.fieldActivity.getText())==false){
                    Create_admin.fieldActivity.setBackground(Color.yellow);
                    Create_admin.checkActivity.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Create_admin.fieldActivity.getText())==true){
                    Create_admin.fieldActivity.setBackground(Color.green);
                    Create_admin.checkActivity.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }

    public static boolean askBirth(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Create_admin.dateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Create_admin.dateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
//           System.out.println("years: "+years);
        if(years>=16){
            Create_admin.checkDatebirth.setIcon(ok);
            Create_admin.dateContract.setEnabled(true);
            Create_admin.dateContract.getDateEditor().setEnabled(false);
            correct=true;
        }else{
            Create_admin.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Create_admin.areaInfo.setText("No birth date selected");
            Create_admin.checkDatebirth.setIcon(no_ok);
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

        if(adminavatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvataradmin=file;
            Create_admin.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Create_admin.avatar.setIcon(newIcon);
            Create_admin.avatar.setSize(100,100);
            Create_admin.avatar.setToolTipText(file);
            adminavatar=true;
            
        }else{
            adminavatar=false;
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
        Create_admin.dateContract.setDateFormatString(dateform);
        Create_admin.dateBirth.setDateFormatString(dateform);
//        dateContract.getDateEditor().setEnabled(false);
       
        try{
        contract=Create_admin.dateContract.getCalendar();
        String c=contract.get(Calendar.DATE)+"/"+(contract.get(Calendar.MONTH)+1)+"/"+contract.get(Calendar.YEAR);
        Date_class cont= new Date_class(c);
        
        birthdate=Create_admin.dateBirth.getCalendar();
        String b=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(b);
        int comp_contract=cont.compare_birth_contract(birth, 16);
        
        switch (comp_contract) {
            case 2:
                if(cont.comp_today()==2){
                    Create_admin.checkDatecontract.setIcon(no_ok);
                    correct=false;
                }else{
                    Create_admin.checkDatecontract.setIcon(ok);
                    correct=true;
                }
                break;
            case 1:
                if(cont.comp_today()==2){
                    Create_admin.checkDatecontract.setIcon(no_ok);
                    correct=false;
                }else{
                    Create_admin.checkDatecontract.setIcon(ok);
                    correct=true;
                }
                break;
            case 0:
                Create_admin.checkDatecontract.setIcon(no_ok);
                correct=false;
                break;
        }
        }catch(Exception e){
            Create_admin.dateContract.setBackground(Color.yellow);
            Create_admin.areaInfo.setText("No contract date selected");
            Create_admin.checkDatecontract.setIcon(no_ok);
        }
        return correct;
    }
    
    public static void resetFields(){
        Create_admin.fieldDNI.setText("");
        Create_admin.fieldName.setText("");
        Create_admin.fieldSurname.setText("");
        Create_admin.fieldEmail.setText("");
        Create_admin.fieldMobile.setText("");
        Create_admin.fieldUser.setText("");
        Create_admin.fieldPassword.setText("");
        Create_admin.fieldPassword2.setText("");
        Create_admin.fieldPassword2.setBackground(Color.yellow);
        Create_admin.checkPassword2.setIcon(no_ok);
        Create_admin.fieldActivity.setText(" ");
        Create_admin.fieldDNI.removeAll();
        Create_admin.fieldName.removeAll();
        Create_admin.radioStateNo.setSelected(true);
        Create_admin.areaInfo.setText("");
        Create_admin.areaInfo.removeAll();
        Create_admin.areaInfo.setBackground(Color.decode("#d6d6d6"));
        BLL_admin.askAdmindata("dni");
        BLL_admin.askAdmindata("name");
        BLL_admin.askAdmindata("surname");
        BLL_admin.askAdmindata("email");
        BLL_admin.askAdmindata("mobile");
        BLL_admin.askAdmindata("user");
        BLL_admin.askAdmindata("password");
        BLL_admin.askAdmindata("password2");
        BLL_admin.askAdmindata("activity");
        Create_admin.avatar.setIcon(defaultavatar);
        adminavatar=false;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(YEAR);//Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = calendar.get(MONTH);//Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= calendar.get(DATE);//Calendar.getInstance().get(Calendar.DATE);
        calendar.set(currentYear , currentMonth-1 , currentDate);
        date.setTime(calendar.getTimeInMillis());
        Create_admin.dateBirth.setDate(date);
        Create_admin.dateContract.setDate(date);
    }//End reset fields
    
    public static Admin_class create(){
        Admin_class admin;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="";
        int activity=0;
        Date_class birth;
        Date_class contract;
        boolean connected=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fiavatar,fdbirth,fdcont,factiv;
        Calendar birthdate,datecontract;
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
        
        fiavatar=true;
        connected=askConnected();
        
        factiv=askActivity();
       
         if(fidni==true && finame==true && fisurname== true && fiemail==true &&fimobile==true && fiuser==true && fipassword==true &&
               fipassword2==true && fiavatar==true && fdbirth==true && fdcont==true && factiv==true){
            dni=Create_admin.fieldDNI.getText();
            name=Create_admin.fieldName.getText();
            surname=Create_admin.fieldSurname.getText();
            email=Create_admin.fieldEmail.getText();
            mobile=Create_admin.fieldMobile.getText();
            user=Create_admin.fieldUser.getText();
            password=Create_admin.fieldPassword.getText();
            activity=Integer.parseInt(Create_admin.fieldActivity.getText());
            
            
            
            if(Create_admin.radioStateYes.isSelected()){
                connected=true;
            }else if(Create_admin.radioStateNo.isSelected()){
                connected=false;
            }
            
            birthdate=Create_admin.dateBirth.getCalendar();
            String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
            birth= new Date_class(s);
            
            datecontract=Create_admin.dateContract.getCalendar();
            String c=datecontract.get(Calendar.DATE)+"/"+(datecontract.get(Calendar.MONTH)+1)+"/"+datecontract.get(Calendar.YEAR);
            contract=new Date_class(c);
          
            if(adminavatar==true){
                try {
                    Files.copy(Paths.get(routeAvataradmin),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                avatar=avatarsroute+dni;
            }else{
                avatar=defaultavatar.toString();
            }
            
            admin=new Admin_class(dni,name,surname,birth,mobile,email,user,password,avatar,connected,contract,activity);
            adminavatar=false;
        }else{
            admin=null;
             adminavatar=false;
        }
       
        return admin;
        
    }//En create admin
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////                                                                EDIT ADMIN                                                                                     ////
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public static boolean askDniMod(){
        boolean correct =false;
        
        if(Modify_admin.fieldDNI.getText().equals("")){
            Modify_admin.fieldDNI.setBackground(Color.yellow);
            Modify_admin.checkDNI.setIcon(no_ok);
            correct=false;
        }else if(Validate.validateDNI(Modify_admin.fieldDNI.getText())==true){
            Modify_admin.fieldDNI.setBackground(Color.green);
            Modify_admin.checkDNI.setIcon(ok);
            correct = true;
        }
        
        return correct;
    }
    
    public static void askDniClickMod(){
         if(Validate.validateDNI(Modify_admin.fieldDNI.getText())==false){
            Modify_admin.fieldDNI.setText("");
        }
    }
    
   public static boolean askNameMod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldName.getText().equals("")){
            Modify_admin.editfieldName.setBackground(Color.yellow);
            Modify_admin.checkName.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valname(Modify_admin.editfieldName.getText())==false){
                Modify_admin.editfieldName.setBackground(Color.yellow);
                Modify_admin.checkName.setIcon(no_ok);
                correct=false;
            }
                else if(Validate.valname(Modify_admin.editfieldName.getText())==true){
                Modify_admin.editfieldName.setBackground(Color.green);
                Modify_admin.checkName.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askSurnameMod(){
        boolean correct=false;
        if(Modify_admin.editfieldSurname.getText().equals("")){
            Modify_admin.editfieldSurname.setBackground(Color.yellow);
            Modify_admin.checkSurname.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valname(Modify_admin.editfieldSurname.getText())==false){
            Modify_admin.editfieldSurname.setBackground(Color.yellow);
            Modify_admin.checkSurname.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valname(Modify_admin.editfieldSurname.getText())==true){
                Modify_admin.editfieldSurname.setBackground(Color.green);
                Modify_admin.checkSurname.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askEmailMod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldEmail.getText().equals("")){
            Modify_admin.editfieldEmail.setBackground(Color.yellow);
            Modify_admin.checkEmail.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valemail(Modify_admin.editfieldEmail.getText())==false){
            Modify_admin.editfieldEmail.setBackground(Color.yellow);
            Modify_admin.checkEmail.setIcon(no_ok);
            correct=false;
            }
            else if(Validate.valemail(Modify_admin.editfieldEmail.getText())==true){
                Modify_admin.editfieldEmail.setBackground(Color.green);
                Modify_admin.checkEmail.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askMobileMod(){
        boolean correct=false;
        if(Modify_admin.editfieldMobile.getText().equals("")){
            Modify_admin.editfieldMobile.setBackground(Color.yellow);
            Modify_admin.checkMobile.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valmobile(Modify_admin.editfieldMobile.getText())==false){
                Modify_admin.editfieldMobile.setBackground(Color.yellow);
                Modify_admin.checkMobile.setIcon(no_ok);
                correct=false  ;
        }else if(Validate.valmobile(Modify_admin.editfieldMobile.getText())==true){
                Modify_admin.editfieldMobile.setBackground(Color.green);
                Modify_admin.checkMobile.setIcon(ok);
                correct=true;
        }
        }
        
        return correct;
    }
    
    public static boolean askUserMod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldUser.getText().equals("")){
                Modify_admin.editfieldUser.setBackground(Color.yellow);
                Modify_admin.checkUser.setIcon(no_ok);
                correct=false;
        }else{
            if(Validate.valuser(Modify_admin.editfieldUser.getText())==false){
                Modify_admin.editfieldUser.setBackground(Color.yellow);
                Modify_admin.checkUser.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valuser(Modify_admin.editfieldUser.getText())==true){
                Modify_admin.editfieldUser.setBackground(Color.green);
                Modify_admin.checkUser.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPasswordMod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldPassword.getText().equals("")){
            Modify_admin.editfieldPassword.setBackground(Color.yellow);
            Modify_admin.checkPassword.setIcon(no_ok);
            correct=false;
        }else{
            if(Validate.valpass(Modify_admin.editfieldPassword.getText())==false){
                Modify_admin.editfieldPassword.setBackground(Color.yellow);
                Modify_admin.checkPassword.setIcon(no_ok);
                correct=false;
            }
            else if(Validate.valpass(Modify_admin.editfieldPassword.getText())==true){
                Modify_admin.editfieldPassword.setBackground(Color.green);
                Modify_admin.checkPassword.setIcon(ok);
                correct=true;
            }
        }
        
        return correct;
    }
    
    public static boolean askPassword2Mod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldPassword.getText().equals(Modify_admin.editfieldPassword2.getText()) && (Validate.valpass(Modify_admin.editfieldPassword2.getText())==true)){
            Modify_admin.editfieldPassword2.setBackground(Color.green);
            Modify_admin.checkPassword2.setIcon(ok);
            correct=true;    
        }else{
            Modify_admin.editfieldPassword2.setBackground(Color.yellow);
            Modify_admin.checkPassword2.setIcon(no_ok);
            correct=false;
        }
        
        
        return correct;
    }
    
    public static boolean askConnectedMod(){
        boolean connected=false;
        if (Modify_admin.radioStateYes.isSelected()){
            connected=true;
        }else if(Modify_admin.radioStateNo.isSelected()){
            connected=false;
        }
            
            return connected;
    }
    
    public static boolean askActivityMod(){
        boolean correct=false;
        
        if(Modify_admin.editfieldActivity.getText().equals("")){
            Modify_admin.editfieldActivity.setBackground(Color.yellow);
            Modify_admin.checkActivity.setIcon(no_ok);
            correct=false;
        }else{
                if(Validate.valactivity(Modify_admin.editfieldActivity.getText())==false){
                    Modify_admin.editfieldActivity.setBackground(Color.yellow);
                    Modify_admin.checkActivity.setIcon(no_ok);
                    correct=false;
                }
                else if(Validate.valactivity(Modify_admin.editfieldActivity.getText())==true){
                    Modify_admin.editfieldActivity.setBackground(Color.green);
                    Modify_admin.checkActivity.setIcon(ok);
                    correct=true;
                }
        }
        
        return correct;
    }
    
    public static boolean askBirthMod(){
        boolean correct=false;
        Calendar birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_admin.editdateBirth.setDateFormatString(dateform);
//        dateBirth.getDateEditor().setEnabled(false);
       try{
        birthdate=Modify_admin.editdateBirth.getCalendar();
        String s=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(s);
        int years=birth.intyearstoday();
        if(years>=16){
            Modify_admin.checkDatebirth.setIcon(ok);
            correct=true;
        }else{
            Modify_admin.checkDatebirth.setIcon(no_ok);
            correct=false;
        }
       }catch(Exception e){
            Modify_admin.editdateBirth.setBackground(Color.yellow);
            Modify_admin.editareaInfo.setText("No birth date selected");
            Modify_admin.checkDatebirth.setIcon(no_ok);
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

        if(adminavatar==false){
        int option = dialog.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            file=dialog.getSelectedFile().getPath();
            routeAvataradmin=file;//toString? con el funciona
            Modify_admin.avatar.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            Modify_admin.avatar.setIcon(newIcon);
            Modify_admin.avatar.setSize(100,100);
            Modify_admin.avatar.setToolTipText(file);
            adminavatar=true;
            
        }else{
            adminavatar=false;
            route=defaultavatar.toString();
        }
        }
        return route;
    }
    
    public static boolean askDatecontractMod(){
        boolean correct=false;
        Calendar contract,birthdate;
        String dateform=Config_class.getinstance().getDate_format();
        Modify_admin.editdateContract.setDateFormatString(dateform);
        Modify_admin.editdateBirth.setDateFormatString(dateform);
        Modify_admin.editdateContract.getDateEditor().setEnabled(false);
       
        try{
        contract=Modify_admin.editdateContract.getCalendar();
        String c=contract.get(Calendar.DATE)+"/"+(contract.get(Calendar.MONTH)+1)+"/"+contract.get(Calendar.YEAR);
        Date_class cont= new Date_class(c);
        
        birthdate=Modify_admin.editdateBirth.getCalendar();
        String b=birthdate.get(Calendar.DATE)+"/"+(birthdate.get(Calendar.MONTH)+1)+"/"+birthdate.get(Calendar.YEAR);
        Date_class birth= new Date_class(b);
        int comp_contract=cont.compare_birth_contract(birth, 16);
        
        switch (comp_contract) {
            case 2:
                Modify_admin.checkDatecontract.setIcon(ok);
//                datetype=1;
                correct=true;
                break;
            case 1:
                Modify_admin.checkDatecontract.setIcon(ok);
//                datetype=1;
                correct=true;
                break;
            case 0:
                Modify_admin.checkDatecontract.setIcon(no_ok);
//                datetype=0;
                correct=false;
                break;
        }
        }catch(Exception e){
            Modify_admin.editdateContract.setBackground(Color.yellow);
            Modify_admin.editareaInfo.setText("No contract date selected");
            Modify_admin.checkDatecontract.setIcon(no_ok);
        }
        return correct;
    }
    
    public static void resetFieldsMod(){
        Modify_admin.fieldDNI.setText("");
        Modify_admin.editfieldName.setText("");
        Modify_admin.editfieldSurname.setText("");
        Modify_admin.editfieldEmail.setText("");
        Modify_admin.editfieldMobile.setText("");
        Modify_admin.editfieldUser.setText("");
        Modify_admin.editfieldPassword.setText("");
        Modify_admin.editfieldPassword2.setText("");
        Modify_admin.editfieldPassword2.setBackground(Color.yellow);
        Modify_admin.checkPassword2.setIcon(no_ok);
        Modify_admin.editfieldActivity.setText(" ");
        Modify_admin.fieldDNI.removeAll();
        Modify_admin.editfieldName.removeAll();
        BLL_admin.modAdmindata("activity");
        BLL_admin.modAdmindata("dni");
        BLL_admin.modAdmindata("email");
        BLL_admin.modAdmindata("mobile");
        BLL_admin.modAdmindata("name");
        BLL_admin.modAdmindata("password");
        BLL_admin.modAdmindata("surname");
        BLL_admin.modAdmindata("user");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(YEAR);//Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = calendar.get(MONTH);//Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= calendar.get(DATE);//Calendar.getInstance().get(Calendar.DATE);
        calendar.set(currentYear , currentMonth-1 , currentDate);
        date.setTime(calendar.getTimeInMillis());
        Modify_admin.editdateBirth.setDate(date);
        Modify_admin.editdateContract.setDate(date);
    }
    
    public static Admin_class saveAdminMod(){
        Admin_class admin;
        String dni="", name="", surname="", email="", mobile="", user="", password="", avatar="";
        int activity=0;
        Date_class birth;
        Date_class contract;
        boolean connected=false;
        boolean fidni,finame,fisurname,fiemail,fimobile,fiuser,fipassword,fipassword2,fdbirth,fdcont,factiv;
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
            
            if(adminavatar==true){
                try {
                    Files.copy(Paths.get(routeAvataradmin),Paths.get(avatarsroute+dni) , REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE, null, ex);
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
            Singleton_admin.saved=0;
        
         }else{
            admin=null;
            Singleton_admin.saved=1;
        }
        adminavatar=false;
        return admin;
        
    }
    
    public static void fillAdminMod(Admin_class adm){
        Date dateBirth = new Date();
        Date dateCont = new Date();
        Date_class birth=null;
        Calendar calendarBirth = Calendar.getInstance();
        Date_class cont=null;
        Calendar calendarCont = Calendar.getInstance();
        String file="";

        Modify_admin.fieldDNI.setText(adm.getDni());
        Modify_admin.editfieldName.setText(adm.getName());
        Modify_admin.editfieldSurname.setText(adm.getSurname());
        Modify_admin.editfieldEmail.setText(adm.getEmail());
        Modify_admin.editfieldMobile.setText( adm.getMobile());
        Modify_admin.editfieldUser.setText(adm.getUser());
        Modify_admin.editfieldPassword.setText(adm.getPass());
        Modify_admin.editfieldPassword2.setText(adm.getPass());
        Modify_admin.editfieldActivity.setText(String.valueOf(adm.getActivity()));
        file=adm.getAvatar();
        birth=adm.getBirthday();
        
        Modify_admin.avatar.setIcon(new ImageIcon(file));
        ImageIcon icon = new ImageIcon(file);
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        Modify_admin.avatar.setIcon(newIcon);
        Modify_admin.avatar.setSize(100,100);
        Modify_admin.avatar.setToolTipText(file);
        
        cont=adm.getCont_date();
        
        if(adm.isState()==true){
            Modify_admin.radioStateYes.setSelected(true);
        }else{
            Modify_admin.radioStateNo.setSelected(true);
        }
        
        calendarBirth.set(birth.getYear() , birth.getMonth()-1 , birth.getDay());
        dateBirth.setTime(calendarBirth.getTimeInMillis());
        Modify_admin.editdateBirth.setDate(dateBirth);

        
        calendarCont.set(cont.getYear() , cont.getMonth()-1 , cont.getDay());
        dateCont.setTime(calendarCont.getTimeInMillis());
        Modify_admin.editdateContract.setDate(dateCont);
        
        BLL_admin.modAdmindata("activity");
        BLL_admin.modAdmindata("dni");
        BLL_admin.modAdmindata("email");
        BLL_admin.modAdmindata("mobile");
        BLL_admin.modAdmindata("name");
        BLL_admin.modAdmindata("password");
        BLL_admin.modAdmindata("password2");
        BLL_admin.modAdmindata("surname");
        BLL_admin.modAdmindata("user");
        BLL_admin.modAdmindata("birthdate");
        BLL_admin.modAdmindata("datecontract");
        
    }
    
}//End public class DAO_admin
