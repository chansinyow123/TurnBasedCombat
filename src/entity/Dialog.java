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
import javax.swing.JOptionPane;

/**
 *
 * @author ChaiZhiYing
 */
public class Dialog implements Serializable {

    private String dialog;
    private String talker;

    public Dialog(String dialog, String talker) {
        this.dialog = dialog;
        this.talker = talker;
    }

    public String getDialog() {
        return dialog;
    }

    public String getTalker() {
        return talker;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public static void saveToDialogFile(ArrayList<Dialog> dialogList) {
        try {
            FileOutputStream file = new FileOutputStream("Dialog.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < dialogList.size(); i++) {
                outputFile.writeObject(dialogList.get(i));
            }

            outputFile.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }

    public static void getFromDialogFile(ArrayList<Dialog> dialogList) {
        try {
            FileInputStream file = new FileInputStream("Dialog.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    dialogList.add((Dialog) inputFile.readObject());
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

}
