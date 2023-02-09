package lu.kainovaii.sypergame.game.objects.task;

import lu.kainovaii.sypergame.game.objects.AbstractScoreboard;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardTask extends BukkitRunnable {

    private AbstractScoreboard scoreboard;

    private boolean stop = false;


    public ScoreboardTask(AbstractScoreboard scoreboard) {
        this.scoreboard = scoreboard;

    }

    @Override
    public void run() {
        if (stop) {
            cancel();
        }else {
            scoreboard.update();
        }

    }

    public void stop() {
        stop = true;
        cancel();
    }

    @Override
    public synchronized void cancel() throws IllegalStateException {
        super.cancel();
    }
}
