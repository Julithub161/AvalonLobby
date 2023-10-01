package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.listener.ConnectionListener;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.build")) {
                if(Lobby.build.contains(p)) {
                    Lobby.build.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Lobby.prefix + "§cDu bist nun nicht mehr im Bau-Modus!");
                    ConnectionListener.setLobbyItems(p);
                    Lobby.playMessageSound(p);
                } else {
                    Lobby.build.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Bau-Modus!");
                    p.getInventory().clear();
                    Lobby.playMessageSound(p);
                }
            } else
                p.sendMessage(Lobby.noPerm);
         }
        return false;
    }
}
