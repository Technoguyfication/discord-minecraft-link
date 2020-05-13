package com.technoguyfication.discordlink;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordLinkCommand implements CommandExecutor {
    DiscordLink plugin;

    public DiscordLinkCommand(DiscordLink plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();

        if (!cmdName.equals("discordlink")) {
            return false;
        }

        sender.sendMessage(String.format("DiscordLink version: %s\nVault version: %s", plugin.getDescription().getVersion(), plugin.getVault().getDescription().getVersion()));

        return true;
    }
}