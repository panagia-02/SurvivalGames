package me.stabolitis.sg.events.player;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.states.GameState;
import me.stabolitis.sg.tasks.GameScoreboard;
import me.stabolitis.sg.tasks.TeleportPlayerTo;
import me.stabolitis.sg.utils.ScoreHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    private int playersMinimumRequired = game.getConfig().getInt("players-minimum-required");
    private int playersRequired = playersMinimumRequired - plugin.getPlaying().size();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        GameScoreboard scoreboard = new GameScoreboard();
        scoreboard.sendDefaultScoreBoard(player);

        if (GameState.getState() == GameState.WAITING || GameState.getState() == GameState.STARTING) {
            TeleportPlayerTo teleport = new TeleportPlayerTo();
            teleport.TeleportPlayerToLobby(player);

            plugin.getPlaying().add(player.getDisplayName());
        }

        if (plugin.getPlaying().size() == playersMinimumRequired) {
            if (GameState.getState() == GameState.WAITING) {
                GameState.setState(GameState.STARTING);
            }
        }
    }

}
