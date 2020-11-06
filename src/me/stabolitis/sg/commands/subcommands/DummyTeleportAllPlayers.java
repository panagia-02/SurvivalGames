package me.stabolitis.sg.commands.subcommands;

import me.stabolitis.sg.tasks.TeleportPlayerTo;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DummyTeleportAllPlayers implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("game.tests")) {
            player.sendMessage(ChatColor.RED + "You need to be an admin or higher to execute this!");
            return true;
        }

        TeleportPlayerTo teleport = new TeleportPlayerTo();
        teleport.TeleportPlayersToArena();

        return true;
    }
}
