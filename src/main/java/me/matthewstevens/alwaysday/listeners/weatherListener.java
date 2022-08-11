package me.matthewstevens.alwaysday.listeners;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class weatherListener extends BukkitRunnable {
    public void run(){
        if(AlwaysDay.weatherControl && AlwaysDay.EnablePlayer){
            switch (AlwaysDay.weather){
                case "clear":
                    Bukkit.getWorld(AlwaysDay.world).setStorm(false);
                    Bukkit.getWorld(AlwaysDay.world).setThundering(false);
                    break;
                case "rain":
                    Bukkit.getWorld(AlwaysDay.world).setStorm(true);
                    Bukkit.getWorld(AlwaysDay.world).setThundering(false);
                    break;
                case "thunder":
                    Bukkit.getWorld(AlwaysDay.world).setStorm(true);
                    Bukkit.getWorld(AlwaysDay.world).setThundering(true);
                    break;
                default:
                    Bukkit.getWorld(AlwaysDay.world).setStorm(false);
                    Bukkit.getWorld(AlwaysDay.world).setThundering(false);
                    break;
            }

        }
    }

}
