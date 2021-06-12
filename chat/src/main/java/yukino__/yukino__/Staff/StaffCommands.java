package yukino__.yukino__.Staff;

import java.util.ArrayList;
import yukino__.yukino__.Yukino__;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommands implements CommandExecutor {
    public Yukino__ plugin;
    String Prefix;
    String Disabled;
    String Enabled;
    String NoPerm;
    public static ArrayList<Player> Insc = new ArrayList();

    public StaffCommands(Yukino__ pl) {
        this.plugin = pl;
        this.Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.Prefix"));
        this.Disabled = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.DisableMsg"));
        this.Enabled = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.Enable"));
        this.NoPerm = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("StaffChat.NoPermMsg"));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("staffchat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "你控制台你用你妈");
                return true;
            }

            Player p = (Player)sender;
            if (args.length == 0) {
                if (!p.hasPermission("Staffchat.use")) {
                    p.sendMessage(this.Color(this.NoPerm));
                    return true;
                }

                if (Insc.contains(p)) {
                    Insc.remove(p);
                    p.sendMessage(this.Color(this.Disabled));
                    return true;
                }

                Insc.add(p);
                p.sendMessage(this.Color(this.Enabled));
                return true;
            }

        }

        return false;
    }

    private String Color(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}

