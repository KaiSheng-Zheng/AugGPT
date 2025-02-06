import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

	

	public PawnChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		int dir=1;
		if (getChessColor()==ChessColor.WHITE) {
			dir=-1;
		}
		int row=getSource().getX();
		int col=getSource().getY();
		 
		if (chessComponents[row+dir][col-1].getChessColor()!=ChessColor.NONE&&
				chessComponents[row+dir][col-1].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(row+dir, col-1));
			
		}
		if (chessComponents[row+dir][col].getChessColor()==ChessColor.NONE) {
			arrayList.add(new ChessboardPoint(row+dir, col));
		}
		if (chessComponents[row+dir][col+1].getChessColor()!=ChessColor.NONE&&
				chessComponents[row+dir][col+1].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(row+dir, col+1));
			
		}
		if (chessComponents[row+dir][col].getChessColor()==ChessColor.NONE&&
				chessComponents[row+dir*2][col].getChessColor()==ChessColor.NONE) {
			arrayList.add(new ChessboardPoint(row+dir*2, col));
		}
		return arrayList;
	}

}
