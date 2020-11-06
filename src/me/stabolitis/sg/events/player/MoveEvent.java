package me.stabolitis.sg.events.player;

import me.stabolitis.sg.states.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (GameState.getState() == GameState.GRACE) {
            event.setCancelled(true);
            return;
        }
    }

}
