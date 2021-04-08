package dev.fireroz.xbroadcast;

import commands.CommandBroadcast;
import commands.CommandBroadcastPerm;
import commands.CommandReload;
import org.bukkit.plugin.java.JavaPlugin;

public final class XBroadcast extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registering commands
        getCommand("broadcast").setExecutor(new CommandBroadcast(this));
        getCommand("broadcastperm").setExecutor(new CommandBroadcastPerm(this));
        getCommand("bcreload").setExecutor(new CommandReload(this));


        // Creating config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

    }

}
