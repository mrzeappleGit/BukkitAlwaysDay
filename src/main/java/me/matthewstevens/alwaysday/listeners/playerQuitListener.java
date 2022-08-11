package me.matthewstevens.alwaysday.listeners;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class playerQuitListener implements Listener {

    boolean whenAnyone = AlwaysDay.whenAnyone;
    List<String> selectPlayer = AlwaysDay.selectPlayer;

    public void onPlayerQuit(PlayerQuitEvent e){
        if (whenAnyone && Bukkit.getOnlinePlayers().size() == 0){
            AlwaysDay.EnablePlayer = false;
        }else if(!whenAnyone){
            if (selectPlayer.contains(e.getPlayer().getDisplayName())) {
                Object[] onlinePlayers = Bukkit.getOnlinePlayers().toArray();
                boolean selectedStill = false;
                for(int i = 0; i < Bukkit.getOnlinePlayers().size(); i++){
                    if (selectPlayer.contains(onlinePlayers[i])) {
                        selectedStill = true;
                    }
                }
                if(!selectedStill) {
                    AlwaysDay.EnablePlayer = false;
                }
            }
        }

    }
}