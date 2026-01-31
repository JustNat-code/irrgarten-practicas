# frozen_string_literal: true
module Modelo
  class Weapon
    attr_accessor :power
    def initialize(power, uses)
      @power = power
      @uses = uses
    end

    def attack
      if @uses > 0
        @uses -= @uses
        return @power
      end
      0.0
    end

    def to_s
      "W [#{@power} , #{@uses} ]"
    end
    def discard
      Dice.discard_element(@uses)
    end

  end
end