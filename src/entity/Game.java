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
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import ADT.ArrayList;
import entity.Account;

/**
 *
 * @author chans
 */
public class Game implements Serializable{

    private int roundOne;
    private int roundTwo;
    private int roundThree;
    private Account account;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Game(Account account) {
        this.account = account;
        this.startTime = LocalDateTime.now();
        roundOne = 0;
        roundTwo = 0;
        roundThree = 0;
    }

    public int getRoundOne() {
        return roundOne;
    }

    public int getRoundTwo() {
        return roundTwo;
    }

    public int getRoundThree() {
        return roundThree;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setRoundOne(int roundOne) {
        this.roundOne = roundOne;
    }

    public void setRoundTwo(int roundTwo) {
        this.roundTwo = roundTwo;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setRoundThree(int roundThree) {
        this.roundThree = roundThree;
    }

    public void setName(Account account) {
        this.account = account;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    

    public static void saveToFile(Game game) {
        try {
            FileOutputStream file = new FileOutputStream("Game.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            outputFile.writeObject(game);

            outputFile.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
    
    public static Game getFromFile() {
        try {
            FileInputStream file = new FileInputStream("Game.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            Game game = (Game) inputFile.readObject();
            
            inputFile.close();
            
            return game;
            
        } catch (Exception e) {
            return null;
        }   
    }
    
    public static void getFromHistoryFile(ArrayList<Game> gameList) {
        try {
            FileInputStream file = new FileInputStream("History.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    gameList.add((Game) inputFile.readObject());
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
    
    public static void saveToHistoryFile(ArrayList<Game> gameList) {
        try {
            FileOutputStream file = new FileOutputStream("History.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0; i < gameList.size(); i++) {
                outputFile.writeObject(gameList.get(i));
            }
            
            outputFile.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
}
