package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §aist jetzt auch mit am Start!");
                break;
            case 1:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §ahat beschlossen, mitzuspielen!");
                break;
            case 2:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §amacht jetzt auch mit!");
                break;
            case 3:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §ahat bock auf ein paar Runden PvP!");
                break;
            case 4:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §aist bereit alle auseinander zu nehmen!");
                break;
            case 5:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §awill euch zeigen wo es lang geht!");
                break;
            case 6:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §ahat sein Schwert schon bereit!");
                break;
            case 7:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §aleistet euch jetzt Gesellschaft!");
                break;
            case 8:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §aist jetzt mit dabei!");
                break;
            case 9:
                e.setJoinMessage(Lobby.prefix + e.getPlayer().getName() + " §awill euch zeigen was er drauf hat!");
                break;
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat sich vom Acker gemacht!");
                break;
            case 1:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat kein Bock mehr!");
                break;
            case 2:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §cist jetzt wieder allein!");
                break;
            case 3:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat jetzt keine Lust mehr!");
                break;
            case 4:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat jetzt besseres zu tun!");
                break;
            case 5:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §cist geragequitet!");
                break;
            case 6:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §cist nun nicht mehr bei uns!");
                break;
            case 7:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat die Schnauze voll!");
                break;
            case 8:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §chat genug gekämpft!");
                break;
            case 9:
                e.setQuitMessage(Lobby.prefix + e.getPlayer().getName() + " §cruht sich jetzt aus!");
                break;
        }
    }
}
