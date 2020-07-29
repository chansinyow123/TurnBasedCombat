/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import ADT.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import javax.swing.JOptionPane;
import ADT.ArrayList;
import ADT.HashSet;
/**
 *
 * @author chans
 */
public class Account implements Serializable{
    private String username;
    private char[] password;
    
    public Account(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public char[] getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    
    public static void getFromAccountFile(ArrayList<Account> accountList) {
        try {
            FileInputStream file = new FileInputStream("Account.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    accountList.add((Account) inputFile.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            inputFile.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void saveToAccountFile(ArrayList<Account> accountList) {
        try {
            FileOutputStream file = new FileOutputStream("Account.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0; i < accountList.size(); i++) {
                outputFile.writeObject(accountList.get(i));
            }
            
            outputFile.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static Account login(ArrayList<Account> accountList, String username, char[] password) {
        
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(username) && Arrays.equals(password, accountList.get(i).getPassword())) {
                return accountList.get(i);
            }
        }
        
        return null;
    }
    
    public static boolean accountExist(ArrayList<Account> accountList, String username) {
        
        HashSet<String> hashSet = new HashSet();
        hashSet.add(username);
        String accountUsername;
        
        for (int i = 0; i < accountList.size(); i++) {
            
            accountUsername = accountList.get(i).getUsername();
            
            if (!hashSet.add(accountUsername)) {
                return true;
            }
            
            /*
            if (accountList.get(i).getUsername().equals(username)) {
                return true;
            }
            */
        }
        
        return false;
    }
}
