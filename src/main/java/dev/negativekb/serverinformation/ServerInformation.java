package dev.negativekb.serverinformation;

import dev.negativekb.baseplugin.BasePluginAPI;
import dev.negativekb.baseplugin.util.FileUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ServerInformation extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        BasePluginAPI.setPlugin(this);

        loadFile("discord.yml");
        loadFile("forums.yml");
        loadFile("store.yml");
        loadFile("teamspeak.yml");

        CommandManager.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadFile(String name) {
        File file = new File(getDataFolder(), name);
        FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            FileUtils.loadResource(this, name);
        }

        try {
            fileConfig.load(file);
        } catch (Exception e3) {
            e3.printStackTrace();
        }

        for (String priceString : fileConfig.getKeys(false)) {
            fileConfig.set(priceString, fileConfig.getString(priceString));
        }
    }
}
