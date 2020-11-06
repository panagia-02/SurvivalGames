package me.stabolitis.sg.commands.subcommands;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.files.GameFileManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommand implements CommandExecutor {

    private SurvivalGames plugin = SurvivalGames.getPlugin(SurvivalGames.class);
    private GameFileManager game = new GameFileManager(plugin);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not use this command from the console!");
            return true;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("sg.setup")) {
            player.sendMessage(ChatColor.RED + "You need to be an admin or higher to execute this!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_GRAY + "▐" + ChatColor.RED + " Invalid usage, use: /arena spawnpoint <integer>");
            return true;
        }

        if (args.length > 1 && args.length < 3) {

            if (args[0].equalsIgnoreCase("spawnpoint")) {


                // CATCHES THE STRINGS AND RETURNS WHEN FINISHED! AKA /arena spawnpoint lobby / spectator
                if (args[1].equalsIgnoreCase("lobby")) {
                    game.getConfig().set("lobbies.main.world", player.getLocation().getWorld().getName());
                    game.getConfig().set("lobbies.main.x", player.getLocation().getX());
                    game.getConfig().set("lobbies.main.y", player.getLocation().getY());
                    game.getConfig().set("lobbies.main.z", player.getLocation().getZ());
                    game.getConfig().set("lobbies.main.pitch", player.getLocation().getPitch());
                    game.getConfig().set("lobbies.main.yaw", player.getLocation().getYaw());
                    game.saveConfig();

                    player.sendMessage(ChatColor.GREEN + "lobby spawnpoint set, ID: ".toUpperCase() + args[1].toUpperCase());
                    player.sendMessage(ChatColor.GREEN + "WORLD: " + ChatColor.WHITE + player.getLocation().getWorld().getName().toUpperCase());
                    player.sendMessage(ChatColor.GREEN + "X: " + ChatColor.WHITE + (int) player.getLocation().getX());
                    player.sendMessage(ChatColor.GREEN + "Y: " + ChatColor.WHITE + (int) player.getLocation().getY());
                    player.sendMessage(ChatColor.GREEN + "Z: " + ChatColor.WHITE + (int) player.getLocation().getZ());
                    player.sendMessage(ChatColor.GREEN + "PITCH: " + ChatColor.WHITE + (int) player.getLocation().getPitch());
                    player.sendMessage(ChatColor.GREEN + "YAW: " + ChatColor.WHITE + (int) player.getLocation().getYaw());

                    return true;
                } else if (args[1].equalsIgnoreCase("spectator")) {
                    game.getConfig().set("lobbies.spectator.world", player.getLocation().getWorld().getName());
                    game.getConfig().set("lobbies.spectator.x", player.getLocation().getX());
                    game.getConfig().set("lobbies.spectator.y", player.getLocation().getY());
                    game.getConfig().set("lobbies.spectator.z", player.getLocation().getZ());
                    game.getConfig().set("lobbies.spectator.pitch", player.getLocation().getPitch());
                    game.getConfig().set("lobbies.spectator.yaw", player.getLocation().getYaw());
                    game.saveConfig();

                    player.sendMessage(ChatColor.GREEN + "spectator spawnpoint set, ID: ".toUpperCase() + args[1].toUpperCase());
                    player.sendMessage(ChatColor.GREEN + "WORLD: " + ChatColor.WHITE + player.getLocation().getWorld().getName().toUpperCase());
                    player.sendMessage(ChatColor.GREEN + "X: " + ChatColor.WHITE + (int) player.getLocation().getX());
                    player.sendMessage(ChatColor.GREEN + "Y: " + ChatColor.WHITE + (int) player.getLocation().getY());
                    player.sendMessage(ChatColor.GREEN + "Z: " + ChatColor.WHITE + (int) player.getLocation().getZ());
                    player.sendMessage(ChatColor.GREEN + "PITCH: " + ChatColor.WHITE + (int) player.getLocation().getPitch());
                    player.sendMessage(ChatColor.GREEN + "YAW: " + ChatColor.WHITE + (int) player.getLocation().getYaw());

                    return true;
                }

                // START SAVING ONLY THE SPAWN POINTS
                game.getConfig().set("arena.spawnpoint." + args[1] + ".world", player.getLocation().getWorld().getName());
                game.getConfig().set("arena.spawnpoint." + args[1] + ".x", player.getLocation().getX());
                game.getConfig().set("arena.spawnpoint." + args[1] + ".y", player.getLocation().getY());
                game.getConfig().set("arena.spawnpoint." + args[1] + ".z", player.getLocation().getZ());
                game.getConfig().set("arena.spawnpoint." + args[1] + ".pitch", player.getLocation().getPitch());
                game.getConfig().set("arena.spawnpoint." + args[1] + ".yaw", player.getLocation().getYaw());
                game.saveConfig();

                player.sendMessage(ChatColor.GREEN + "spawn point set, ID: ".toUpperCase() + args[1].toUpperCase());
                player.sendMessage(ChatColor.GREEN + "WORLD: " + ChatColor.WHITE + player.getLocation().getWorld().getName().toUpperCase());
                player.sendMessage(ChatColor.GREEN + "X: " + ChatColor.WHITE + (int) player.getLocation().getX());
                player.sendMessage(ChatColor.GREEN + "Y: " + ChatColor.WHITE + (int) player.getLocation().getY());
                player.sendMessage(ChatColor.GREEN + "Z: " + ChatColor.WHITE + (int) player.getLocation().getZ());
                player.sendMessage(ChatColor.GREEN + "PITCH: " + ChatColor.WHITE + (int) player.getLocation().getPitch());
                player.sendMessage(ChatColor.GREEN + "YAW: " + ChatColor.WHITE + (int) player.getLocation().getYaw());

            } else {
                player.sendMessage(ChatColor.DARK_GRAY + "▐" + ChatColor.RED + " Available settings (SPAWNPOINT <i>, LOBBY, SPECTATOR)");
            }

        } else {
            player.sendMessage(ChatColor.DARK_GRAY + "▐" + ChatColor.RED + " Invalid usage, use: /arena spawnpoint <integer>");
        }

        return true;
    }
}
