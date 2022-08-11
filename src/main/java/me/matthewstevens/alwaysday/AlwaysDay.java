package me.matthewstevens.alwaysday;


import me.matthewstevens.alwaysday.commands.*;
import me.matthewstevens.alwaysday.listeners.playerJoinListener;
import me.matthewstevens.alwaysday.listeners.weatherListener;
import me.matthewstevens.alwaysday.tasks.NightToDay;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class AlwaysDay extends JavaPlugin {

    public static Logger log = Bukkit.getLogger();
    public static boolean EnablePlayer = false;

    public static AlwaysDay plugin;
    public static String world;
    public static boolean weatherControl;
    public static boolean whenAnyone;
    public static List<String> selectPlayer;
    public static String weather;
    public static boolean timeControl;
    public static int timeChange;
    public static int timeSet;


    @Override
    public void onEnable() {
        //config file setup
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        plugin = this;
        //initialize variables
        reloadConfig.loadVars();

        //Register Listeners
        getServer().getPluginManager().registerEvents(new playerJoinListener(), this);
        // Plugin startup logic
        BukkitTask changeToDay = new NightToDay().runTaskTimer(this, 0, 100);
        BukkitTask changeWeather = new weatherListener().runTaskTimer(this, 0, 100);

        //Register Commands
        getCommand("adreload").setExecutor(new reloadConfig());
        getCommand("adadd").setExecutor(new playerAdd());
        getCommand("adremove").setExecutor(new removePlayer());
        getCommand("adworld").setExecutor(new changeWorld());
        getCommand("adweather").setExecutor(new watchWeather());
        getCommand("adtime").setExecutor(new watchTime());
        getCommand("adanyone").setExecutor(new watchAnyone());
        getCommand("adweathertype").setExecutor(new weatherType());
        getCommand("adtimechange").setExecutor(new timeWatch());
    }

}
