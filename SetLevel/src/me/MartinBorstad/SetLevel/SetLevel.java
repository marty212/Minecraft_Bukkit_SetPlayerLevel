package me.MartinBorstad.SetLevel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetLevel extends JavaPlugin {
	//pretty obvious
	public void onDisable() {
		System.out.println("[SetLevel] disabled.");
	}
	public void onEnable() {
		System.out.println("[SetLevel] enabled.");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		try{
			if (cmd.getName().equalsIgnoreCase("setlevel") && (player == null || player.hasPermission("SetLevel.admin"))) {
				if (args.length > 0 && args.length < 3) {
					if(args.length == 1 && player != null) {
						int i = Integer.parseInt(args[0]);
						player.setLevel(i);
						return true;
					}
					else if (args.length > 1) {
						String s;
						int i;
						try {
							i = Integer.parseInt(args[0]);
							s = args[1];
						}
						catch (NumberFormatException e) {
							i = Integer.parseInt(args[1]);
							s = args[0];
						}
						for(Player p : getServer().getOnlinePlayers()) {
							if (p.getName().equalsIgnoreCase(s)) {
								p.setLevel((i));
								return true;
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
