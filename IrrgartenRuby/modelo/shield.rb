# frozen_string_literal: true
require_relative 'dice'
module Modelo
  class Shield
    def initialize(protection, uses)
      @protection = protection
      @uses = uses
    end
    def attack
      if @uses > 0
        @uses -= @uses
        return @protection
      end
      0.0
    end

    def to_s
      "S [#{@protection} , #{@uses} ]"
    end

    def discard()
      Dice.discard_element(@uses)
    end


  end
end