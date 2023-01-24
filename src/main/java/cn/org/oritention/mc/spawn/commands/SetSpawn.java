package cn.org.oritention.mc.spawn.commands;

import cn.org.oritention.mc.spawn.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission(Config.getConfigS("SetSpawnPermission"))) {
                try {
                    Config.writeSpawnpoint(((Player) sender).getLocation());
                    sender.sendMessage(ChatColor.GREEN+"Spawnpoint was set successfully!");
                } catch (IOException | InvalidConfigurationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }
}
