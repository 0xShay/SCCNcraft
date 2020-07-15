package in.shaycryptoco.SCCNcraft.listeners;

import in.shaycryptoco.SCCNcraft.events.SpawnerBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import static in.shaycryptoco.SCCNcraft.misc.StringFormatter.formatMobName;

public class CustomListeners implements Listener {

    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent e) {

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack spawnerToGive = new ItemStack(Material.SPAWNER);
        BlockStateMeta spawnerMeta = (BlockStateMeta) spawnerToGive.getItemMeta();
        CreatureSpawner spawnerCS = (CreatureSpawner) spawnerMeta.getBlockState();

        spawnerCS.setSpawnedType(cs.getSpawnedType());
        spawnerMeta.setBlockState(spawnerCS);

        String formattedMobName = formatMobName(cs.getSpawnedType().name());
        spawnerMeta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + "Spawner" + ChatColor.RED + " | " + ChatColor.AQUA + formattedMobName);
        spawnerToGive.setItemMeta(spawnerMeta);

        e.getBreaker().getInventory().addItem(spawnerToGive);

        e.getBreaker().sendMessage(ChatColor.GREEN + "You just broke a " + formattedMobName + " spawner!");

    }

}
