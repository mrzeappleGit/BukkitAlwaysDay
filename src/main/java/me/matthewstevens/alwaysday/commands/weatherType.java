package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class weatherType implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                if (args.length == 0) {
                    p.sendMessage("You did not provide anyone to add to the list.");
                    p.sendMessage("Example: /adworld <world name>");
                } else if (args.length > 1) {
                    p.sendMessage("You added too many arguments to the command.");
                    p.sendMessage("Example: /adworld <world name>");
                } else {
                    switch (args[0].toLowerCase()){
                        case "clear":
                            AlwaysDay.weather = "clear";
                            p.sendMessage("[AlwaysDay] Will now change weather to sunny weather.");
                            plugin.getConfig().set("weather-type", AlwaysDay.weather);
                            plugin.saveConfig();
                            reloadConfig.loadVars();
                            break;
                        case "rain":
                            AlwaysDay.weather = "rain";
                            p.sendMessage("[AlwaysDay] Will now change weather to rainy weather.");
                            plugin.getConfig().set("weather-type", AlwaysDay.weather);
                            plugin.saveConfig();
                            reloadConfig.loadVars();
                            break;
                        case "thunder":
                            AlwaysDay.weather = "thunder";
                            p.sendMessage("[AlwaysDay] Will now change weather to thunder weather.");
                            plugin.getConfig().set("weather-type", AlwaysDay.weather);
                            plugin.saveConfig();
                            reloadConfig.loadVars();
                            break;
                        default:
                            p.sendMessage("Wrong weather type try: clear, rain, or thunder");
                            break;
                    }

                }
            }else {
                p.sendMessage("You do not have permission for this command.");
            }
        }
        return true;
    }
}