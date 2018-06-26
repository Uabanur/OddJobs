package uabanur.firstgame.states;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.inventory.Inventory;

public class InventoryState extends State {
	
	private Inventory inventory;

	public InventoryState(Handler handler) {
		super(handler);
		inventory = new Inventory(handler);
		inventory.init();
	}

	@Override
	public void tick() {
		inventory.tick();
	}

	@Override
	public void render(Graphics g) {
		inventory.render(g);
		
	}

}
