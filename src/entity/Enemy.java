/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author chans
 */
public class Enemy {
    private int currentHP;
    private int maxHP;
    private int minAtk;
    private int maxAtk;
    private String name;
    
    public Enemy(int currentHP, int maxHP, int minAtk, int maxAtk, String name) {
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.name = name;
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

    public String getName() {
        return name;
    }
    
    public int getAttackDmg() {
        return minAtk + (int)(Math.random() * ((maxAtk - minAtk) + 1));
    }
    
    public int getCriticalDmg(int probability, int critical) {
        // 25/100 probability
        int criticalChance = 100 + critical;
        
        if (probability(probability)) {
            return getAttackDmg() * criticalChance / 100;
        }
        else {
            return getAttackDmg();
        }
    }
    
    private boolean probability(int probability) {
        
        int value = 1 + (int)(Math.random() * ((100 - 1) + 1));
        
        if (value <= probability) {
            return true;
        }
        else {
            return false;
        }
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
}
