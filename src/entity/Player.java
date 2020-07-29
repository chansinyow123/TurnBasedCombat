/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author chans
 */
public class Player implements Serializable {
    private int currentHP;
    private int maxHP;
    private int minAtk;
    private int maxAtk;
    private int currentMP;
    private int maxMP;
    
    public Player(int currentHP, int maxHP, int minAtk, int maxAtk, int currentMP, int maxMP) {
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.currentMP = currentMP;
        this.maxMP = maxMP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMinAtk() {
        return minAtk;
    }

    public int getMaxAtk() {
        return maxAtk;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setMinAtk(int minAtk) {
        this.minAtk = minAtk;
    }

    public void setMaxAtk(int maxAtk) {
        this.maxAtk = maxAtk;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }
    
    public int getAttackDmg() {
        return minAtk + (int)(Math.random() * ((maxAtk - minAtk) + 1));
    }
    
    public int calculateHP(int hp) {
        this.currentHP += hp;
        if (this.currentHP > this.maxHP) {
            this.currentHP = this.maxHP;
        } else if (this.currentHP < 0) {
            this.currentHP = 0;
        }
        
        return this.currentHP;
    }
    
    public int calculateMP(int mp) {
        this.currentMP += mp;
        if (this.currentMP > this.maxMP) {
            this.currentMP = this.maxMP;
        } else if (this.currentMP < 0) {
            this.currentMP = 0;
        }
        
        return this.currentMP;
    }
}