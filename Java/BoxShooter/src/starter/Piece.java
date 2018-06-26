package starter;

import java.awt.MouseInfo;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import starter.DamState.Player;

public class Piece {

	private Ellipse piece;
	private Ellipse ghost;

	public Player type;

	public Piece(int x, int y, int radius, Color color, Player type) {
		this.type = type;
		piece = new Ellipse(x, y, radius, radius);
		ghost = new Ellipse(x, y, radius, radius);
		piece.setFill(color);
		ghost.setFill(piece.getFill());
		ghost.setOpacity(0.2);
		View.add(ghost);
		View.add(piece);
		
		piece.setOnMouseReleased(event -> released(event));
		piece.setOnMouseDragged(event -> dragged(event));
		
	}

	public void released(MouseEvent event) {

		if (illegalMove()) {
			piece.setCenterX(ghost.getCenterX());
			piece.setCenterY(ghost.getCenterY());
		}

		ghost.setCenterX(piece.getCenterX());
		ghost.setCenterY(piece.getCenterY());

		if (DamState.turn == DamState.Player.player1) {
			DamState.turn = DamState.Player.player2;
		} else if (DamState.turn == DamState.Player.player2) {
			DamState.turn = DamState.Player.player1;
		}

	}

	private boolean illegalMove() {
		boolean check = false;

		// No intersecting pieces
		for (Piece p : DamState.getPieces()) {
			if (!p.piece.equals(piece)) {
				if (p.piece.getCenterX() == piece.getCenterX() && p.piece.getCenterY() == piece.getCenterY())
					check = true;
			}
		}

		// Player 1 can only move up
		if (type == Player.player1 && piece.getCenterY() - ghost.getCenterY() > 0) {
			check = true;
		}

		// Player 2 can only move down
		if (type == Player.player2 && piece.getCenterY() - ghost.getCenterY() < 0) {
			check = true;
		}

		// Kill enemy or move 1 diagonally
		if (!check && (Math.abs(piece.getCenterX() - ghost.getCenterX()) != DamState.getTileSize()
				|| Math.abs(piece.getCenterY() - ghost.getCenterY()) != DamState.getTileSize())) {

			check = true;

			if (Math.abs(piece.getCenterX() - ghost.getCenterX()) == 2 * DamState.getTileSize()
					&& Math.abs(piece.getCenterY() - ghost.getCenterY()) == 2 * DamState.getTileSize()) {

				for (int i = DamState.getPieces().size() - 1; i >= 0; i--) {
					if (DamState.getPieces().get(i).piece.getCenterX() == ghost.getCenterX() + (piece.getCenterX() - ghost.getCenterX()) / 2
							&& DamState.getPieces().get(i).piece.getCenterY() == ghost.getCenterY() + (piece.getCenterY() - ghost.getCenterY()) / 2
							&& DamState.getPieces().get(i).type != this.type) {

						check = false;
						jumped(i);
						break;
					}
				}
			}
		}

		return check;
	}

	private void jumped(int i) {
		View.remove(DamState.getPieces().get(i).getPiece());
		View.remove(DamState.getPieces().get(i).getGhost());
		DamState.getPieces().remove(DamState.getPieces().get(i));

	}

	public Ellipse getPiece() {
		return piece;
	}

	public Ellipse getGhost() {
		return ghost;
	}

	public void dragged(MouseEvent event) {
		piece.setCenterX((int) event.getSceneX() / DamState.getTileSize() * DamState.getTileSize() + DamState.getPieceRadius());
		piece.setCenterY((int) event.getSceneY() / DamState.getTileSize() * DamState.getTileSize() + DamState.getPieceRadius());
	}

}
