# frozen_string_literal: true
require_relative 'directions'
require_relative 'dice'
module Modelo
  class Labyrinth
    @@BLOCK_CHAR = 'X'
    @@EMPTY_CHAR = '-'
    @@MONSTER_CHAR = 'M'
    @@COMBAT_CHAR= 'C'
    @@EXIT_CHAR = 'E'
    @@ROW = 0 #Su objetivo es que no haya números mágicos
    @@COL = 1

    def initialize(n_rows,n_cols, exit_row, exit_col)
      @n_rows=n_rows
      @n_cols=n_cols
      @exit_row=exit_row
      @exit_col=exit_col
      @monsters = Array.new(n_rows) {Array.new(n_cols, nil)} #nil es una inicialización a puntero (nullptr)
      @players = Array.new(n_rows) {Array.new(n_cols, nil)}
      @labyrinth = Array.new(n_rows) {Array.new(n_cols, @@EMPTY_CHAR)}
      @labyrinth[exit_row][exit_col] = @@EXIT_CHAR
    end

    def have_a_winner?
       @players[@exit_row][@exit_col] != nil
    end

    def to_s
      result = ""

      for i in 0...@n_rows
        for j in 0...@n_cols

          if @players[i][j] != nil
            result += 'P'
          elsif @monsters[i][j] != nil
            result += 'M'
          else
            result += @labyrinth[i][j]
          end

        end
        result += "\n"
      end

      result
    end

    private

    def pos_ok?(row, col)
      row >= 0 && row <= @n_rows && col >= 0 && col <= @n_col
    end

    def empty_pos?(row,col)
      if pos_ok?(row,col)
        return @labyrinth[row][col] == @@EMPTY_CHAR
      end
    end

    def monster_pos?(row,col)
      if pos_ok?(row,col)
        return @labyrinth[row][col] == @@MONSTER_CHAR
      end
    end

    def exist_pos?(row,col)
      if pos_ok?(row,col)
        return @labyrinth[row][col] == @@EXIT_CHAR
      end
    end

    def combat_pos?(row,col)
      if pos_ok?(row,col)
        return @labyrinth[row][col] == @@COMBAT_CHAR
      end
    end

    def can_step_on?(row,col)
      pos_ok?(row,col) && @labyrinth[row][col] != @@BLOCK_CHAR
    end

    def update_old_pos(row,col)
      if pos_ok?(row,col) && combat_pos?(row,col)
        if row == @exit_row && col == @exit_col
          @labyrinth[row][col] = @@EXIT_CHAR
        elsif @monsters[row][col] != nil
          @labyrinth[row][col] = @@MONSTER_CHAR
        else
          @labyrinth[row][col] = @@EMPTY_CHAR

        end
      end
    end

    def dir_2_pos(row, col, direction)
      new_pos = [row, col]

      case direction
      when Directions::UP
        new_pos[@@ROW] -= 1
      when Directions::DOWN
        new_pos[@@ROW] += 1
      when Directions::LEFT
        new_pos[@@COL] -= 1
      when Directions::RIGHT
        new_pos[@@COL] += 1
      end

      new_pos
    end

    def random_empty_pos
      while true
        row = Dice.random_pos(@n_rows)
        col = Dice.random_pos(@n_cols)
        if empty_pos?(row,col)
          return new_pos = [row,col]
        end
      end
    end







  end
end