/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author nmatl
 */
public class Labyrinth {
    static private final char BLOCK_CHAR = 'X';
   static private final char EMPTY_CHAR = ' ';
   static private final char MONSTER_CHAR = 'M';
   static private final char COMBAT_CHAR = 'C';
   static private final char EXIT_CHAR = 'E';
   static private final int ROW = 0;
   static private final int COL = 1;
   
   private int nRows;
   private int nCols;
   private int exitRow;
   private int exitCol;
   
   private Monster[][] monsters;
   private Player[][] players;
   private char[][] labyrinth;
   
   
   public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
       this.nRows = nRows;
       this.nCols = nCols;
       this.exitRow = exitRow;
       this.exitCol = exitCol;
       
       this.labyrinth = new char [nRows][nCols];
       this.monsters = new Monster [nRows][nCols];
       this.players = new Player [nRows][nCols];
       for(int i = 0; i < nRows; i++){
           for(int j = 0; j < nCols; j++){
            this.labyrinth[i][j] = Labyrinth.EMPTY_CHAR;
            this.players[i][j] = null;
            this.monsters[i][j] = null;
           }
       }
       this.labyrinth[exitRow][exitCol] = Labyrinth.EXIT_CHAR;
       
       
   }
   
   public boolean haveAWinner(){
       return players[exitRow][exitCol] != null;
   }
  
   
   @Override
   public String toString() {
        String result = "";

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {

                if (players[i][j] != null) {
                    result += 'P';
                } else if (monsters[i][j] != null) {
                    result += MONSTER_CHAR;
                } else {
                    result += labyrinth[i][j];
                }
            }
            result += '\n';
        }

        return result;
    }
   
    private boolean posOk(int row, int col) {
        return (row >= 0 && row < nRows && col >= 0 
                && col < nCols);
    }
    
    private boolean emptyPos(int row, int col){
        if(posOk(row,col)){
            return labyrinth[row][col] == EMPTY_CHAR;
        }
        return false;
    }
    
     private boolean monsterPos(int row, int col){
        if(posOk(row,col)){
            return labyrinth[row][col] == MONSTER_CHAR;
        }
        return false;
    }
    
      private boolean exitPos(int row, int col){
        if(posOk(row,col)){
            return labyrinth[row][col] == EXIT_CHAR;
        }
        return false;
    }
     private boolean combatPos(int row, int col) {
        return posOk(row, col) && labyrinth[row][col] == COMBAT_CHAR;
    }

    private boolean canStepOn(int row, int col) {
        return posOk(row, col) && labyrinth[row][col] != BLOCK_CHAR;
    }
    
    private void updateOldPos(int row, int col) {
        if (posOk(row, col) && combatPos(row, col)) {
            if (row == exitRow && col == exitCol) {
                labyrinth[row][col] = EXIT_CHAR;
            } else if (monsters[row][col] != null) {
                labyrinth[row][col] = MONSTER_CHAR;
            } else {
                labyrinth[row][col] = EMPTY_CHAR;
            }
        }
    }
      
     private int[] dir2pos(int row, int col, Directions direction) {
          int[] newPos = {row,col};
          switch(direction){
                  case UP:
                    newPos[ROW]--;
                    break;
                  case DOWN:
                      newPos[ROW]++;
                      break;
                  case LEFT:
                      newPos[COL]--;
                      break;
                  case RIGHT:
                      newPos[COL]++;
                      break;
          }  
          return newPos;       
     }
     
     private int[] randomEmptyPos(){
         while (true) {
            int row = Dice.randomPos(nRows);
            int col = Dice.randomPos(nCols);
            if (emptyPos(row, col)) {
                return new int[]{row, col};
            }
        }
     
     }
   
}
