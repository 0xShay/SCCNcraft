package in.shaycryptoco.SCCNcraft.listeners;

import in.shaycryptoco.SCCNcraft.events.SpawnerBreakEvent;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.logging.Logger;

import static in.shaycryptoco.SCCNcraft.Main.*;

public class BlockBreakListener implements Listener {

    private static final Logger log = Logger.getLogger("Minecraft");

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Economy eco = getEconomy();
        Player p = e.getPlayer();

        if (e.getBlock().getType().equals(Material.IRON_ORE) || e.getBlock().getType().equals(Material.GOLD_ORE) || e.getBlock().getType().equals(Material.REDSTONE_ORE) || e.getBlock().getType().equals(Material.LAPIS_ORE) || e.getBlock().getType().equals(Material.DIAMOND_ORE) || e.getBlock().getType().equals(Material.EMERALD_ORE) || e.getBlock().getType().equals(Material.ANCIENT_DEBRIS)) {

            for(Player player: Bukkit.getOnlinePlayers()) {

                if(player.hasPermission("sccncraft.admin.notify")) player.sendMessage(ChatColor.AQUA + p.getName() + ChatColor.GREEN + " just mined a " + ChatColor.AQUA + e.getBlock().getType() + ChatColor.GREEN + "!");

            }

        }

//        if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
//
//            ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
//            if (!item.getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
//
//                // reward for mining 1 diamond ore
//                Random rand = new Random();
//                double mining_reward = Double.parseDouble(String.format("%.2f", (rand.nextDouble() * 2) + 1));
//                // random from 1 to 3
//
//                EconomyResponse response = eco.depositPlayer(p, mining_reward);
//                if (response.transactionSuccess()) {
//                    p.sendMessage(ChatColor.GREEN + "You got " + ChatColor.AQUA + mining_reward + ChatColor.GREEN + " SCCN for mining a diamond ore!");
//                }
//
//            }
//
//        }

        if (e.getPlayer().hasPermission("sccncraft.general.silkspawners") && e.getBlock().getType().equals(Material.SPAWNER)) {

            ItemStack item = e.getPlayer().getInventory().getItemInMainHand();

            if (item.getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
                Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(e.getPlayer(), e.getBlock()));
            }

        }

    }

}
