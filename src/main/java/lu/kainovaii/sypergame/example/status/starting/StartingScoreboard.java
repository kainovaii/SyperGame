package lu.kainovaii.sypergame.example.status.starting;

import lu.kainovaii.sypergame.game.objects.AbstractScoreboard;
import lu.kainovaii.sypergame.game.objects.GameTeam;
import lu.kainovaii.sypergame.game.status.StatusVariant;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class StartingScoreboard extends AbstractScoreboard {
    public StartingScoreboard(StatusVariant statusVariant) {
        super(statusVariant);
    }

    @Override
    public String getTitle() {
        return "&e&lSTARTING!";
    }

    @Override
    public ArrayList<String> getLines() {

        ArrayList<String> lines = new ArrayList<>();

        lines.add("");
        lines.add("&fPlayers: &c"+getStatusVariant().getAlivePlayers().size());
        lines.add("  ");
        lines.add("&e@BingulHan");
        return lines;
    }

    @Override
    public void onEnable() {
        GameTeam team = new GameTeam("Player", "&c", "&c");

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
