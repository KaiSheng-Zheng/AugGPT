import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;

public class ConcreteChessGame implements ChessGame {

	private ChessComponent[][] chessComponents = new ChessComponent[10][10];
	private ChessColor currentPlayer;

	static int[] numW = new int[10], numB = new int[10];

	public void loadChessGame(List<String> chessboard) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				switch (chessboard.get(i).charAt(j)) {
					case 'K':
						chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[1]++;
						break;
					case 'k':
						chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[1]++;
						break;
					case 'Q':
						chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[2]++;
						break;
					case 'q':
						chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[2]++;
						break;
					case 'R':
						chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[3]++;
						break;
					case 'r':
						chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[3]++;
						break;
					case 'B':
						chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[4]++;
						break;
					case 'b':
						chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[4]++;
						break;
					case 'N':
						chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[5]++;
						break;
					case 'n':
						chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[5]++;
						break;
					case 'P':
						chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
						numB[6]++;
						break;
					case 'p':
						chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
						numW[6]++;
						break;
					case '_':
						chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
						break;
				}
		}
		if (chessboard.get(8).charAt(0) == 'w')
			currentPlayer = ChessColor.WHITE;
		else
			currentPlayer = ChessColor.BLACK;
	}

	public ChessColor getCurrentPlayer() {
		return this.currentPlayer;
	}

	public ChessComponent getChess(int x, int y) {
		return chessComponents[x][y];
	}

	public String getChessboardGraph() {
		String tmp = "";
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				tmp += chessComponents[i][j].name;
			tmp += '\n';
		}
		return tmp;
	}

	public String getCapturedChess(ChessColor player) {
		String tmp = "";
		if (player == ChessColor.BLACK) {
			if (numB[1] < 1)
				tmp += "K 1\n";
			if (numB[2] < 1)
				tmp += "Q 1\n";
			if (numB[3] < 2)
				tmp += "R " + (2 - numB[3]) + "\n";
			if (numB[4] < 2)
				tmp += "B " + (2 - numB[4]) + "\n";
			if (numB[5] < 2)
				tmp += "N " + (2 - numB[5]) + "\n";
			if (numB[6] < 8)
				tmp += "P " + (8 - numB[6]) + "\n";
		} else {
			if (numW[1] < 1)
				tmp += "k 1\n";
			if (numW[2] < 1)
				tmp += "q 1\n";
			if (numW[3] < 2)
				tmp += "r " + (2 - numW[3]) + "\n";
			if (numW[4] < 2)
				tmp += "b " + (2 - numW[4]) + "\n";
			if (numW[5] < 2)
				tmp += "n " + (2 - numW[5]) + "\n";
			if (numW[6] < 8)
				tmp += "p " + (8 - numW[6]) + "\n";
		}
		return tmp;
	}

	class cmp implements Comparator<ChessboardPoint> {
		public int compare(ChessboardPoint A, ChessboardPoint B) {
			return A.getX() - A.getY() < B.getX() - B.getY() ? 1 : -1;
		}
	}

	public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
		ChessComponent chess = chessComponents[source.getX()][source.getY()];
		List<ChessboardPoint> canMovePoints = chess.canMoveTo();
		canMovePoints.sort(new cmp());
		return canMovePoints;
	}

	public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
		ChessComponent chess = chessComponents[sourceX][sourceY];
		ChessboardPoint to = new ChessboardPoint(targetX, targetY);
		List<ChessboardPoint> L = chess.canMoveTo();
		boolean mk = false;
		for (ChessboardPoint i : L) {
			if (i.getX() == targetX && i.getY() == targetY) {
				mk = true;
				break;
			}
		}
		if (mk == true)
			if (chess.getColor() == currentPlayer)
				if (chessComponents[targetX][targetY] instanceof EmptySlotComponent) {
					if (currentPlayer == ChessColor.BLACK)
						currentPlayer = ChessColor.WHITE;
					else
						currentPlayer = ChessColor.BLACK;
					chessComponents[targetX][targetY] = chess;
					chessComponents[sourceX][sourceY] = new EmptySlotComponent(to, ChessColor.NONE);
					return true;
				}
		return false;
	}

	public static void main(String args[]) {
		ConcreteChessGame G = new ConcreteChessGame();
		List<String> chessboard = new ArrayList<String>();
		chessboard.add("RNBQKBNR");
		chessboard.add("PPPPPPPP");
		chessboard.add("________");
		chessboard.add("________");
		chessboard.add("________");
		chessboard.add("________");
		chessboard.add("pppppppp");
		chessboard.add("rnbqkbnr");
		chessboard.add("b");
		G.loadChessGame(chessboard);
		G.moveChess(0, 1, 2, 2);
		System.out.print(G.getChessboardGraph());
	}

	class KingChessComponent extends ChessComponent {

		public KingChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'k' : 'K';
		}

		public List<ChessboardPoint> canMoveTo() {
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = super.getPoint().offset(1, 0);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(-1, 0);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(0, 1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(0, -1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			return tmp;
		}

	}

	class QueenChessComponent extends ChessComponent {

		public QueenChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'q' : 'Q';
		}

		public List<ChessboardPoint> canMoveTo() {
			int a = super.getPoint().getX(), b = super.getPoint().getY();
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = new ChessboardPoint();
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, 0);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, 0);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= 7 - b; i++) {
				to = super.getPoint().offset(0, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= b; i++) {
				to = super.getPoint().offset(0, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			return tmp;
		}

	}

	class RookChessComponent extends ChessComponent {

		public RookChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'r' : 'R';
		}

		public List<ChessboardPoint> canMoveTo() {
			int a = super.getPoint().getX(), b = super.getPoint().getY();
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = new ChessboardPoint();
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, 0);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, 0);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= 7 - b; i++) {
				to = super.getPoint().offset(0, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= b; i++) {
				to = super.getPoint().offset(0, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			return tmp;
		}

	}

	class BishopChessComponent extends ChessComponent {

		public BishopChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'b' : 'B';
		}

		public List<ChessboardPoint> canMoveTo() {
			int a = super.getPoint().getX();
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = new ChessboardPoint();
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= 7 - a; i++) {
				to = super.getPoint().offset(i, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			for (int i = 1; i <= a; i++) {
				to = super.getPoint().offset(-i, -i);
				if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
					tmp.add(to);
				else
					break;
			}
			return tmp;
		}

	}

	class KnightChessComponent extends ChessComponent {

		public KnightChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'n' : 'N';
		}

		public List<ChessboardPoint> canMoveTo() {
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = super.getPoint().offset(2, 1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(2, -1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(-2, -1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(-2, 1);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(1, 2);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(1, -2);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(-1, 2);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			to = super.getPoint().offset(-1, -2);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			return tmp;
		}

	}

	class PawnChessComponent extends ChessComponent {

		public PawnChessComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = super.getColor() == ChessColor.WHITE ? 'p' : 'P';
		}

		public List<ChessboardPoint> canMoveTo() {
			List<ChessboardPoint> tmp = new ArrayList<ChessboardPoint>();
			ChessboardPoint to = super.getPoint().offset(super.getColor() == ChessColor.WHITE ? -1 : 1, 0);
			if (to != null && chessComponents[to.getX()][to.getY()].name == '_')
				tmp.add(to);
			return tmp;
		}

	}

	class EmptySlotComponent extends ChessComponent {

		public EmptySlotComponent(ChessboardPoint s, ChessColor c) {
			this.Setsource(s);
			this.Setcolor(c);
			super.name = '_';
		}

		public List<ChessboardPoint> canMoveTo() {
			return new ArrayList<ChessboardPoint>();
		}

	}
}
