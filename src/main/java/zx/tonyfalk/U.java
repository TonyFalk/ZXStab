package zx.tonyfalk;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class U {
    public static void mP(Player player, String message){
        player.sendMessage((message).replace("&","§"));
    }
    public static void mS(CommandSender sender, String message){
        sender.sendMessage((message).replace("&","§"));
    }
    public static void mB(String message){
        Bukkit.broadcastMessage((message).replace("&","§"));
    }
    public static void mA(String message){
        Bukkit.getOperators();
        for (OfflinePlayer player : Bukkit.getOperators()){
            if (player.isOnline()) {
                mP((Player) player,message);
            }
        }
    }
}
