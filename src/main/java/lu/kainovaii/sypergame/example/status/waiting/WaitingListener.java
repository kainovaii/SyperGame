package lu.kainovaii.sypergame.example.status.waiting;

import lu.kainovaii.sypergame.example.ExamplePlayer;
import lu.kainovaii.sypergame.game.status.StatusListener;
import lu.kainovaii.sypergame.game.status.StatusVariant;
import lu.kainovaii.sypergame.game.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
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

        if (status.getScoreboard()!=null) {
            status.getScoreboard().update();
        }

        //Example Data
        ExamplePlayer playerData = ((ExamplePlayer) getPlayerData(event.getPlayer().getName()).get());
        event.getPlayer().sendMessage(ChatColor.GREEN+"Coin: "+playerData.getCoin());


        getStatus().sendMessageAll(ChatColor.GREEN +""+event.getPlayer().getName()+" joined the arena!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        //Use to add players
        getStatus().getGameVariant().addPlayer(event.getPlayer(), ExamplePlayer.class);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!isGamePlayer(event.getPlayer().getName())) return;

        //How to terminate a state
        getStatus().stop();

    }


}
