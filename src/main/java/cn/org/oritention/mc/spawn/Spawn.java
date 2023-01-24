package cn.org.oritention.mc.spawn;

import cn.org.oritention.mc.spawn.commands.SetSpawn;
import cn.org.oritention.mc.spawn.commands.Spawnn;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin Startup Notice
        noteOnConsole("[Spawn] Spawn-1.0 was loaded successfully!");
        // Event Register
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        // Config Load
        saveDefaultConfig();
        this.saveResource("spawnpoint.yml", false);
        Config.spawnpoint = Config.readSpawnpoint();
        // Command Load
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawnn());


    }

    @Override
    public void onDisable() {
        // Plugin Shutdown Notice
        noteOnConsole("[Spawn] Spawn-1.0 was unloaded successfully!");
    }

    public void noteOnConsole(String s) {
        // Note something on the console
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
