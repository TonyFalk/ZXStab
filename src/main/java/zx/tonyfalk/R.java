package zx.tonyfalk;

import org.bukkit.Bukkit;

public class R implements Runnable {
    Stabilizer plugin;

    public R(Stabilizer plugin) {
        this.plugin = plugin;
    }

    public static int TC = 0;
    public static long[] T = new long[600];

    public void run() {
        T[(TC% T.length)] = System.currentTimeMillis();
        TC+= 1;
    }

    public static double gT() {
        return gT(100);
    }

    public static double gT(int t) {
        if (TC < t) {
            return 1.0D;
        }
        int target = (TC - 1 - t) % T.length;
        long elapsed = System.currentTimeMillis() - T[target];

        return t / (elapsed / 1000.0D);
    }
}
