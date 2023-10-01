package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("lobby.gamemode")) {
            if(args.length == 0) {
                p.sendMessage(Lobby.prefix + "§cBitte gib einen Spielmodus an!");
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Spielmodus §eSurvival§a!");
                } else if(args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(org.bukkit.GameMode.CREATIVE);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Spielmodus §eCreative§a!");
                } else if(args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(org.bukkit.GameMode.ADVENTURE);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Spielmodus §eAdventure§a!");
                } else if(args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    p.sendMessage(Lobby.prefix + "§aDu bist nun im Spielmodus §eSpectator§a!");
                } else {
                    p.sendMessage(Lobby.prefix + "§cBitte gib einen gültigen Spielmodus an!");
                }
            } else {
                p.sendMessage(Lobby.prefix + "§cBitte gib nur einen Spielmodus an!");
            }
        } else {
            p.sendMessage(Lobby.prefix + "§cDu hast keine Rechte!");
        }
        return false;
    }
}
