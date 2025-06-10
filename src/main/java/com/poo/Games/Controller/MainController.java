package com.poo.Games.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poo.Games.Model.Game;
import com.poo.Games.Model.GameService;

@Controller
public class MainController {
    
    @Autowired
    ApplicationContext ctx;

    @Autowired
    GameService gameService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        model.addAttribute("game", new Game());
        return "formulario";
    }

     @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Game game){
        gameService.inserirGame(game);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Game> lista = gameService.listarGames();
        model.addAttribute("games", lista);
        return "listar";
    }

    @GetMapping("/buscar")
    public String buscarForm(Model model) {
        model.addAttribute("game", new Game());
        return "buscar";
    }

    @PostMapping("/buscar")
    public String buscarGame(@ModelAttribute Game game, Model model) {
        Game resultado = gameService.buscarPorNome(game.getNome());
        if (resultado == null){
            return "naoEncontrado";
        }
        model.addAttribute("resultado", resultado);
        return "buscar";
    }

    @GetMapping("/atualizar")
    public String atualizarForm(Model model) {
        model.addAttribute("game", new Game());
        return "atualizar";
    }

    @PostMapping("/atualizar")
    public String atualizarGame(@ModelAttribute Game game) {
        Game resultado = gameService.buscarPorNome(game.getNome());
        if (resultado == null){
            return "naoEncontrado";
        }
        gameService.atualizarGame(game);
        return "redirect:/listar";
    }

    @GetMapping("/deletar")
    public String deletarForm(Model model) {
        model.addAttribute("game", new Game());
        return "deletar";
    }

    @PostMapping("/deletar")
    public String deletarGame(@ModelAttribute Game game) {
        Game resultado = gameService.buscarPorNome(game.getNome());
        if (resultado == null){
            return "naoEncontrado";
        }
        gameService.deletarGame(game.getNome());
        return "redirect:/listar";
    }
}
