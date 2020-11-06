package me.stabolitis.sg.events;

import me.stabolitis.sg.SurvivalGames;
import me.stabolitis.sg.events.player.JoinEvent;
import me.stabolitis.sg.events.player.MoveEvent;
import me.stabolitis.sg.events.player.QuitEvent;
import me.stabolitis.sg.events.world.WorldEvent;

public class EventHandler {

    private SurvivalGames plugin;

    public EventHandler(SurvivalGames plugin) {
        this.plugin = plugin;
    }

    public void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new JoinEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new QuitEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new WorldEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MoveEvent(), plugin);
    }

}
