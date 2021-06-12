package yukino__.yukino__;

import yukino__.yukino__.Staff.StaffChat;
import yukino__.yukino__.Staff.StaffCommands;
import yukino__.yukino__.Senior.SeniorChat;
import yukino__.yukino__.Senior.SeniorCommands;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Yukino__ extends JavaPlugin {
    public Yukino__() {
    }

    public void onEnable() {
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerEvents();
    }

    public void onDisable() {
    }

    public void registerCommands() {
        this.getCommand("sc").setExecutor(new Commands(this));
        this.getCommand("chatreload").setExecutor(new Reload(this));
        this.getCommand("seniorchat").setExecutor(new SeniorCommands(this));
        this.getCommand("staffchat").setExecutor(new StaffCommands(this));
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Chat(this), this);
        pm.registerEvents(new SeniorChat(this), this);
        pm.registerEvents(new StaffChat(this), this);
    }
}
