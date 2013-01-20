package ch.cloverdev.GetPosition;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPosition extends org.bukkit.plugin.java.JavaPlugin {

	Logger logger;

	public void onEnable() {
		logger = Logger.getLogger("Minecraft");
		logger.info("GetPosition has been enabled.");
	}

	public void onDisable() {
		logger.info("GetPosition has been disabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("showpos")) {
				String worldName = player.getWorld().getName();
				String position = String.valueOf(player.getLocation().getX())
						+ String.valueOf(player.getLocation().getY())
						+ String.valueOf(player.getLocation().getZ());
				player.sendMessage(ChatColor.GREEN + "Your Position in world "
						+ worldName + " is: " + position);
				return true;
			}
		} else {
			sender.sendMessage("You must be a player!");
			return false;
		}
		return false;
	}
}
