/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author nmatl
 */
public class Player {
    static private final int MAX_WEAPONS = 2;
    static private final int MAX_SHIELDS = 3;
    static private final int INITIAL_HEALTH = 10;
    static private final int HIT2LOSE = 3;
    static private final int INVALID_POSITION = -1;
    
    private char number;
    private int consecutiveHits;
    private float intelligence;
    private float strength;
    private float health;
    private int col;
    private int row;
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    
    public Player(char number, float intelligence, float strength){
           this.number = number;
           this.intelligence = intelligence;
           this.strength = strength;
           this.health = INITIAL_HEALTH;
           this.consecutiveHits = 0;
           this.weapons = new ArrayList<>();
           this.shields = new ArrayList<>();
           this.row = -1;
           this.col = -1;
    }
    
    public int getConsecutiveHits() {
        return this.consecutiveHits;
    }
     public char getNumber() {
        return this.number;
    }

    
     public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public ArrayList<Shield> getShields() {
        return this.shields;
    }
    
    public void resurrect(){
        this.weapons.clear();
        this.shields.clear();
        this.health = INITIAL_HEALTH;
        this.consecutiveHits = 0;
    }
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    
    public String toString() {
        return "P[" + this.number + ", H:" + this.health + ", S:" + this.strength + ", Pos:(" + this.row + "," + this.col + ")]";
    }
    
    public Weapon newWeapon(){
        Weapon arma = new Weapon(Dice.weaponPower(), Dice.usesLeft());
        weapons.add(arma);
        return arma;
    }
     public Shield newShield(){
        Shield escudo = new Shield(Dice.shieldPower(), Dice.usesLeft());
        shields.add(escudo);
        return escudo;
    }
     
     public float defensiveEnergy(){
         return sumShields() + this.intelligence;
     }
     
     public void resetHits(){
        this.consecutiveHits = 0;
    }
    
    
    public void incConsecutiveHits(){
        this.consecutiveHits += 1;
    }
    
    public void gotWounded(){
        this.health--;
    }
     
     
     public float sumShields(){
         float suma = 0.0f;
         if(!shields.isEmpty()){
             for(Shield s : shields){
                 suma += s.protect();
             }
             
         }
         return suma;
     }
     
     public float sumWeapons(){
         float suma = 0.0f;
         if(!weapons.isEmpty()){
             for(Weapon w : weapons){
                 suma += w.attack();
             }
             
         }
         return suma;
     }
       
       
     
     
     
     
    
    
}