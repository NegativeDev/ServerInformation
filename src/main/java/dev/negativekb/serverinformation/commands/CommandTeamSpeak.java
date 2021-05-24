package dev.negativekb.serverinformation.commands;

import dev.negativekb.baseplugin.ui.ICommand;
import dev.negativekb.baseplugin.util.ConfigUtils;
import dev.negativekb.baseplugin.util.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class CommandTeamSpeak extends ICommand {
    private final FileConfiguration config = new ConfigUtils("teamspeak").getConfig();

    public CommandTeamSpeak(String name, List<String> aliases) {
        super(name, aliases);

        this.playerOnly = config.getBoolean("settings.player-only", false);
        this.consoleOnly = config.getBoolean("settings.console-only", false);

        String perm = config.getString("settings.permission", "none");
        this.permissionNode = (perm.equals("none") ? "" : perm);
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        List<String> message = config.getStringList("message");

        message.forEach(s -> new Message(s).send(sender));
    }
}
