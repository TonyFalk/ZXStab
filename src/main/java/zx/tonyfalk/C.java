package zx.tonyfalk;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C implements CommandExecutor {
    Stabilizer plugin;

    public C(Stabilizer plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("zxstabilizer").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("zxstabilizer")) {
            if (args.length > 0) {
                String subcmd = args[0];
                switch (subcmd){
                    case "restart":
                        int rt = this.plugin.getConfig().getInt("prerestarttime",30);
                        int rtt = rt * 20;
                        if (args[1] != null) {
                            try {
                                Integer.parseInt(args[1]);
                                rt = Integer.valueOf(args[1]);
                                U.mS(sender,"&aOperation done");
                                restart(rtt);
                            }catch (NumberFormatException e){
                                U.mS(sender,"&cWrong usage &a/" + cmd +" restart <timetillrestart>");
                                return false;
                            }
                        } else {
                            restart(rtt);
                        }
                    case "sysinfo":
                        U.mS(sender,"&d==============================================");
                        U.mS(sender,"&5Sysinfo");
                        U.mS(sender,"&aWORKERS-STATUS " + T.gM(3) + "&e/&a" + T.MW);
                        U.mS(sender, "&aMEMORY " + T.gM(0) + "&e/&a" + T.gM(1));
                        U.mS(sender,"&d==============================================");
                    default:
                        U.mS(sender,"&cWrong usage &a/" + cmd + "restart/sysinfo");
                }
            } else {
                U.mS(sender,"&cWrong usage &a/" + cmd + "restart/sysinfo");
            }
        }
        return false;
    }
    public void restart(long in) {
        U.mB(this.plugin.getConfig().getString("restartmessage").replace("%IN%",String.valueOf(in/20)));
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin,new Runnable() {
            public void run() {
                Bukkit.spigot().restart();
            }
        }, in+0L);
    }
}
