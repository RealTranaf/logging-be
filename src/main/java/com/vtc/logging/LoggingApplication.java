package com.vtc.logging;

import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import com.vtc.logging.repository.GameRepository;
import com.vtc.logging.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class LoggingApplication implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.count() == 0) {
            gameService.addGame(
                    "League of Legends",
                    "A competitive 5v5 multiplayer online battle arena game.",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Counter-Strike 2",
                    "A tactical first-person shooter focused on team-based gameplay.",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Dota 2",
                    "A strategic MOBA game with complex mechanics and deep teamwork.",
                    Platform.PC,
                    PubStatus.PUBLISHED
            );

            gameService.addGame(
                    "Valorant",
                    "A tactical shooter combining gunplay with unique agent abilities.",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Stardew Valley",
                    "A relaxing farming simulation and life RPG.",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Clash of Clans",
                    "A mobile strategy game about building villages and raiding others.",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "PUBG Mobile",
                    "A battle royale shooter where players fight to be the last survivor.",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Genshin Impact",
                    "An open-world action RPG with anime-style graphics.",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Monument Valley",
                    "A puzzle game featuring impossible architecture.",
                    Platform.MOBILE,
                    PubStatus.PUBLISHED
            );

            gameService.addGame(
                    "Alto's Adventure",
                    "An endless snowboarding game with beautiful minimalist visuals.",
                    Platform.MOBILE,
                    PubStatus.PUBLISHED
            );
        }
    }
}
