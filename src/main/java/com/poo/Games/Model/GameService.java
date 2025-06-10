package com.poo.Games.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameDAO gameDAO;

    public void inserirGame(Game game) {
        gameDAO.inserirGame(game);
    }

    public List<Game> listarGames() {
        return gameDAO.listarGames();
    }

    public Game buscarPorNome(String nome) {
        return gameDAO.buscarPorNome(nome);
    }

    public void atualizarGame(Game game) {
        gameDAO.atualizarGame(game);
    }

    public void deletarGame(String nome) {
        gameDAO.deletarGame(nome);
    }
}
