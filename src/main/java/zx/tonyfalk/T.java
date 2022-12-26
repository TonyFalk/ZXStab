package zx.tonyfalk;

import org.bukkit.Bukkit;

public class T {
    public static int MW = 0;
    public static long MM = 0;

    public static long gM(int s){
        Runtime rt = Runtime.getRuntime();
        long r = Long.MAX_VALUE;
        if (Long.MAX_VALUE == rt.maxMemory()) {
            Bukkit.getLogger().warning("ERROR404M");
            return 404;
        }
        switch (s){
            case 0:
                r = rt.maxMemory() - rt.freeMemory();
            case 1:
                r = rt.maxMemory();
            case 2:
                r = rt.freeMemory();
            case 3:
                r = rt.availableProcessors();
        }
        return r;
    }
    public static void sM(){
        MW = (int) gM(3);
        MM = gM(1);
    }
}
