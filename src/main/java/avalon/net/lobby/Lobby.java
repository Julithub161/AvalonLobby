package avalon.net.lobby;

import avalon.net.lobby.commands.BuildCommand;
import avalon.net.lobby.commands.ChatClearCommand;
import avalon.net.lobby.commands.FlyCommand;
import avalon.net.lobby.listener.ChatListener;
import avalon.net.lobby.listener.ConnectionListener;
import avalon.net.lobby.listener.ProtectionListener;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Lobby extends JavaPlugin {

    public static String prefix = "§7[§bLobby§7] ";
    public static String noPerm = prefix + "§cDazu hast du keine Rechte!";

    public static ArrayList<Player> build = new ArrayList<>();

    @Override
    public void onEnable() {
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
    }
    private void initCommands() {
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("chatclear").setExecutor(new ChatClearCommand());
    }
    public static void playMessageSound(Player p) {
        p.playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1.0f, 1.0f);
    }
}
