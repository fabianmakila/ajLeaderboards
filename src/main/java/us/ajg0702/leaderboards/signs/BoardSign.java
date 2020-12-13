package us.ajg0702.leaderboards.signs;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;

import us.ajg0702.utils.spigot.LocUtils;

public class BoardSign {
	public Location location;
	public String board;
	public int position;
	
	public BoardSign(Location location, String board, int position) {
		this.location = location;
		this.board = board;
		this.position = position;
	}
	
	public Location getLocation() {
		return location;
	}
	public String getBoard() {
		return board;
	}
	public int getPosition() {
		return position;
	}
	
	public Sign getSign() {
		BlockState state = location.getBlock().getState();
		if(!(state instanceof Sign)) return null;
		
		return (Sign) state;
	}
	
	public void setText(String line1, String line2, String line3, String line4) {
		BlockState state = location.getBlock().getState();
		if(!(state instanceof Sign)) return;
		
		Sign sign = (Sign) state;
		sign.setLine(0, line1);
		sign.setLine(1, line2);
		sign.setLine(2, line3);
		sign.setLine(3, line4);
		sign.update();
	}
	
	public String serialize() {
		return LocUtils.locToString(location)+";"+board+";"+position;
	}
	
	public static BoardSign deserialize(String s) {
		String[] parts = s.split(";");
		Location loc = LocUtils.stringToLoc(parts[0]);
		String board = parts[1];
		int pos = Integer.valueOf(parts[2]);
		return new BoardSign(loc, board, pos);
	}
}
