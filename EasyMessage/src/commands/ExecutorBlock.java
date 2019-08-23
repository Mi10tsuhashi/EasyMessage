package commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import location.ClosestPlayer;

public class ExecutorBlock implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if(sender instanceof BlockCommandSender) {
        	BlockCommandSender block = (BlockCommandSender)sender;
        	Location loc = block.getBlock().getLocation();
        	Player player = ClosestPlayer.calc(loc);
        	String message = ChatColor.GREEN+"Hello, "+player.getName()+".";
        	if(args.length!=0) {
        		StringBuilder sb = new StringBuilder(args[0]);
        		for(int i =1; i <= args.length-1; i++) {
        			sb.append(" ");
        			sb.append(args[i]);
        		}
        		message = sb.toString();
        		message = message.replace("[name]", player.getName());
        		message = message.replace("&","§");
        	}
        	player.sendMessage(message);
        	return true;
        }
		return false;

	}

}
