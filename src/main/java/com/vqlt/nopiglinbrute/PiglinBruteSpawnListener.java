package com.vqlt.nopiglinbrute;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class PiglinBruteSpawnListener implements Listener {
    @EventHandler
    public void onPiglinBruteSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.PIGLIN_BRUTE) {
            if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) {
                event.setCancelled(true);
            }
        }
    }
}
