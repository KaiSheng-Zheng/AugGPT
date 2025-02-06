import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

	

	public RookChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		int row=getSource().getX();
		int col=getSource().getY();
		
		for (int i = row-1; i >=0; i--) {
			if (chessComponents[i][col].getChessColor()!=getChessColor()) {
				arrayList.add(0,new ChessboardPoint(i, col));
				if (chessComponents[i][col].getChessColor()!=ChessColor.NONE) {
					break;
				}
			}else {
				break;
			}
		}
		
		for (int i = row+1; i <8; i++) {
			if (chessComponents[i][col].getChessColor()!=getChessColor()) {
				arrayList.add(new ChessboardPoint(i, col));
				if (chessComponents[i][col].getChessColor()!=ChessColor.NONE) {
					break;
				}
			}else {
				break;
			}
		}
		
		for (int i = col+1; i <8; i++) {
			if (chessComponents[row][i].getChessColor()!=getChessColor()) {
				arrayList.add(new ChessboardPoint(row, i));
				if (chessComponents[row][i].getChessColor()!=ChessColor.NONE) {
					break;
				}
			}else {
				break;
			}
		}
		int loc=arrayList.size();
		for (int i = col-1; i >=0; i--) {
			if (chessComponents[row][i].getChessColor()!=getChessColor()) {
				arrayList.add(loc,new ChessboardPoint(row, i));
				if (chessComponents[row][i].getChessColor()!=ChessColor.NONE) {
					break;
				}
			}else {
				break;
			}
		}
		return arrayList;
	}

}
