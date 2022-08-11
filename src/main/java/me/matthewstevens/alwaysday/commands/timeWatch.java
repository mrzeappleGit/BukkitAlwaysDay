package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class timeWatch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                if (args.length == 0) {
                    p.sendMessage("You did not provide anyone to add to the list.");
                    p.sendMessage("Example: /adtimechange [max | min] <Time>");
                } else if (args.length > 2) {
                    p.sendMessage("You added too many arguments to the command.");
                    p.sendMessage("Example: /adtimechange [max | min] <Time>");
                } else {
                    if(args[0].equalsIgnoreCase("max")) {
                        AlwaysDay.timeChange = Integer.parseInt(args[1]);
                        p.sendMessage("[AlwaysDay] Time will no longer go past " + args[1]);
                        plugin.getConfig().set("time-to-change", AlwaysDay.timeChange);
                        plugin.saveConfig();
                        reloadConfig.loadVars();
                    }else if(args[0].equalsIgnoreCase("min")) {
                        AlwaysDay.timeChange = Integer.parseInt(args[1]);
                        p.sendMessage("[AlwaysDay] Time will be set to " + args[1]);
                        plugin.getConfig().set("time-to-set", AlwaysDay.timeSet);
                        plugin.saveConfig();
                        reloadConfig.loadVars();
                    }
                }
            }else {
                p.sendMessage("You do not have permission for this command.");
            }
        }
        return true;
    }
}