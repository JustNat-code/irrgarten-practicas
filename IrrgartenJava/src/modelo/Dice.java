/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author nmatl
 */
public class Dice {
    static private final int MAX_USES = 5;
    static private final float MAX_INTELLIGENCE = 10.0f;
    static private final float MAX_STRENGTH = 10.0f;  
    static private final float RESURRECT_PROB = 0.3f;
    static private final int WEAPONS_REWARD = 2; 
    static private final int SHIELDS_REWARD = 3; 
    static private final int HEALTH_REWARD = 5;
    static private final int MAX_ATTACK = 3; 
    static private final int MAX_SHIELD = 2; 
    
    static private Random generador = new Random();
    
    static public int randomPos(int max){
        return generador.nextInt(max + 1);
    }
    
    static public int whoStarts(int nplayers){
        return generador.nextInt(nplayers + 1);
    }
    
    static public float randomIntelligence(){
     // nextFloat() genera [0.0, 1.0), al multiplicar por max obtenemos [0.0, max)
         return generador.nextFloat() * MAX_INTELLIGENCE;
    }
    
    static public boolean resurrectPlayer(){
        return generador.nextFloat() > RESURRECT_PROB;
    }
    
    static public int weaponsReward(){
        return generador.nextInt(WEAPONS_REWARD + 1);
    }
    
    static public int shieldsReward(){
        return generador.nextInt(SHIELDS_REWARD + 1);
    }
    
    static public int healthReward(){
        return generador.nextInt(HEALTH_REWARD + 1);
    }
    
    static public float weaponPower(){
        return generador.nextFloat() * MAX_ATTACK;
    }
    
    static public float shieldPower(){
        return generador.nextFloat() * MAX_SHIELD;
    }
  
    static public int usesLeft(){
        return generador.nextInt(MAX_USES + 1);
    }
     static public float intensity(float competence){
         return generador.nextFloat() * competence;
     }
     
     static public boolean discardElement(int usesLeft){
         float probability = 1.0f - ((float)usesLeft / MAX_USES);
         return generador.nextFloat() < probability;
     }
    
}
