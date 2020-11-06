package me.stabolitis.sg.events.player;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.utils.ScoreHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    private int playersMinimumRequired = game.getConfig().getInt("players-minimum-required");
    private int playersRequired = playersMinimumRequired - Bukkit.getOnlinePlayers().size();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        // Scoreboard removal on quit.
        if (ScoreHelper.hasScore(player)) {
            ScoreHelper.removeScore(player);
        }

        plugin.getPlaying().remove(player.getDisplayName());
    }

}
