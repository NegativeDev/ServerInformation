package dev.negativekb.serverinformation;

import dev.negativekb.baseplugin.util.ConfigUtils;
import dev.negativekb.serverinformation.commands.CommandDiscord;
import dev.negativekb.serverinformation.commands.CommandForums;
import dev.negativekb.serverinformation.commands.CommandStore;
import dev.negativekb.serverinformation.commands.CommandTeamSpeak;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Collections;
import java.util.List;

public class CommandManager {

    public static void init() {
        FileConfiguration dConfig = new ConfigUtils("discord").getConfig();
        boolean dEnabled = dConfig.getBoolean("enabled", true);
        if (dEnabled) {
            String name = dConfig.getString("command", "discord");
            List<String> aliases = dConfig.getStringList("aliases");

            new CommandDiscord(name, (aliases == null || aliases.isEmpty() ? Collections.emptyList() : aliases));
        }

        FileConfiguration fConfig = new ConfigUtils("forums").getConfig();
        boolean fEnabled = fConfig.getBoolean("enabled", true);
        if (fEnabled) {
            String name = fConfig.getString("command", "forums");
            List<String> aliases = fConfig.getStringList("aliases");

            new CommandForums(name, (aliases == null || aliases.isEmpty() ? Collections.emptyList() : aliases));
        }

        FileConfiguration sConfig = new ConfigUtils("store").getConfig();
        boolean sEnabled = sConfig.getBoolean("enabled", true);
        if (sEnabled) {
            String name = sConfig.getString("command", "store");
            List<String> aliases = sConfig.getStringList("aliases");

            new CommandStore(name, (aliases == null || aliases.isEmpty() ? Collections.emptyList() : aliases));
        }

        FileConfiguration tConfig = new ConfigUtils("teamspeak").getConfig();
        boolean tEnabled = tConfig.getBoolean("enabled", true);
        if (tEnabled) {
            String name = tConfig.getString("command", "teamspeak");
            List<String> aliases = tConfig.getStringList("aliases");

            new CommandTeamSpeak(name, (aliases == null || aliases.isEmpty() ? Collections.emptyList() : aliases));
        }
    }
}
