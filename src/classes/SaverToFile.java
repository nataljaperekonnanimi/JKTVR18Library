/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * @author Melnikov
 */
public class SaverToFile {
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null; //objortka nad baitami i zapisyvajet projekty
    FileInputStream fileInputStream = null;
    ObjectInputStream objectInputStream = null;
    
    public void saveBooks(List<Book> listBooks){
        try {
            fos = new FileOutputStream("Books.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listBooks);
            oos.flush();  //zapis v fail
            
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        }finally {
            try {
                oos.close();
                fos.close();
                
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
                //Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void saveReaders(List<Reader> listReaders){
        //v try vsjo vypolnjaetsja do pervoj oshibki
        try {
            fos = new FileOutputStream("Readers.txt");
            oos = new ObjectOutputStream(fos); // sohranjaet objekty
            oos.writeObject(listReaders); //osushestvljajet podgotovku sohranenija faila (k nemu dostupa mozhet ne byt, hotja fail sohranen)
            oos.flush();  //fizi4eskaja zapis v fail Readers.txt
            
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
            //finally vypolnjaetsja v ljubom slu4je. Nuzhen dlja osvobozhdenija resursov, pamjati (zanjatoj programmoj).
        }finally {
            try {
                oos.close();
                fos.close();              
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
                //Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
    public void saveHistories(List<History> listHistories){
        try {
            fos = new FileOutputStream("History.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listHistories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        }finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        } 
    }
    
    public List<Book> loadListBooks() {
        List<Book> listBooks = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("Books.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listBooks =(List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex);
        } catch (IOException ex) {
            System.out.println("Файл не прочитан. Ошибка: "+ ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс: "+ ex);
        } finally {
            try {
               if(fileInputStream != null){
                  fileInputStream.close();
               }
               if(objectInputStream !=null){
                  objectInputStream.close();
               }
            } catch (IOException ex) {
               System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
        return listBooks;
  
    }
    //dlja s4ityvanija zapisannoj informacii
    public List<Reader> loadListReaders(){
        List<Reader> listReaders = new ArrayList<>();
        try {           
            fileInputStream = new FileInputStream("Readers.txt");
            objectInputStream = new ObjectInputStream(fileInputStream); //sozdajom objectInputStream i svjazyvejem s fileInputStream. S4itavaet i sozdajot s4itannyj objekt.  
            listReaders = (List<Reader>)objectInputStream.readObject(); // s4ityvajem. Preobrazovyvaet i pomeshajet v objekt listReaders
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex); // srabotajet, jesli fail ne najden
        } catch(IOException ex){
            System.out.println("Файл не прочитан. Ошибка: "+ ex); 
        } catch(ClassNotFoundException ex){
            System.out.println("Не найден класс: "+ex);
            //fibally proizojdjot v ljubom slu4aje i vysvobozhdajem pamjat (resursy)
        } finally{
            try{
                if(fileInputStream !=null){
                    fileInputStream.close();
                }
            } catch(IOException ex){
                System.out.println("Ресурсы освободить не удалось: "+ ex);
            }
        } 
        
        return listReaders;
    }
    
    
    public List<History> loadListHistories(){
        List<History> listHistories = new ArrayList<>();
        try {           
            fileInputStream = new FileInputStream("History.txt");
            objectInputStream = new ObjectInputStream(fileInputStream); //sozdajom objectInputStream i svjazyvejem s fileInputStream. S4itavaet i sozdajot s4itannyj objekt.  
            listHistories = (List<History>)objectInputStream.readObject(); // s4ityvajem. Preobrazovyvaet i pomeshajet v objekt listHistories
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex); // srabotajet, jesli fail ne najden
        } catch(IOException ex){
            System.out.println("Файл не прочитан. Ошибка: "+ ex); 
        } catch(ClassNotFoundException ex){
            System.out.println("Не найден класс: "+ex);
            //fibally proizojdjot v ljubom slu4aje i vysvobozhdajem pamjat (resursy)
        } finally{
            try{
                if(fileInputStream !=null){
                    fileInputStream.close();
                }
                if(objectInputStream !=null){
                  objectInputStream.close();
               }
            } catch(IOException ex){
                System.out.println("Ресурсы освободить не удалось: "+ ex);
            }
        } 
        return listHistories;
    }
}
