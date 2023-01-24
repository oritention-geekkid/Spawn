package cn.org.oritention.mc.spawn.commands;

import cn.org.oritention.mc.spawn.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawnn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ((Player) sender).teleport(Config.spawnpoint);
            sender.sendMessage(ChatColor.GRAY+"Teleporting you to the spawnpoint...");
        }
        return false;
    }
}
