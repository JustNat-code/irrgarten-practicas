# frozen_string_literal: true

class Player
  @@MAX_WEAPONS = 2
  @@MAX_SHIELDS = 3
  @@INITIAL_HEALTH = 10
  @@HITS2LOSE = 3
  def initialize(number, intelligence, strength)
    @number = number
    @intelligence = intelligence
    @strength = strength
    @health = @@INITIAL_HEALTH
    @row = -1
    @col = -1
    @weapons = []
    @shields = []
    @consecutive_hits = 0
  end

  def resurrect
    @weapons = []
    @shields = []
    @consecutive_hits = 0
    @health = @@INITIAL_HEALTH
  end

  def set_pos(row, col)
    @row = row
    @col = col
  end
  def dead?
    @health <= 0
  end

end
