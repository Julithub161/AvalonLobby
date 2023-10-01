package avalon.net.lobby.commands;

import avalon.net.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.chatclear")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    for(int i = 0; i < 100; i++) {
                        if(!all.hasPermission("lobbby.chatclearbypass")) {
                            all.sendMessage("");
                        }
                    }
                    all.sendMessage(Lobby.prefix + "§7Der Chat wurde von §c" + p.getName() + " §7geleert!");
                }
            } else {
                p.sendMessage(Lobby.noPerm);
            }
        }
        return false;
    }
}
