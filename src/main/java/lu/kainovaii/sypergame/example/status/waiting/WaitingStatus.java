package lu.kainovaii.sypergame.example.status.waiting;

import lu.kainovaii.sypergame.game.GameVariant;
import lu.kainovaii.sypergame.game.status.StatusVariant;

public class WaitingStatus extends StatusVariant {

    public WaitingStatus(String name, GameVariant variant, boolean init) {
        super(name, variant, init);
    }

    public WaitingStatus(String name, GameVariant variant) {
        super(name, variant);
    }

    @Override
    protected void reset() {
        getGameVariant().getPlugin().getLogger().info("Arena resetting");
    }

    @Override
    protected void onEnable() {
        addListener(new WaitingListener(this, "Main"));

        setScoreboard(new WaitingScoreboard(this));

    }

    @Override
    protected void onDisable() {
        getGameVariant().nextState();
    }


    @Override
    public StatusVariant clone(Boolean init) {
        return new WaitingStatus(name, getGameVariant(), init);
    }
}
