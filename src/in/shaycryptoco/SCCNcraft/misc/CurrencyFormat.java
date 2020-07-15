package in.shaycryptoco.SCCNcraft.misc;

import in.shaycryptoco.SCCNcraft.Main;
import net.milkbowl.vault.economy.Economy;

public class CurrencyFormat {

    public static String formatCurrency(double originalBalance) {

        Economy economy = Main.getEconomy();

        String finalBalance = economy.format(originalBalance).substring(1);
        return finalBalance;

    }

}
