package com.technoguyfication.discordlink;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.permission.Permission;

public class DiscordLink extends JavaPlugin {
    private Plugin vaultPlugin = null;

    @Override
    public void onDisable() {
        // Don't log disabling, Spigot does that for you automatically!
    }

    @Override
    public void onEnable() {
        // Don't log enabling, Spigot does that for you automatically!
        vaultPlugin = getServer().getPluginManager().getPlugin("Vault");
        if (vaultPlugin == null) {
            getServer().getConsoleSender().sendMessage("Vault is required for this plugin to function!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        // Commands enabled with following method must have entries in plugin.yml
        getCommand("discordlink").setExecutor(new DiscordLinkCommand(this));
    }

    public Plugin getVault() {
        return vaultPlugin;
    }
}