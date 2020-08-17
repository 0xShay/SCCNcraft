package in.shaycryptoco.SCCNcraft;

import in.shaycryptoco.SCCNcraft.commands.*;
import in.shaycryptoco.SCCNcraft.listeners.BlockBreakListener;
import in.shaycryptoco.SCCNcraft.listeners.CustomListeners;
import in.shaycryptoco.SCCNcraft.listeners.PlayerDeathListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("SCCNcraft has been enabled!");

        getCommand("bal").setExecutor(new EcoBalance());
        getCommand("balance").setExecutor(new EcoBalance());
        getCommand("eco").setExecutor(new EcoAdmin());
        getCommand("pay").setExecutor(new EcoPay());
        getCommand("rules").setExecutor(new Rules());
        getCommand("help").setExecutor(new Help());

        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new CustomListeners(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("SCCNcraft has been disabled!");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

}
