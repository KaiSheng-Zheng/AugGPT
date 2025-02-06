import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

	

	public KingChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		int row=getSource().getX();
		int col=getSource().getY();
		for (int i = -1; i <2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i==0&&j==0) {
					continue;
				}
				int nr=row+i;
				int nc=col+j;
				if (nr>=0&&nr<8&&nc>=0&&nc<8&&chessComponents[nr][nc].getChessColor()!=getChessColor()) {
					arrayList.add(new ChessboardPoint(nr, nc));
				}
				
			}
			
		}
		
		
		return arrayList;
	}

}
