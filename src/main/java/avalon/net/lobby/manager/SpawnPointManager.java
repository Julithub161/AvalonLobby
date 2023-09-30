package avalon.net.lobby.manager;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpawnPointManager {
    Location location = ConfigManager.get("spawn.world") != null ? new Location(Bukkit.getWorld(ConfigManager.get("spawn.world")), Double.parseDouble(ConfigManager.get("spawn.x")), Double.parseDouble(ConfigManager.get("spawn.y")), Double.parseDouble(ConfigManager.get("spawn.z")), Float.parseFloat(ConfigManager.get("spawn.yaw")), Float.parseFloat(ConfigManager.get("spawn.pitch"))) : null;
    public SpawnPointManager(String world, double x, double y, double z, float yaw, float pitch) {
        ConfigManager.set("spawn.world", world);
        ConfigManager.set("spawn.x", x);
        ConfigManager.set("spawn.y", y);
        ConfigManager.set("spawn.z", z);
        ConfigManager.set("spawn.yaw", yaw);
        ConfigManager.set("spawn.pitch", pitch);
    }
    public void teleportPlayer(Player p) {
        p.teleport(this.location);
    }
}
