/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Config.BLL;

import framework_v2.Modules.Config.Utils.Files_lib.Funct_files_config;
import framework_v2.Modules.Config.DAO.DAO_Config;

/**
 *
 * @author antonio
 */
public class BLL_Config {
    
    public static void reset(){
        DAO_Config.resetConfig();
    }
    
    public static void save(){
        DAO_Config.saveConfig();
        Funct_files_config.autosavejsonconfig();
    }
    
    public static void load(){
        DAO_Config.loadConfig();
    }
}
