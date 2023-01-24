package cn.org.oritention.mc.spawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Listeners implements Listener {
    // PLayerJoinEvent
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        if (Config.getConfigB("JoinTPToggle")) {
            e.getPlayer().teleport(Config.spawnpoint);
        }
        if (Config.getConfigB("JoinClearItems")) {
            e.getPlayer().getInventory().clear();
        }
    }

    // EntityDamageEvent
    @EventHandler
    public void EntityDamageEvent(EntityDamageEvent e) {
        if (Config.getConfigB("VoidTPToggle")) {
            if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                e.setCancelled(true);
                e.getEntity().teleport(Config.spawnpoint);
            }
        }
    }

    // PlayerRespawnEvent
    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent e) {
        if (Config.getConfigB("RespawnTPToggle")) {
            e.getPlayer().teleport(Config.spawnpoint);
        }
    }
}
