package me.stabolitis.sg.commands.subcommands;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhereAmI implements CommandExecutor {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        player.sendMessage(ChatColor.YELLOW + "You are currently in " + ChatColor.AQUA + game.getConfig().getString("server-id")
        + ChatColor.GRAY + " (" + Bukkit.getOnlinePlayers().size() + ")");
        return true;
    }
}
