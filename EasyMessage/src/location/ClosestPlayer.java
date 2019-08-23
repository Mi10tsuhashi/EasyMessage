package location;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import main.EasyMessage;

public class ClosestPlayer {
    private static EasyMessage plugin = EasyMessage.getPlugin();
    public static Player calc(Location loc) {
    	double min = Double.MAX_VALUE;
    	int index = -1;
    	List<Player> onlinePlayer = new ArrayList<>(plugin.getServer().getOnlinePlayers());
    	if(onlinePlayer.isEmpty()) {throw new IllegalArgumentException("player not found.");}
    	for(Player p: onlinePlayer) {
    		double distance = measure(loc,p);
    		if(distance <= min) {
    		min = distance;
    		index = onlinePlayer.indexOf(p);
    		}
    	}
    	return onlinePlayer.get(index);
    }

    private static Double measure(Location origin,Player player) {
        Location coordinate = player.getLocation();
        double coordinateX = coordinate.getX();
        double coordinateY = coordinate.getY();
        double coordinateZ = coordinate.getZ();
        double originX = origin.getX();
        double originY = origin.getY();
        double originZ = origin.getZ();
        double x= Math.pow(coordinateX-originX, 2);
        double y= Math.pow(coordinateY-originY, 2);
        double z= Math.pow(coordinateZ-originZ, 2);
        return x+y+z;
    }
}
