package com.vqlt.nopiglinbrute;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoPiglinBrute extends JavaPlugin {

    private boolean brutesDisabled;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        brutesDisabled = getConfig().getBoolean("brutes-disabled");

        DisableBrutesCommand command = new DisableBrutesCommand(this);
        getCommand("disablebrutes").setExecutor(command);
        getCommand("disablebrutes").setTabCompleter(command);

        getServer().getPluginManager().registerEvents(new PiglinBruteSpawnListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean areBrutesDisabled() {
        return brutesDisabled;
    }

    public void setBrutesDisabled(boolean brutesDisabled) {
        this.brutesDisabled = brutesDisabled;

        getConfig().set("brutes-disabled", brutesDisabled);
        saveConfig();
    }
}
