package in.shaycryptoco.SCCNcraft.misc;

import org.bukkit.ChatColor;

public class StringFormatter {

    public static String capitalizeWord(String str){
        String words[]=str.split("_");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst.toLowerCase()+" ";
        }
        return capitalizeWord.trim();
    }

    public static String formatMobName(String str){
        String words[]=str.split("_");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst.toLowerCase()+" ";
        }
        String result = capitalizeWord.trim();

        if (result.equals("Zombie")) result = ChatColor.DARK_GREEN + result;
        if (result.equals("Skeleton")) result = ChatColor.GRAY + result;
        if (result.equals("Spider")) result = ChatColor.DARK_RED + result;
        if (result.equals("Cave Spider")) result = ChatColor.BLUE + result;
        if (result.equals("Silverfish")) result = ChatColor.GRAY + result;
        if (result.equals("Blaze")) result = ChatColor.GOLD + result;
        if (result.equals("Magma Cube")) result = ChatColor.DARK_RED + result;

        return result;
    }

}