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
    
    public void store(Object object) {
        File storage = new File("./storage");
        storage.mkdir();
        
        File classfolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        classfolder.mkdir();
        
        File objectfile = new File(classfolder + "/" + object.hashCode());
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectfile));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException ex) {
        }
    }
    
    public void unstore(Object object) {
        File storage = new File("./storage");
        
        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        
        File objectfile = new File(classFolder + "/" + object.hashCode());
        objectfile.delete();
    }
    
    public <T> List<T> load(Class<T> clazz) {
        File storage = new File("./storage");
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
