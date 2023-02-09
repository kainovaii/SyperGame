package lu.kainovaii.sypergame.game.util;

import lu.kainovaii.sypergame.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerUtil {

    /**
     * Deletes player's inventory, sets, restores health and hunger
     */
    public static void reload(Player player) {
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getInventory().clear();
        player.getEquipment().setHelmet(null);
        player.getEquipment().setChestplate(null);
        player.getEquipment().setLeggings(null);
        player.getEquipment().setBoots(null);
    }

    public static void respawn(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.spigot().respawn();

        Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), () -> {

            player.setGameMode(GameMode.SURVIVAL);
        }, 5);
    }
}
