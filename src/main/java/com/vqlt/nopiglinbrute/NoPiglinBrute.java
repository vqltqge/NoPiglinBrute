package com.vqlt.nopiglinbrute;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoPiglinBrute extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PiglinBruteSpawnListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
