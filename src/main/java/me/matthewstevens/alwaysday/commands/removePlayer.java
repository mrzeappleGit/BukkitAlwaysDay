package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class removePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                if (args.length == 0) {
                    p.sendMessage("You did not provide anyone to add to the list.");
                    p.sendMessage("Example: /adremove <player name>");
                } else if (args.length > 1) {
                    p.sendMessage("You added too many arguments to the command.");
                    p.sendMessage("Example: /adremove <player name>");
                } else {
                    if(AlwaysDay.selectPlayer.contains(args[0])) {
                        AlwaysDay.selectPlayer.remove(args[0]);
                        p.sendMessage("[AlwaysDay] Will no longer change when player " + args[0] + " is online");
                        plugin.getConfig().set("list-of-players", AlwaysDay.selectPlayer);
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