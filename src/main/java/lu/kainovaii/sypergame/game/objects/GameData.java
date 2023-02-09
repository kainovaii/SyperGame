package lu.kainovaii.sypergame.game.objects;

import lombok.Getter;
import lu.kainovaii.sypergame.game.GameVariant;

@Getter
public class GameData {

    protected GameVariant game;

    public GameData(GameVariant game) {
        this.game=game;
    }

}
