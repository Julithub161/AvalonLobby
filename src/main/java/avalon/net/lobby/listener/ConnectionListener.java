package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        setLobbyItems(p);
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §aist jetzt auch mit am Start!");
                break;
            case 1:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §ahat beschlossen, mitzuspielen!");
                break;
            case 2:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §amacht jetzt auch mit!");
                break;
            case 3:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §ahat bock auf ein paar Runden PvP!");
                break;
            case 4:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §aist bereit alle auseinander zu nehmen!");
                break;
            case 5:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §awill euch zeigen wo es lang geht!");
                break;
            case 6:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §ahat sein Schwert schon bereit!");
                break;
            case 7:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §aleistet euch jetzt Gesellschaft!");
                break;
            case 8:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §aist jetzt mit dabei!");
                break;
            case 9:
                e.setJoinMessage(Lobby.prefix + p.getName() + " §awill euch zeigen was er drauf hat!");
                break;
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat sich vom Acker gemacht!");
                break;
            case 1:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat kein Bock mehr!");
                break;
            case 2:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §cist jetzt wieder allein!");
                break;
            case 3:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat jetzt keine Lust mehr!");
                break;
            case 4:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat jetzt besseres zu tun!");
                break;
            case 5:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §cist geragequitet!");
                break;
            case 6:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §cist nun nicht mehr bei uns!");
                break;
            case 7:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat die Schnauze voll!");
                break;
            case 8:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §chat genug gekämpft!");
                break;
            case 9:
                e.setQuitMessage(Lobby.prefix + p.getName() + " §cruht sich jetzt aus!");
                break;
        }
    }
    public static void setLobbyItems(Player p) {
        ItemBuilder playerHide = new ItemBuilder(Material.GLOWSTONE_DUST);
        playerHide.setName("§dSpieler verstecken");
        p.getInventory().setItem(4, playerHide);
    }
}
