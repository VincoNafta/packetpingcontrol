package sk.kocka.packet;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Check {
	static Check inst2;
	private static ArrayList<String> blacklist = new ArrayList<String>();
	public void SpustiKontrolu() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instancia, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Kontrola();
				
			}
		}, 0, 20*10);
	}
	public void Kontrola() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			int ping = ((CraftPlayer) p).getHandle().ping;
				if (ping  > 150) {
					blacklist.add(p.getName());
					KickPing(p);
					Bukkit.getServer().getScheduler().runTaskLater(Main.instancia, new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							blacklist.remove(p.getName());
							
						}
					}, 20*30);
				}
				else {
				String hrac = p.getName();
					if(blacklist.contains(hrac) {
						blacklist.remove(hrac);
					}
				}
		}
	}
	private void KickPing(Player p) {
		for(int i=0; i< blacklist.size(); i++) {
			Integer pocet = 0;
			String hrac = p.getName();
			if(blacklist.get(i).equals(hrac)) {
				pocet++;
				if (pocet == 3) {
					blacklist.remove(hrac);
					p.kickPlayer("Boli ste vyhodený pre vysoký ping");
				}
			}
		}
	}
}
