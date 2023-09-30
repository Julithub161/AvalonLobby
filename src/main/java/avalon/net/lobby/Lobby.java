package avalon.net.lobby;

import avalon.net.lobby.commands.BuildCommand;
import avalon.net.lobby.commands.ChatClearCommand;
import avalon.net.lobby.commands.FlyCommand;
import avalon.net.lobby.commands.SetSpawnCommand;
import avalon.net.lobby.listener.*;
import avalon.net.lobby.manager.ConfigManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Lobby extends JavaPlugin {

    public static String prefix = "§7[§bLobby§7] ";
    public static String noPerm = prefix + "§cDazu hast du keine Rechte!";

    public static ArrayList<Player> build = new ArrayList<>();

    public static Plugin plugin;

    @Override
    public void onEnable() {
        ConfigManager.createConfig();
        plugin = this;
        initListeners();
        initCommands();
    }

    @Override
    public void onDisable() {

    }

    private void initListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ProtectionListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new ConnectionListener(), this);
        pm.registerEvents(new LobbyItemInteractListener(), this);
        pm.registerEvents(new HideInventoryClickListener(), this);
        pm.registerEvents(new NavInventoryClickListener(), this);
    }
    private void initCommands() {
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("chatclear").setExecutor(new ChatClearCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
    }
    public static void playMessageSound(Player p) {
        p.playSound(p.getLocation(), Sound.LAVA_POP, 1.0f, 1.0f);
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
