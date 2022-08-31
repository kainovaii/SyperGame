package online.bingulhan.minigameapi.example.status.waiting;

import online.bingulhan.minigameapi.game.status.StatusListener;
import online.bingulhan.minigameapi.game.status.StatusVariant;
import online.bingulhan.minigameapi.game.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class WaitingListener extends StatusListener {

    public WaitingListener(StatusVariant status, String name) {
        super(status, name);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!isGamePlayer(event.getPlayer().getName())) return;

        PlayerUtil.reload(event.getPlayer());

        event.setJoinMessage(null);

        getStatus().injectScoreboard(true);


        getStatus().sendMessageAll(ChatColor.GREEN +""+event.getPlayer().getName()+" joined the arena!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        //Use to add players
        getStatus().getGameVariant().addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!isGamePlayer(event.getPlayer().getName())) return;

        //How to terminate a state
        getStatus().stop();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!isGamePlayer(event.getPlayer().getName())) return;

        //example event.
    }

}