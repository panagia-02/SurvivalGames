package me.stabolitis.sg.commands.subcommands;

import me.stabolitis.sg.states.GameState;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerGameState implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Sorry, you cannot use this command from console :(");
            return true;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("server.gamestate")) {
            player.sendMessage(ChatColor.RED + "You need to be an admin or higher to execute this!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Invalid command!");
            return true;
        }

        if (args.length > 0 && args.length < 2) {

            if (args[0].equalsIgnoreCase("waiting")) {
                player.sendMessage(ChatColor.YELLOW + "Game state has been set from " + GameState.getState() + " to WAITING!");
                GameState.setState(GameState.WAITING);
            } else if (args[0].equalsIgnoreCase("starting")) {
                player.sendMessage(ChatColor.YELLOW + "Game state has been set from " + GameState.getState() + " to STARTING!");
                GameState.setState(GameState.STARTING);
            } else if (args[0].equalsIgnoreCase("playing")) {
                player.sendMessage(ChatColor.YELLOW + "Game state has been set from " + GameState.getState() + " to PLAYING!");
                GameState.setState(GameState.PLAYING);
            } else if (args[0].equalsIgnoreCase("restarting")) {
                player.sendMessage(ChatColor.YELLOW + "Game state has been set from " + GameState.getState() + " to RESTARTING!");
                GameState.setState(GameState.RESTARTING);
            } else {
                player.sendMessage(ChatColor.RED + "Invalid game state, try: " + ChatColor.GRAY + "(WAITING, STARTING, PLAYING, RESTARTING)");
            }

        } else {
            player.sendMessage(ChatColor.RED + "Invalid command!");
        }

        return true;
    }
}