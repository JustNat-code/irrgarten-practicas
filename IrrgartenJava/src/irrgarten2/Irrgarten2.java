/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgarten2;
import modelo.Dice;
import modelo.Shield;

/**
 *
 * @author nmatl
 */
public class Irrgarten2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Shield escudo1 = new Shield(2,5);
          System.out.println(escudo1.toString());
          
          Shield escudo2 = new Shield(Dice.shieldPower(), Dice.usesLeft());
          System.out.println(escudo2.toString());
    }       
    
}
