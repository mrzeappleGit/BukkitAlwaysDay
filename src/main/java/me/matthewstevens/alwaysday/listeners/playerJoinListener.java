package me.matthewstevens.alwaysday.listeners;

import me.matthewstevens.alwaysday.AlwaysDay;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class playerJoinListener implements Listener {

    boolean whenAnyone = AlwaysDay.whenAnyone;
    List<String> selectPlayer = AlwaysDay.selectPlayer;


    public void onPlayerJoin(PlayerJoinEvent e){


        if (whenAnyone){
            AlwaysDay.EnablePlayer = true;
        }else{
            if (selectPlayer.contains(e.getPlayer().getDisplayName())) {
                    AlwaysDay.EnablePlayer = true;
            }
        }

    }
}
