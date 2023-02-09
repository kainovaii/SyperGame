package lu.kainovaii.sypergame.example;

import lombok.Getter;
import lu.kainovaii.sypergame.game.GameVariant;
import lu.kainovaii.sypergame.game.objects.GamePlayer;

public class ExamplePlayer extends GamePlayer {

    @Getter
    private int coin = 1000;

    public ExamplePlayer(String name, GameVariant game) {
        super(name, game);
    }


}
