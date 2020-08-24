package in.shaycryptoco.SCCNcraft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnterListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerBedEnterEvent e) {

        Server server = Bukkit.getServer();
        Player player = e.getPlayer();

        if (!e.isCancelled()) {
            player.getWorld().setTime(0);
        }

    }

}
