/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodi0878
 */
public class Storage {
    
    public void store(Object object) {
        File storage = new File("./storage");
        storage.mkdir();
        
        File classfolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        classfolder.mkdir();
        
        File objectfile = new File(classfolder + "/" + object.hashCode());
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(objectfile));
        } catch (IOException ex) {
        }
        try {
            oos.writeObject(object);
        } catch (IOException ex) {
        }
        try {
            oos.close();
        } catch (IOException ex) {
        }
    }
    
    public void unstore(Object object) {
        File storage = new File("./storage");
        
        File classfolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        
        File objectfile = new File(classfolder + "/" + object.hashCode());
        objectfile.delete();
    }
    
    public <T> List<T> load(Class<T> clazz) {
        File storage = new File("./storage");
        File classfolder = new File(storage.getAbsolutePath() + "/" + clazz.getName());
        
        List<T> list = new ArrayList<>();
        File[] files = classfolder.listFiles();
        
        for (File file : files) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException ex) {
            }
            try {
                list.add((T) ois.readObject());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
            }
            try {
                ois.close();
            } catch (IOException ex) {
            }
        }
        
        return list;
    }
    
}
