# frozen_string_literal: true
require_relative 'modelo/weapon'
require_relative 'modelo/dice'
require_relative 'modelo/shield'

arma1 = Modelo::Weapon.new(3.4, 6)
puts arma1.to_s

escudo1 = Modelo::Shield.new(3.4, 6)
puts escudo1.to_s

dado = Modelo::Dice.new
escudo2 = Modelo::Shield.new(Modelo::Dice.shield_power, Modelo::Dice.uses_left)
puts escudo2.to_s