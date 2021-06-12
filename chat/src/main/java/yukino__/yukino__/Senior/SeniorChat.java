package yukino__.yukino__.Senior;

import java.util.Iterator;
import yukino__.yukino__.Yukino__;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SeniorChat implements Listener {
    public Yukino__ plugin;
    String Prefix;

    public SeniorChat(Yukino__ pl) {
        this.plugin = pl;
        this.Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("SeniorChat.Prefix"));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if (SeniorCommands.Insc.contains(p)) {
            e.setCancelled(true);
            Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

            while (var5.hasNext()) {
                Player staff = (Player) var5.next();
                if (staff.hasPermission("seniorchat.use")) {
                    staff.sendMessage(this.Prefix + " " + p.getDisplayName() + ChatColor.GREEN + " " + ">>" + " " + ChatColor.WHITE + msg);
                }
            }
        }


    }
}