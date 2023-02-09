package lu.kainovaii.sypergame.example.status.waiting;

import lu.kainovaii.sypergame.game.objects.AbstractScoreboard;
import lu.kainovaii.sypergame.game.objects.GameTeam;
import lu.kainovaii.sypergame.game.status.StatusVariant;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class WaitingScoreboard extends AbstractScoreboard {
    public WaitingScoreboard(StatusVariant statusVariant) {
        super(statusVariant);
    }

    @Override
    public String getTitle() {
        return "&e&lWAITING";
    }

    @Override
    public ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();

        Random random = new Random();

        lines.add("   ");
        lines.add(""+random.nextInt(10));
        lines.add(""+random.nextInt(10));
        lines.add(" ");
        lines.add("&fPlayers: &c"+getStatusVariant().getAlivePlayers().size());
        lines.add("  ");
        lines.add("&e@BingulHan");

        return lines;
    }

    @Override
    public void onEnable() {
        GameTeam team = new GameTeam("Player", "&7", "&7");

        for (Player player : getStatusVariant().getAlivePlayers()) {
            team.getPlayers().add(player);
        }

        getTeams().add(team);


    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onUpdate() {
    }
}
