package com.vqlt.nopiglinbrute;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisableBrutesCommand implements CommandExecutor, TabCompleter {

    private final NoPiglinBrute plugin;

    public DisableBrutesCommand(NoPiglinBrute plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage("§cUsage: /disablebrutes <true/false>");
            return true;
        }

        if (args[0].equalsIgnoreCase("true")) {
            plugin.setBrutesDisabled(true);
            sender.sendMessage("§aPiglin Brute spawning has been disabled.");
            return true;
        }

        if (args[0].equalsIgnoreCase("false")) {
            plugin.setBrutesDisabled(false);
            sender.sendMessage("§aPiglin Brute spawning has been enabled.");
            return true;
        }

        sender.sendMessage("§cPlease enter true or false.");
        return true;
    }

    @Override
    public List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String alias,
            @NotNull String[] args
    ) {
        if (args.length == 1) {
            return List.of("true", "false").stream()
                    .filter(option -> option.startsWith(args[0].toLowerCase()))
                    .toList();
        }

        return List.of();
    }
}