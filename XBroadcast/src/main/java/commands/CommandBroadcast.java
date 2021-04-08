package commands;

import dev.fireroz.xbroadcast.XBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandBroadcast implements CommandExecutor {
    private XBroadcast plugin;

    public CommandBroadcast(XBroadcast pl) { plugin = pl; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("xbroadcast.bc")) {
            if(args.length < 1) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/broadcast (message)"));
            } else {
                String message = String.join(" ", args);
                String configmsg = plugin.getConfig().getString("broadcast");
                configmsg = configmsg.replace("{message}", message);
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', configmsg));

            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("noperm")));
        }







        return true;
    }
}
