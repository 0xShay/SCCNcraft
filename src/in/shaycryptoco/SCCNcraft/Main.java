package in.shaycryptoco.SCCNcraft;

import in.shaycryptoco.SCCNcraft.commands.EcoAdmin;
import in.shaycryptoco.SCCNcraft.commands.EcoBalance;
import in.shaycryptoco.SCCNcraft.commands.EcoPay;
<<<<<<< HEAD:src/in/shaycryptoco/SCCNcraft/Main.java
import in.shaycryptoco.SCCNcraft.listeners.BlockBreakListener;
import in.shaycryptoco.SCCNcraft.misc.StartMessage;
=======
>>>>>>> parent of 56fab69... Diamond mining reward:src/main/java/in/shaycryptoco/SCCNcraft/Main.java
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    @Override
    public void onEnable() {
    	saveDefaultConfig();
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("SCCNcraft has been enabled!");

<<<<<<< HEAD:src/in/shaycryptoco/SCCNcraft/Main.java
        new EcoAdmin(this);
        new EcoBalance(this);
        new EcoPay(this);
        StartMessage.logMessage();
        
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        
=======
        getCommand("bal").setExecutor(new EcoBalance());
        getCommand("balance").setExecutor(new EcoBalance());
        getCommand("eco").setExecutor(new EcoAdmin());
        getCommand("pay").setExecutor(new EcoPay());
>>>>>>> parent of 56fab69... Diamond mining reward:src/main/java/in/shaycryptoco/SCCNcraft/Main.java
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
