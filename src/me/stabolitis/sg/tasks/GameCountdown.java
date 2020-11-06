package me.stabolitis.sg.tasks;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.states.GameState;
import me.stabolitis.sg.utils.ScoreHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameCountdown {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    private int playersMinimumRequired = game.getConfig().getInt("players-minimum-required");

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    private int countdown;

    public void startCountdown() {

        setCountdown(game.getConfig().getInt("game-starting-countdown"));

        new BukkitRunnable() {

            @Override
            public void run() {

                if (Bukkit.getOnlinePlayers().size() < playersMinimumRequired) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Game countdown stopped, game doesn't have enough players!");
                        all.sendTitle("", ChatColor.RED + "Game countdown stopped!", 0, 40, 0);
                    }
                    GameState.setState(GameState.WAITING);
                    cancel();

                    return;
                }

                if (getCountdown() <= 60 && getCountdown() > 0) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendActionBar(ChatColor.GREEN + "Game starts in " + ChatColor.BOLD + getCountdown());
                        if (ScoreHelper.hasScore(all)) {
                            ScoreHelper helper = ScoreHelper.getByPlayer(all);
                            helper.setSlot(3, "&a&o" + getCountdown() + " &r&oseconds.");
                        }
                    }
                }

                if (getCountdown() == 60) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8▐ &6The game will start in &e" + getCountdown() + " &6seconds!"));
                    }
                }

                if (getCountdown() == 30) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8▐ &6The game will start in &e" + getCountdown() + " &6seconds!"));
                    }
                }

                if (getCountdown() == 10) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8▐ &6Get ready, the game will start in &e" + getCountdown() + " &6seconds!"));
                    }
                }

                if (getCountdown() == 5) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle(ChatColor.YELLOW + "" + getCountdown(), " ", 0, 20, 0);
                    }
                }

                if (getCountdown() == 4) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle(ChatColor.GOLD + "" + getCountdown(), " ", 0, 20, 0);
                    }
                }

                if (getCountdown() <= 3 && getCountdown() >= 1) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle(ChatColor.RED + "" + getCountdown(), " ", 0, 20, 0);
                    }
                }

                if (getCountdown() == 1) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8▐ &6&o&lTELEPORTING ALL PLAYERS..."));
                    }
                }

                if (getCountdown() == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "Survival Games", ChatColor.GRAY + "By " + ChatColor.WHITE + "Synchunk", 20, 60, 20);
                    }

                    GameState.setState(GameState.GRACE);

                    TeleportPlayerTo teleport = new TeleportPlayerTo();
                    teleport.TeleportPlayersToArena();

                    cancel();
                }


                setCountdown(countdown -1);
            }

        }.runTaskTimer(plugin, 0, 20);

    }

}
