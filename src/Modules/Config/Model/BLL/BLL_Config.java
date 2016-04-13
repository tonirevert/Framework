/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Config.Model.BLL;

import Modules.Config.Model.Utils.Files_lib.Funct_files_config;
import Modules.Config.Model.DAO.DAO_Config;

/**
 *Class to use the save, load and reset functions from DAO
 * @author antonio
 */
public class BLL_Config {
    
    /**
     * Uses the reset configuration from DAO Config
     */
    public static void reset(){
        DAO_Config.resetConfig();
    }
    
    /**
     * Uses the save configuration from DAO Config
     */
    public static void save(){
        DAO_Config.saveConfig();
        Funct_files_config.autosavejsonconfig();
    }
    
    /**
     * Uses the load configuration from DAO Config
     */
    public static void load(){
        DAO_Config.loadConfig();
    }
}
