package com.vtc.logging.service;

import com.vtc.logging.model.Game;
import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import com.vtc.logging.repository.GameRepository;
import com.vtc.logging.repository.GameSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> filterGames(Platform platform, PubStatus status) {
        Specification<Game> spec = Specification
                .where(GameSpecification.hasPlatform(platform))
                .and(GameSpecification.hasStatus(status));
        return gameRepository.findAll(spec);
    }

    public Game getGame(Integer id) {
        return gameRepository.findById(id).get();
    }

    public Game addGame(String name, String description, Platform platform, PubStatus status) {
        Game game = new Game(name, description, platform, status);
        return gameRepository.save(game);
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Integer id, String name, String description, Platform platform, PubStatus status) {
        Game game = gameRepository.findById(id).get();
        game.setName(name);
        game.setDescription(description);
        game.setPlatform(platform);
        game.setStatus(status);
        return gameRepository.save(game);
    }
}
