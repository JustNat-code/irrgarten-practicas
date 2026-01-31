# frozen_string_literal: true
require_relative 'weapon'
require_relative 'shield'
module Modelo
  class Player
    attr_accessor :number, :weapons, :shields, :consecutive_hits
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
      @health = @@INITIAL_HEALTH.to_f
    end

    def set_pos(row, col)
      @row = row
      @col = col
    end
    def dead?
      @health <= 0
    end
    def attack()
      @strength + sum_weapons().to_f
    end

    def defend?(received_attack)

    end

    def to_s
      "P [ N:#{@number} , I:#{@intelligence} ,
       S:#{@strength} , R:#{@row} , C:#{@col} ]"
    end

    def new_weapon
      weapon = Weapon.new(Dice.weapon_power, Dice.uses_left)
      @weapons << weapon
    end

    def new_shield
      shield = Shield.new(Dice.shield_power, Dice.uses_left)
      @shields << shield
    end

    def defensive_energy
      @intelligence + sum_shields().to_f
    end

    def reset_hits
      @consecutive_hits = 0
    end
    def sum_weapons
      suma = 0.0
      if !@weapons.empty?
        for w in @weapons
          suma += w.attack
        end
      end
      suma
    end
    def sum_shields
      suma = 0.0
      if !@shields.empty?
        for s in @shields
          suma += s.protect
        end
      end
      suma
    end



  end
end