package commands;

import dev.fireroz.xbroadcast.XBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadcastPerm implements CommandExecutor {

    private XBroadcast plugin;
    public CommandBroadcastPerm(XBroadcast pl) { plugin = pl; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("xbroadcast.bcperm")) {
            if(args.length < 2) {
                sender.sendMessage(ChatColor.RED + "/broadcastperm (permission) (message)\n" + ChatColor.RED
                        + "Example: /bcperm litebans.ban We have a player who might be hacking, hackerIGN432. Please go check them out.");

            } else {
                String message = String.join(" ", args[1]);
                String configmsg = plugin.getConfig().getString("broadcastperm");
                configmsg = configmsg.replace("{message}", message);
                Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', configmsg), args[0]);
                if(!sender.hasPermission(args[0])) {
                    sender.sendMessage(ChatColor.RED + "You don't have the permission that you entered in, but it was still broadcasted to the people who had it.");
                }
            }

        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("noperm")));
        }





        return true;
    }
}
