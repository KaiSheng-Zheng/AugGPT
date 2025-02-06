import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

	

	public KnightChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		int row=getSource().getX();
		int col=getSource().getY();
		int nr;
		int nc;
		
		nr=row-2;
		nc=col-1;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		nr=row-2;
		nc=col+1;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		nr=row-1;
		nc=col-2;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		nr=row-1;
		nc=col+2;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		
		nr=row+1;
		nc=col+2;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		nr=row+1;
		nc=col-2;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		nr=row+2;
		nc=col-1;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		nr=row+2;
		nc=col+1;
		if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
			arrayList.add(new ChessboardPoint(nr, nc));
		}
		
		
		return arrayList;
	}

}
