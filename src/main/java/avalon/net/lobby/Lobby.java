package avalon.net.lobby;

import avalon.net.lobby.listener.ProtectionListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {



    @Override
    public void onEnable() {
        initListeners();
    }

    @Override
    public void onDisable() {

    }

    private void initListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ProtectionListener(), this);
    }
}
