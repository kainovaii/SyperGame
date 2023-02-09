package lu.kainovaii.sypergame.example.status.starting;

import lu.kainovaii.sypergame.game.GameVariant;
import lu.kainovaii.sypergame.game.objects.GameGui;
import lu.kainovaii.sypergame.game.status.StatusVariant;
import lu.kainovaii.sypergame.game.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class StartingStatus extends StatusVariant {
    public StartingStatus(String name, GameVariant variant, boolean init) {
        super(name, variant, init);
    }

    public StartingStatus(String name, GameVariant variant) {
        super(name, variant);
    }

    @Override
    protected void reset() {

    }

    @Override
    protected void onEnable() {


        int lastSecond = 10;
        for (int i = 0; i < lastSecond; i++) {
            int finalI = i;
            addTimer(() -> {
                sendMessageAll("&eGame starts last "+(lastSecond - finalI)+" s");
                if (finalI == lastSecond-1) {
                    onDisable();
                }
            }, i);

        }

        getAlivePlayers().stream().forEach( player -> {


            new GameGui.GuiBuilder().addItem(new ItemBuilder(Material.STONE).setDisplayName(ChatColor.RED+"Click me").build(), 4, (p) -> {
                p.sendMessage(ChatColor.RED+"You clicked stone!");
            }).setTimer(10).setPlayer(player).setTitle("Test Gui").build().onEnable();




        });


        setScoreboard(new StartingScoreboard(this));


    }

    @Override
    protected void onDisable() {
        getGameVariant().nextState();
    }

    @Override
    public StatusVariant clone(Boolean init) {
        return new StartingStatus(name, getGameVariant(), true);
    }
}
