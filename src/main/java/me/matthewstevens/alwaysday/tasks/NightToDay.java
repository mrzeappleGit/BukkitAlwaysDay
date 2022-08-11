package me.matthewstevens.alwaysday.tasks;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NightToDay extends BukkitRunnable {

    @Override
    public void run() {
        if (AlwaysDay.timeControl) {
            if (Bukkit.getWorld(AlwaysDay.world) != null) {
                if (AlwaysDay.timeChange > AlwaysDay.timeSet) {
                    if (AlwaysDay.EnablePlayer) {
                        if (Bukkit.getWorld(AlwaysDay.world).getTime() >= AlwaysDay.timeChange) {
                            Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                        }
                    } else if (Bukkit.getOnlinePlayers().size() > 0 && AlwaysDay.whenAnyone) {
                        AlwaysDay.EnablePlayer = true;
                        if (Bukkit.getWorld(AlwaysDay.world).getTime() >= AlwaysDay.timeChange) {
                            Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                        }
                    } else if (Bukkit.getOnlinePlayers().size() > 0) {
                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {

                            if (AlwaysDay.selectPlayer.contains(player.getDisplayName())) {
                                AlwaysDay.EnablePlayer = true;
                            }
                        }
                        if (AlwaysDay.EnablePlayer) {
                            if (Bukkit.getWorld(AlwaysDay.world).getTime() >= AlwaysDay.timeChange) {
                                Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                            }
                        }
                    }
                } else if (AlwaysDay.timeChange < AlwaysDay.timeSet) {
                    if (AlwaysDay.EnablePlayer) {
                        if (Bukkit.getWorld(AlwaysDay.world).getTime() <= AlwaysDay.timeChange) {
                            Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                        }
                    } else if (Bukkit.getOnlinePlayers().size() > 0 && AlwaysDay.whenAnyone) {
                        AlwaysDay.EnablePlayer = true;
                        if (Bukkit.getWorld(AlwaysDay.world).getTime() <= AlwaysDay.timeChange) {
                            Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                        }
                    } else if (Bukkit.getOnlinePlayers().size() > 0) {
                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {

                            if (AlwaysDay.selectPlayer.contains(player.getDisplayName())) {
                                AlwaysDay.EnablePlayer = true;
                            }
                        }
                        if (AlwaysDay.EnablePlayer) {
                            if (Bukkit.getWorld(AlwaysDay.world).getTime() <= AlwaysDay.timeChange) {
                                Bukkit.getWorld(AlwaysDay.world).setTime(AlwaysDay.timeSet);
                            }
                        }
                    }
                } else {
                    AlwaysDay.log.warning("[AlwaysDay] Time change to and Time set can't be the same time");
                }
            } else {
                AlwaysDay.log.warning("[AlwaysDay] Check config.yml for world name!");
            }
        }
    }
}
