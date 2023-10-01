package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("lobby.vanish")) {
            if(args.length == 0) {
                if(!Lobby.vanish.contains(p)) {
                    Lobby.vanish.add(p);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Vanish!");
                    for(Player all : p.getServer().getOnlinePlayers()) {
                        if(!all.hasPermission("lobby.vanishbypass")) {
                            all.hidePlayer(p);
                        }
                    }
                } else {
                    Lobby.vanish.remove(p);
                    p.sendMessage(Lobby.prefix + "§cDu bist nun nicht mehr im Vanish!");
                    for(Player all : p.getServer().getOnlinePlayers()) {
                        all.showPlayer(p);
                    }
                }
            } else {
                p.sendMessage(Lobby.prefix + "§cBenutze /vanish");
            }
        } else {
            p.sendMessage(Lobby.noPerm);
        }
        return false;
    }
}
