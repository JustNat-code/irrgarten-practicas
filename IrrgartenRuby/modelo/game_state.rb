# frozen_string_literal: true
module Modelo
  class GameState
    attr_reader :labyrinth, :players, :monsters, :current_player, :log
    def initialize(labyrinth, players, monsters,
                   current_player, winner, log)
      @labyrinth = labyrinth
      @players = players
      @monsters = monsters
      @current_player = current_player
      @winner = winner
      @log = log
    end




end
end
