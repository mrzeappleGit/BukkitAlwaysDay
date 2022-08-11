package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class watchWeather implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                if (AlwaysDay.weatherControl) {
                    AlwaysDay.weatherControl = false;
                    p.sendMessage("[AlwaysDay] Weather will no longer change.");
                    plugin.getConfig().set("weather-controlled", AlwaysDay.weatherControl);
                    plugin.saveConfig();
                    reloadConfig.loadVars();
                } else if(!AlwaysDay.weatherControl) {
                    AlwaysDay.weatherControl = true;
                    plugin.getConfig().set("weather-controlled", AlwaysDay.weatherControl);
                    p.sendMessage("[AlwaysDay] Time will now change.");
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