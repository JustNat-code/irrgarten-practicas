/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author nmatl
 */
public class Monster {
     static private final int INITIAL_HEALTH = 5;
    
    private float strength;
    private int health;
    private int row;
    private int col;
    private String name;
    
    
    public Monster(String name,  float strength){
        this.strength = strength;
        this.name = name;
        this.health = INITIAL_HEALTH;
        this.row = -1;
        this.col = -1;
        
    }
    
    // Comprueba si el monstruo está muerto.
     
    public boolean dead() {
        return this.health <= 0;
    }

    // Calcula la intensidad del ataque del monstruo.
     
    public float attack() {
       
        return Dice.intensity(this.strength);
    }
     public boolean defend(float received_attack) {
        float defensivePower = Dice.intensity(this.strength);

        if (defensivePower < received_attack) {
            this.gotWounded(); 
            return dead();     // Devuelve true si ha muerto
        }

        // Si el ataque fue parado, devuelve false (no ha muerto)
        return false;
    }

    // Se establece la posición del monstruo en el laberinto.
    
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    
    public String toString() {
        return "M[" + this.name + ", H:" + this.health + ", S:" + this.strength + ", Pos:(" + this.row + "," + this.col + ")]";
    }

    // Reduce la vida del monstruo en 1 unidad cuando es herido.
     
    public void gotWounded() {
        this.health--;
    }
}
