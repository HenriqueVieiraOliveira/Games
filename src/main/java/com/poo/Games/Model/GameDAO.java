package com.poo.Games.Model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class GameDAO {

    @Autowired
    private DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {jdbc = new JdbcTemplate(dataSource);}

    public void inserirGame(Game game) {
        String sql = "INSERT INTO game(nome, anoLancamento, preco) VALUES (?, ?, ?)";
        Object[] parametros = new Object[3];
        parametros[0] = game.getNome();
        parametros[1] = game.getAnoLancamento();
        parametros[2] = game.getPreco();
        jdbc.update(sql, parametros);
    }

    public List<Game> listarGames() {
        String sql = "SELECT * FROM game";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Game.class));
    }

    public Game buscarPorNome(String nome) {
        String sql = "SELECT * FROM game WHERE nome = ?";
        List<Game> games = jdbc.query(sql, new BeanPropertyRowMapper<>(Game.class), nome);
        return games.isEmpty() ? null : games.get(0);
    }

    public void atualizarGame(Game game) {
        String sql = "UPDATE game SET anoLancamento = ?, preco = ? WHERE nome = ?";
        jdbc.update(sql, game.getAnoLancamento(), game.getPreco(), game.getNome());
    }

    public void deletarGame(String nome) {
        String sql = "DELETE FROM game WHERE nome = ?";
        jdbc.update(sql, nome);
    }
}