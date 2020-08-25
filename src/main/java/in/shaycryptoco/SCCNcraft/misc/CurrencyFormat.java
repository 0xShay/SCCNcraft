package in.shaycryptoco.SCCNcraft.misc;

import in.shaycryptoco.SCCNcraft.Main;
import net.milkbowl.vault.economy.Economy;

import java.text.DecimalFormat;

public class CurrencyFormat {

    public static String formatCurrency(double originalBalance) {

        Economy economy = Main.getEconomy();

        DecimalFormat formatter = new DecimalFormat("#,###.00");

        return formatter.format(originalBalance);

    }

}
