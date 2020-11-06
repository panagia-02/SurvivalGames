package me.stabolitis.sg.commands;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.commands.subcommands.ArenaCommand;
import me.stabolitis.sg.commands.subcommands.DummyTeleportAllPlayers;
import me.stabolitis.sg.commands.subcommands.ServerGameState;
import me.stabolitis.sg.commands.subcommands.WhereAmI;

public class CommandHandler {

    private SurvivalGames plugin;

    public CommandHandler(SurvivalGames plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        plugin.getCommand("whereami").setExecutor(new WhereAmI());
        plugin.getCommand("gamestate").setExecutor(new ServerGameState());
        plugin.getCommand("arena").setExecutor(new ArenaCommand());
        plugin.getCommand("dummyTeleportAll").setExecutor(new DummyTeleportAllPlayers());
    }


}
