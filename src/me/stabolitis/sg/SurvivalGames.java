package me.stabolitis.sg;

import me.stabolitis.sg.commands.CommandHandler;
import me.stabolitis.sg.events.EventHandler;
import me.stabolitis.sg.files.GameFileManager;
import me.stabolitis.sg.states.GameState;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class SurvivalGames extends JavaPlugin {

    public CommandHandler commands;
    public EventHandler events;

    public GameFileManager game;

    @Override
    public void onEnable() {

        // Registration of commands.
        commands = new CommandHandler(this);
        commands.registerCommands();


        // Registration of events.
        events = new EventHandler(this);
        events.registerEvents();

        // Registration of files.
        this.game = new GameFileManager(this);

        // Game State Default
        GameState.setState(GameState.WAITING);

    }

    // Spectators and players playing the game.
    private ArrayList<String> playing = new ArrayList<>();

    public ArrayList<String> getPlaying() {
        return playing;
    }

}
