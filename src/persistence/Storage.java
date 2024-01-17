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

/**
 *
 * @author rodi0878
 */
public class Storage {
    
    private final File storage = new File("./storage");
    
    /**
     * Stores the provided object into a file based on its class name.
     * 
     * @param object The object to be stored.
     */
    public void store(Object object) {
        storage.mkdir();
        
        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        classFolder.mkdir();
        
        File objectFile = new File(classFolder + "/" + object.hashCode());
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException ex) {
        }
    }
    
    /**
     * Removes the stored file associated with the provided object.
     * 
     * @param object The object to be removed from storage.
     */
    public void unstore(Object object) {
        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        
        File objectfile = new File(classFolder + "/" + object.hashCode());
        objectfile.delete();
    }
    
     /**
     * Loads and returns a list of objects of a specified class from storage.
     * 
     * @param clazz The class type of objects to load.
     * @return A list of loaded objects.
     */
    public <T> List<T> load(Class<T> clazz) {
        File classFolder = new File(storage.getAbsolutePath() + "/" + clazz.getName());
        
        List<T> list = new ArrayList<>();
        File[] files = classFolder.listFiles();
        
        for (File file : files) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                list.add((T) ois.readObject());
                ois.close();
            } catch (IOException | ClassNotFoundException ex) {
            }

        }
        
        return list;
    }
    
}
