package me.stabolitis.sg.tasks;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GraceCountdown {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    private int grace;

    public int getGrace() {
        return grace;
    }

    public void setGrace(int grace) {
        this.grace = grace;
    }

    public void startGrace() {

        setGrace(30);

        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendActionBar(ChatColor.RED + "Starting in " + grace);
                }

                if (grace == 0) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle(" ", ChatColor.WHITE + "Good luck "+ ChatColor.BLUE + all.getDisplayName(), 20, 60, 0);
                    }
                    GameState.setState(GameState.PLAYING);
                    cancel();
                }


                setGrace(grace -1);
            }

        }.runTaskTimer(plugin, 0, 20);

    }

}
