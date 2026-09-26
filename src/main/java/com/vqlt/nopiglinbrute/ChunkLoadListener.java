package com.vqlt.nopiglinbrute;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkLoadListener implements Listener {

    private final NoPiglinBrute plugin;

    public ChunkLoadListener(NoPiglinBrute plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        if (!plugin.areBrutesDisabled()) {
            return;
        }

        for (Entity entity : event.getChunk().getEntities()) {
            if (entity.getType() == EntityType.PIGLIN_BRUTE) {
                entity.remove();
            }
        }
    }
}
