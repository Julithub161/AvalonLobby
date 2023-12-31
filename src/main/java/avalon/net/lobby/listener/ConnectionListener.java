package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ConnectionListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        setLobbyItems(p);
        setScoreboard(p);
        p.setGameMode(GameMode.SURVIVAL);
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §aist jetzt auch mit am Start!");
                break;
            case 1:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §ahat beschlossen, mitzuspielen!");
                break;
            case 2:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §amacht jetzt auch mit!");
                break;
            case 3:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §ahat bock auf ein paar Runden PvP!");
                break;
            case 4:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §aist bereit alle auseinander zu nehmen!");
                break;
            case 5:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §awill euch zeigen wo es lang geht!");
                break;
            case 6:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §ahat sein Schwert schon bereit!");
                break;
            case 7:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §aleistet euch jetzt Gesellschaft!");
                break;
            case 8:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §aist jetzt mit dabei!");
                break;
            case 9:
                e.setJoinMessage(Lobby.prefix + p.getDisplayName() + " §awill euch zeigen was er drauf hat!");
                break;
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        int random = (int) (Math.random() * 10);
        switch (random) {
            case 0:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat sich vom Acker gemacht!");
                break;
            case 1:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat kein Bock mehr!");
                break;
            case 2:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §cist jetzt wieder allein!");
                break;
            case 3:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat jetzt keine Lust mehr!");
                break;
            case 4:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat jetzt besseres zu tun!");
                break;
            case 5:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §cist geragequitet!");
                break;
            case 6:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §cist nun nicht mehr bei uns!");
                break;
            case 7:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat die Schnauze voll!");
                break;
            case 8:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §chat genug gekämpft!");
                break;
            case 9:
                e.setQuitMessage(Lobby.prefix + p.getDisplayName() + " §cruht sich jetzt aus!");
                break;
        }
    }
    public static String hideItemName = "§6Spieler verstecken";
    public static String navigatorItemName = "§6Navigator";
    public static void setLobbyItems(Player p) {
        ItemStack playerHide = new ItemBuilder(Material.WATCH).name(hideItemName).build();
        p.getInventory().setItem(3, playerHide);
        ItemStack navigator = new ItemBuilder(Material.COMPASS).name(navigatorItemName).build();
        p.getInventory().setItem(5, navigator);
    }
    public void setScoreboard(Player p) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("§dAvalon§5MC§deu", "");

        // Setzen des Anzeigebereichs im Scoreboard
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Beispielwerte für das Scoreboard
        Score serverNameScore = objective.getScore("§b§lDein Rang:");
        serverNameScore.setScore(3);

        Score serverNameValue = objective.getScore("§7Spieler");
        serverNameValue.setScore(2);

        Score coinsScore = objective.getScore("§b§lCoins:");
        coinsScore.setScore(1);

        Score coinsValue = objective.getScore("§70");
        coinsValue.setScore(0);

        p.setScoreboard(scoreboard);
    }
}
