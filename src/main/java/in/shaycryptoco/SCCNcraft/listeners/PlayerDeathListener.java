package in.shaycryptoco.SCCNcraft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        Server server = Bukkit.getServer();
        Player victim = e.getEntity();
        Player killer = victim.getKiller();

        if (killer != null) {

            ConsoleCommandSender console = server.getConsoleSender();

            console.sendMessage(ChatColor.GREEN + victim.getName() + "'s head has been dropped!");

            ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

            SkullMeta sm = (SkullMeta) item.getItemMeta();
            sm.setOwner(victim.getName());

            item.setItemMeta(sm);

            e.getDrops().add(item);

        }

    }

}
