package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class watchAnyone implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                if (AlwaysDay.whenAnyone) {
                    AlwaysDay.whenAnyone = false;
                    p.sendMessage("[AlwaysDay] Will now only change with list of people.");
                    plugin.getConfig().set("when-anyone-is-online", AlwaysDay.whenAnyone);
                    plugin.saveConfig();
                    reloadConfig.loadVars();
                } else if(!AlwaysDay.whenAnyone) {
                    AlwaysDay.whenAnyone = true;
                    p.sendMessage("[AlwaysDay] Will now change when anyone is online.");
                    plugin.getConfig().set("when-anyone-is-online", AlwaysDay.whenAnyone);
                    plugin.saveConfig();
                    reloadConfig.loadVars();
                }
            }else {
                p.sendMessage("You do not have permission for this command.");
            }
        }
        return true;
    }
}