package starter;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class DamState extends State {

	private final static int TILE_SIZE = 40;
	private final static int PIECE_RADIUS = TILE_SIZE / 2;
	private final int BOARD_SIZE = 11;

	public enum Player {
		player1, player2
	};

	public static Player turn;

	static ArrayList<Piece> pieces = new ArrayList<Piece>();

	@Override
	public void setup() {
		turn = Player.player1;

		for (int i = 0; i < BOARD_SIZE; i += 2)
			pieces.add(new Piece((i * 2 + 1) * PIECE_RADIUS, View.CANVAS_HEIGHT - PIECE_RADIUS, PIECE_RADIUS, Color.RED, Player.player1));

		for (int i = 0; i < BOARD_SIZE; i += 2)
			pieces.add(new Piece((i * 2 + 1) * PIECE_RADIUS, PIECE_RADIUS, PIECE_RADIUS, Color.BLUE, Player.player2));
	}

	@Override
	public void tick() {


	}

	@Override
	public void render(GraphicsContext gc) {
		drawBackground(gc);
	}

	@Override
	public void keyBoardPressed(KeyEvent event) {

	}

	@Override
	public void keyBoardReleased(KeyEvent event) {

	}

	private void drawBackground(GraphicsContext gc) {
		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
				if ((x + y) % 2 == 1)
					gc.setFill(Color.BLACK);
				else
					gc.setFill(Color.GRAY);

				gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
	}

	public static int getTileSize() {
		return TILE_SIZE;
	}

	public static int getPieceRadius() {
		return PIECE_RADIUS;
	}

	public static ArrayList<Piece> getPieces() {
		return pieces;
	}

	public static void removePiece(Piece p) {
		pieces.remove(p);

	}
}
