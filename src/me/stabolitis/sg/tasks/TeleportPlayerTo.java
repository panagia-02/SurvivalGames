package me.stabolitis.sg.tasks;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeleportPlayerTo {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    double mainLobbyX = game.getConfig().getDouble("lobbies.main.x");
    double mainLobbyY = game.getConfig().getDouble("lobbies.main.y");
    double mainLobbyZ = game.getConfig().getDouble("lobbies.main.z");
    double mainLobbyPitch = game.getConfig().getDouble("lobbies.main.pitch");
    double mainLobbyYaw = game.getConfig().getDouble("lobbies.main.yaw");

    double spectatorX = game.getConfig().getDouble("lobbies.spectator.x");
    double spectatorY = game.getConfig().getDouble("lobbies.spectator.y");
    double spectatorZ = game.getConfig().getDouble("lobbies.spectator.z");
    double spectatorPitch = game.getConfig().getDouble("lobbies.spectator.pitch");
    double spectatorYaw = game.getConfig().getDouble("lobbies.spectator.yaw");

    public void TeleportPlayerToLobby(Player player) {
        Location loc = new Location(player.getWorld(), mainLobbyX, mainLobbyY, mainLobbyZ, (float) mainLobbyYaw, (float) mainLobbyPitch);
        player.teleport(loc);
    }

    public void TeleportPlayerToSpectatorLobby(Player player) {
        Location loc = new Location(player.getWorld(), spectatorX, spectatorY, spectatorZ, (float) spectatorYaw, (float) spectatorPitch);
        player.teleport(loc);
    }

    public void TeleportPlayersToArena() {

        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        ArrayList<Location> locations = new ArrayList<Location>();


        Location spawnpoint1 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.one.x"),
                game.getConfig().getDouble("arena.spawnpoint.one.y"),
                game.getConfig().getDouble("arena.spawnpoint.one.z"));
        locations.add(spawnpoint1);

        Location spawnpoint2 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.two.x"),
                game.getConfig().getDouble("arena.spawnpoint.two.y"),
                game.getConfig().getDouble("arena.spawnpoint.two.z"));
        locations.add(spawnpoint2);

        Location spawnpoint3 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.three.x"),
                game.getConfig().getDouble("arena.spawnpoint.three.y"),
                game.getConfig().getDouble("arena.spawnpoint.three.z"));
        locations.add(spawnpoint3);

        Location spawnpoint4 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.four.x"),
                game.getConfig().getDouble("arena.spawnpoint.four.y"),
                game.getConfig().getDouble("arena.spawnpoint.four.z"));
        locations.add(spawnpoint4);

        Location spawnpoint5 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.five.x"),
                game.getConfig().getDouble("arena.spawnpoint.five.y"),
                game.getConfig().getDouble("arena.spawnpoint.five.z"));
        locations.add(spawnpoint5);

        Location spawnpoint6 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.six.x"),
                game.getConfig().getDouble("arena.spawnpoint.six.y"),
                game.getConfig().getDouble("arena.spawnpoint.six.z"));
        locations.add(spawnpoint6);

        Location spawnpoint7 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.seven.x"),
                game.getConfig().getDouble("arena.spawnpoint.seven.y"),
                game.getConfig().getDouble("arena.spawnpoint.seven.z"));
        locations.add(spawnpoint7);

        Location spawnpoint8 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.eight.x"),
                game.getConfig().getDouble("arena.spawnpoint.eight.y"),
                game.getConfig().getDouble("arena.spawnpoint.eight.z"));
        locations.add(spawnpoint8);

        Location spawnpoint9 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.nine.x"),
                game.getConfig().getDouble("arena.spawnpoint.nine.y"),
                game.getConfig().getDouble("arena.spawnpoint.nine.z"));
        locations.add(spawnpoint9);

        Location spawnpoint10 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.ten.x"),
                game.getConfig().getDouble("arena.spawnpoint.ten.y"),
                game.getConfig().getDouble("arena.spawnpoint.ten.z"));
        locations.add(spawnpoint10);

        Location spawnpoint11 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.eleven.x"),
                game.getConfig().getDouble("arena.spawnpoint.eleven.y"),
                game.getConfig().getDouble("arena.spawnpoint.eleven.z"));
        locations.add(spawnpoint11);

        Location spawnpoint12 = new Location(Bukkit.getWorld("world"),
                game.getConfig().getDouble("arena.spawnpoint.twelve.x"),
                game.getConfig().getDouble("arena.spawnpoint.twelve.y"),
                game.getConfig().getDouble("arena.spawnpoint.twelve.z"));
        locations.add(spawnpoint12);

        for (int i = 0; i < players.length; i++) {
            players[i].teleport(locations.get(i));
        }

    }
}
