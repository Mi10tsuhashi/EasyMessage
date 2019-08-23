package main;

import org.bukkit.plugin.java.JavaPlugin;

import commands.ExecutorBlock;

public class EasyMessage extends JavaPlugin {

	public static EasyMessage plugin;

	@Override
	public void onEnable() {
		super.onEnable();
		plugin = this;
		getCommand("send").setExecutor(new ExecutorBlock());
	}
	public static EasyMessage getPlugin() {
			return plugin;
	}


}
