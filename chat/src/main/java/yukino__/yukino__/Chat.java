package yukino__.yukino__;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    public Yukino__ plugin;
    String Prefix;

    public Chat(Yukino__ pl) {
        this.plugin = pl;
        this.Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.Prefix"));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if (Commands.Insc.contains(p)) {
            e.setCancelled(true);
            Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(var5.hasNext()) {
                Player staff = (Player)var5.next();
                if (staff.hasPermission("staffchat.use")) {
                    staff.sendMessage(this.Prefix + " " + ChatColor.DARK_GRAY + p.getDisplayName() + ChatColor.YELLOW + " " + ">>" + " " + ChatColor.AQUA + msg);
                }
            }
        }

    }
}
