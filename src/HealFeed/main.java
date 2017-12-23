package HealFeed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class main extends JavaPlugin{

	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender,Command cmd,String CommandLable,String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage("請使用玩家身分輸入指令");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("heal")){//補血
			if(sender.hasPermission("heal")){
				if(args.length == 0){ 
					player.setHealth(player.getMaxHealth());
					player.sendMessage(ChatColor.GREEN + "已補滿您的血量！");
					return true;
				}
				Player traget = Bukkit.getServer().getPlayer(args[0]);
				if (traget == null){
					player.sendMessage(ChatColor.RED + "玩家 " +args[0] + " 不在線上");
				}else{
					traget.setHealth(traget.getMaxHealth());
					traget.sendMessage(ChatColor.GREEN + "已補滿您的血量");
					player.sendMessage(ChatColor.AQUA + "已補滿 " + traget.getName() + " 的血量");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED+"你沒有此指令的權限！");
				return true;
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("feed")){//補飽食
			if(sender.hasPermission("feed")){
				if(args.length == 0){ 
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN+"已補滿您的飽食度");
					return true;
				}
				Player traget = Bukkit.getServer().getPlayer(args[0]);
				if (traget == null){
					player.sendMessage(ChatColor.RED + "玩家 " + args[0] + " 不在線上");
				}else{
					traget.setFoodLevel(20);
					traget.sendMessage(ChatColor.GREEN + "已補滿您的飽食度");
					player.sendMessage(ChatColor.AQUA + "已補滿 " + traget.getName() + " 的飽食度");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED+"你沒有此指令的權限！");
				return true;
			}
		}		
		return true;
	}
}
