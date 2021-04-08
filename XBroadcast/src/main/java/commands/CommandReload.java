package commands;

import dev.fireroz.xbroadcast.XBroadcast;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor {
    private XBroadcast plugin;
    public CommandReload(XBroadcast pl) { plugin = pl; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("xbroadcast.reload")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&4xBroadcast&7] &cThe config has been reloaded."));

        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("noperm")));
        }





        return true;
    }
}
