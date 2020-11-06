package me.stabolitis.sg.tasks;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.states.GameState;
import me.stabolitis.sg.utils.ScoreHelper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameScoreboard {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    private int playersMinimumRequired = game.getConfig().getInt("players-minimum-required");
    private int playersLeftRequired = playersMinimumRequired - Bukkit.getOnlinePlayers().size();

    //Variables
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    private String serverId = game.getConfig().getString("server-id");

    public void sendDefaultScoreBoard(Player player) {
        ScoreHelper helper = ScoreHelper.createScore(player);

        helper.setTitle("Loading...");
        helper.setSlot(1, "Loading...");
    }

    public void updateWaitingBoard() {

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {

                    if (ScoreHelper.hasScore(player)) {
                        ScoreHelper helper = ScoreHelper.getByPlayer(player);

                        helper.setTitle("&c&lSurvival Games");

                        helper.setSlot(7, "&7" + format.format(now) + "  &8" + serverId);
                        helper.setSlot(6, " ");
                        helper.setSlot(5, "&r&oWaiting &a&o" + playersLeftRequired + " &r&omore");
                        helper.setSlot(4, "&r&oplayers to start");
                        helper.setSlot(3, "&r&othe game!");
                        helper.setSlot(2, " ");
                        helper.setSlot(1, "&rBy Synchunk");
                    }

                }

                if (!(GameState.getState() == GameState.WAITING)) {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 20);

    }

    public void updateStartingBoard() {

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {

                    if (ScoreHelper.hasScore(player)) {
                        ScoreHelper helper = ScoreHelper.getByPlayer(player);

                        helper.setTitle("&c&lSurvival Games");

                        helper.setSlot(7, "&7" + format.format(now) + "  &8" + serverId);
                        helper.setSlot(6, " ");
                        helper.setSlot(5, "&a&o&lPLAYERS FOUND!");
                        helper.setSlot(4, "&r&oGame starts in");
                        //helper.setSlot(3, "&a&o<null> &r&oseconds.");
                        helper.setSlot(2, " ");
                        helper.setSlot(1, "&rBy Synchunk");
                    }

                }

                if (!(GameState.getState() == GameState.STARTING)) {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 20);

    }

}
