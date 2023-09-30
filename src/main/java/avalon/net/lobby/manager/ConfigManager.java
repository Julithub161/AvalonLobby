package avalon.net.lobby.manager;

import avalon.net.lobby.Lobby;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    public static void createConfig() {
        if (!Lobby.getPlugin(Lobby.class).getDataFolder().exists()) {
            Lobby.getPlugin(Lobby.class).getDataFolder().mkdir();
        }
        File file = new File(Lobby.getPlugin(Lobby.class).getDataFolder(), "config.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage("§cConfig konnte nicht erstellt werden!");
            }
        }
    }
    public static void set(String path, Object value) {
        Lobby.getPlugin(Lobby.class).getConfig().set(path, value);
        Lobby.getPlugin(Lobby.class).saveConfig();
    }
    public static String get(String path) {
        return Lobby.getPlugin(Lobby.class).getConfig().getString(path);
    }
}