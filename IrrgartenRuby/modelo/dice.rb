# frozen_string_literal: true
module Modelo
  class Dice
    @@MAX_USES = 5
    @@MAX_INTELLIGENCE = 10.0
    @@MAX_STRENGTH = 10.0
    @@RESURRECT_PROB = 0.3
    @@WEAPONS_REWARD = 2
    @@SHIELDS_REWARD = 3
    @@HEALTH_REWARD = 5
    @@MAX_ATTACK = 3
    @@MAX_SHIELD = 2


    @@generador = Random.new


  #Ejemplo de uso del generador de clase Random
    def self.aleatorio
      if @@generador.rand < 0.3
        return true
      else
        return false
      end

    end

  #Devuelve un número de fila o columna aleatoria
    def self.random_pos(max)
      @@generador.rand(0..max)
    end

    def self.who_starts(nplayer)
      @@generador.rand(0..nplayer)
    end

    def self.random_intelligence
      #@@generador.rand(0...@@MAX_INTELLIGENCE) TRES PUNTOS
      @@generador.rand(@@MAX_INTELLIGENCE.to_f)
    end

    def self.random_strenght
      @@generador.rand(@@MAX_STRENGTH.to_f)
    end

    def self.resurrect_player
      @@generador.rand() > @@RESURRECT_PROB
    end

    def self.weapons_reward
      @@generador.rand(0..@@WEAPONS_REWARD)
    end

    def self.shield_reward
      @@generador.rand(0..@@SHIELDS_REWARD)
    end

    def self.health_reward
      @@generador.rand(0..@@HEALTH_REWARD)
    end

    def self.weapon_power
      @@generador.rand(0...@@MAX_ATTACK.to_f)
    end

    def self.shield_power
      @@generador.rand(0...@@MAX_SHIELD.to_f)
    end

    def self.uses_left
      @@generador.rand(0..@@MAX_USES)
    end

    def self.intensity(competence)
      @@generador.rand(0...competence)
    end

    def self.discard_element(uses_left)
      probability = 1.to_f/(uses_left.to_f / @@MAX_USES)
      return @@generador.rand() < probability
    end

  end
end