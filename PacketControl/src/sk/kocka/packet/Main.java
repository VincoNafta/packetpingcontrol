package sk.kocka.packet;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public static Main instancia;
	
	public void onEnable() {
		System.out.println("Plugin bol zapnutý")
		Check.inst2.SpustiKontrolu();
	}
	public void onDisable() {
		System.out.println("Plugin bol vypnutý");
	}
}
