package me.matthewstevens.alwaysday.commands;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.matthewstevens.alwaysday.AlwaysDay.plugin;

public class reloadConfig implements CommandExecutor {



    public static void loadVars(){
        AlwaysDay.world = plugin.getConfig().getString("world-name");
        AlwaysDay.whenAnyone = plugin.getConfig().getBoolean("when-anyone-is-online");
        AlwaysDay.weatherControl = plugin.getConfig().getBoolean("weather-controlled");
        AlwaysDay.selectPlayer = plugin.getConfig().getStringList("list-of-players");
        AlwaysDay.weather = plugin.getConfig().getString("weather-type");
        AlwaysDay.timeControl = plugin.getConfig().getBoolean("time-controlled");
        AlwaysDay.timeChange = plugin.getConfig().getInt("time-to-change");
        AlwaysDay.timeSet = plugin.getConfig().getInt("time-to-set");
        AlwaysDay.EnablePlayer = false;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("alwaysday.admin")) {
                loadVars();
                p.sendMessage("[AlwaysDay] Config reloaded.");
            }else {
                p.sendMessage("You do not have permission for this command.");
            }
        }
        return true;
    }
}
