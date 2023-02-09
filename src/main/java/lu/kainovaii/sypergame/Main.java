package lu.kainovaii.sypergame;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;


    @Override
    public void onEnable() {

        instance=this;

        //GameVariant gameVariant = new GameTest("Test", this, true);

        getServer().getLogger().info("API is load");

    }

    @Override
    public void onDisable() {

    }

}
