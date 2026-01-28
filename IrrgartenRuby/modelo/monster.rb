# frozen_string_literal: true
require_relative 'dice'
module Modelo
  class Monster
    @@INITIAL_HEALTH = 5
    def initialize(name, intelligence, strength)
      @name = name
      @intelligence = intelligence
      @strength = strength
      @health = @@INITIAL_HEALTH
      @row = -1
      @col = -1
    end

    def dead?
      @health <= 0
    end

    def attack
      Dice.intensity(@strength)
    end

    def set_pos(row, col)
      @row = row
      @col = col
    end

    def to_s
      "M [#{@name} , #{@intelligence} , #{@strength} , #{@row} , #{@col} ]"
    end

    def got_wounded
      @health -= @health
    end

    def defend?(received_attack)

    end

  end
end
