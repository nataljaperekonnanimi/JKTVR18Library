/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author melnikov
 */
public class ReaderProvider {
    
    public Reader createReader(){
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Запись читателя в библиотеку -------");
        System.out.println("Имя читателя: ");
        reader.setName(scanner.nextLine());
        System.out.println("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("День рождения: ");
        reader.setDay(new Integer(scanner.nextLine()));
        System.out.println("Месяц рождения: ");
        reader.setMonth(new Integer(scanner.nextLine()));
        System.out.println("Год рождения: ");
        reader.setYear(new Integer(scanner.nextLine()));
        return reader;
    }
}
