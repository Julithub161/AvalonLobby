package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> flyMode = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.fly")) {
                if(flyMode.contains(p)) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(Lobby.prefix + "§7Du kannst nun nicht mehr fliegen!");
                    Lobby.playMessageSound(p);
                    flyMode.remove(p);
                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.teleport(p.getLocation().add(0, 0.5, 0));
                    p.sendMessage(Lobby.prefix + "§7Du kannst nun fliegen!");
                    Lobby.playMessageSound(p);
                    flyMode.add(p);
                }
            } else {
                p.sendMessage(Lobby.noPerm);
            }
        }
        return false;
    }
}
