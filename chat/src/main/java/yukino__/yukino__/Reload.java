package yukino__.yukino__;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;



public class Reload implements CommandExecutor {
    private Yukino__ plugin;

    public Reload(Yukino__ pl) {
        this.plugin = pl;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("chatreload")) {
            if (!sender.hasPermission("chat.reload")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c您不配"));
                return true;
            }

            if (sender.hasPermission("chat.reload")) {
                this.plugin.reloadConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b纱布,插件重载完了"));
            }
        }

        return false;
    }
}
