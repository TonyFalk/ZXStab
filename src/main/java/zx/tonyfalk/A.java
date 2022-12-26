package zx.tonyfalk;

import org.bukkit.Bukkit;

public class A {
    Stabilizer plugin;

    public A(Stabilizer plugin) {
        this.plugin = plugin;
    }
    long nextcheck = this.plugin.getConfig().getLong("defaultcheck",3600);
    int serverheath = 0;

    public void AC() {
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin,new Runnable() {
            public void run() {
                double a1 = R.gT(600);
                if (a1 < 16) {
                    a1 = +1;
                }
                if ((T.gM(2) > T.gM(1)/4)){
                    a1 = +1;
                }
                if ((T.gM(3) > T.MW/4)) {
                    a1 = +1;
                }
                if (a1 <= 2){
                    nextcheck = (nextcheck/3)*2;
                    a1 = 0;
                    AC();
                }
                if (a1 == 3) {
                    plugin.c.restart(plugin.getConfig().getInt("prerestarttime",30));
                }
            }
        }, nextcheck+0L);
    }
}
