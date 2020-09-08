package com.blanchard.ovobio.tracoeuf.configuration;

import com.blanchard.ovobio.tracoeuf.constantes.ConstExt;

import java.util.Properties;

/**
 * class de gestion des constantes présentes dans le fichier constantes.properties
 */
public class Configurations {
    private Properties properties;
    private static Configurations instance = null;

    /**
     * private constructor
     */
    private Configurations(){
        this.properties = new Properties();
        try{
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(ConstExt.RESOURCE));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * création d'instance pour éviter probleme de multi-thread
     */
    private synchronized static void createInstance(){
        if (instance == null){
            instance = new Configurations();
        }
    }

    /**
     * get properties instance. uses singleton pattern
     */
    public  static Configurations getInstance(){
        if (instance==null){
            createInstance();
        }
        return instance;
    }

    /**
     * get property from file
     */
    public String getProperty(String key){
        String result = null;
        if (key != null && !key.trim().isEmpty()){
            result = this.properties.getProperty(key);
        }
        return result;
    }

    /**
     * Override clone method for "unique instance" requirement
     */
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}
