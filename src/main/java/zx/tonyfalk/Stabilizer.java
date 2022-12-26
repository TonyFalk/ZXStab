package zx.tonyfalk;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Stabilizer extends JavaPlugin {
    public R r;
    public C c;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.r = new R(this);
        this.c = new C(this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, new R(this), 100L, 1L);
        T.sM();
    }
}
