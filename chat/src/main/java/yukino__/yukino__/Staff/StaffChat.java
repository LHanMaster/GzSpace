package yukino__.yukino__.Staff;

import java.util.Iterator;

import org.bukkit.Bukkit;
import yukino__.yukino__.Yukino__;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat implements Listener {
    public Yukino__ plugin;
    String Prefix;

    public StaffChat(Yukino__ pl) {
        this.plugin = pl;
        this.Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.Prefix"));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if (StaffCommands.Insc.contains(p)) {
            e.setCancelled(true);
            Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(var5.hasNext()) {
                Player staff = (Player)var5.next();
                if (staff.hasPermission("Staffchat.use")) {
                    staff.sendMessage(this.Prefix + " " + ChatColor.RED + p.getDisplayName() + ChatColor.YELLOW + " " + ">>" + " " + ChatColor.WHITE + msg);
                }
            }
        }

    }
}
