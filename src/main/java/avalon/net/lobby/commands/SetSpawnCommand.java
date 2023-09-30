package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.manager.SpawnPointManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    public static SpawnPointManager lobbySpawn;
    public static SpawnPointManager kitpvpSpawn;
    public static SpawnPointManager hcpvpSpawn;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            Lobby.playMessageSound(p);
            if(p.hasPermission("lobby.setspawn")) {
                if(args.length == 0) {
                    p.sendMessage(Lobby.prefix + "§cBitte benutze §e/setspawn [lobby/kitpvp/hcpvp]");
                } else if(args[0].equalsIgnoreCase("lobby")) {
                    lobbySpawn = new SpawnPointManager(p.getWorld().getName(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                    p.sendMessage(Lobby.prefix + "§aDer Spawnpunkt wurde gesetzt!");
                } else if(args[0].equalsIgnoreCase("kitpvp")) {
                    kitpvpSpawn = new SpawnPointManager(p.getWorld().getName(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                    p.sendMessage(Lobby.prefix + "§aDer Spawnpunkt wurde gesetzt!");
                } else if(args[0].equalsIgnoreCase("hcpvp")) {
                    hcpvpSpawn = new SpawnPointManager(p.getWorld().getName(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                    p.sendMessage(Lobby.prefix + "§aDer Spawnpunkt wurde gesetzt!");
                } else
                    p.sendMessage(Lobby.prefix + "§cUnbekannter Spawnpoint!");
            } else
                p.sendMessage(Lobby.noPerm);
        }
        return false;
    }
}
