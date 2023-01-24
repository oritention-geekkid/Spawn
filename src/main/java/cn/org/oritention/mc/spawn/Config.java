package cn.org.oritention.mc.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Config {
    // Class Definition for Config
    static Plugin plugin = cn.org.oritention.mc.spawn.Spawn.getProvidingPlugin(cn.org.oritention.mc.spawn.Spawn.class);
    static File spawnpointFile = new File(plugin.getDataFolder(), "spawnpoint.yml");
    static FileConfiguration spawnpointConfig = YamlConfiguration.loadConfiguration(spawnpointFile);
    public static Location spawnpoint;

    // To get boolean value from config
    public static boolean getConfigB(String key) {
        return plugin.getConfig().getBoolean(key);
    }

    // To get String value from config
    public static String getConfigS(String key) {
        return plugin.getConfig().getString(key);
    }

    // To get int value from config
    public static int getConfigI(String key) {
        return plugin.getConfig().getInt(key);
    }

    // To get DamageCause from config
    public static List<String> getConfigStringLst(String key) {
        return plugin.getConfig().getStringList(key);
    }

    // To write Spawnpoint to config
    public static void writeSpawnpoint (Location l) throws IOException, InvalidConfigurationException {
        spawnpointConfig.set("spawnpoint.world", Objects.requireNonNull(l.getWorld()).getName());
        spawnpointConfig.set("spawnpoint.x",l.getX());
        spawnpointConfig.set("spawnpoint.y",l.getY());
        spawnpointConfig.set("spawnpoint.z",l.getZ());
        spawnpointConfig.set("spawnpoint.yaw",l.getYaw());
        spawnpointConfig.set("spawnpoint.pitch",l.getPitch());
        spawnpointConfig.save(spawnpointFile);
        spawnpointConfig.load(spawnpointFile);
        Config.spawnpoint = readSpawnpoint();
    }

    // To read Spawnpoint from config
    public static Location readSpawnpoint () {
        World w = Bukkit.getWorld(Objects.requireNonNull(spawnpointConfig.getString("spawnpoint.world")));
        double x = spawnpointConfig.getDouble("spawnpoint.x");
        double y = spawnpointConfig.getDouble("spawnpoint.y");
        double z = spawnpointConfig.getDouble("spawnpoint.z");
        float yaw = (float) spawnpointConfig.getDouble("spawnpoint.yaw");
        float pitch = (float) spawnpointConfig.getDouble("spawnpoint.pitch");
        return new Location(w,x,y,z,yaw,pitch);
    }
}