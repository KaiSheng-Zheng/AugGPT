import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

	
	
	public BishopChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		int row=getSource().getX();
		int col=getSource().getY();
		for (int i = 1; i <8; i++) {
			int nr=row+i;
			int nc=col-i;
			if (nr>=0&&nr<8&&nc>=0&&nc<8) {
				if (chessComponents[nr][nc].getChessColor()==ChessColor.NONE) {
					arrayList.add(new ChessboardPoint(nr, nc));
				} else if(chessComponents[nr][nc].getChessColor()!=getChessColor()) {
					arrayList.add(new ChessboardPoint(nr, nc));
					break;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		for (int i = 1; i <8; i++) {
			int nr=row-i;
			int nc=col+i;
			if (nr>=0&&nr<8&&nc>=0&&nc<8) {
				if (chessComponents[nr][nc].getChessColor()==ChessColor.NONE) {
					arrayList.add(new ChessboardPoint(nr, nc));
				} else if(chessComponents[nr][nc].getChessColor()!=getChessColor()) {
					arrayList.add(new ChessboardPoint(nr, nc));
					break;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		for (int i = 1; i <8; i++) {
			int nr=row-i;
			int nc=col-i;
			if (nr>=0&&nr<8&&nc>=0&&nc<8) {
				if (chessComponents[nr][nc].getChessColor()==ChessColor.NONE) {
					arrayList.add(new ChessboardPoint(nr, nc));
				} else if(chessComponents[nr][nc].getChessColor()!=getChessColor()) {
					arrayList.add(new ChessboardPoint(nr, nc));
					break;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		for (int i = 1; i <8; i++) {
			int nr=row+i;
			int nc=col+i;
			if (nr>=0&&nr<8&&nc>=0&&nc<8) {
				if (chessComponents[nr][nc].getChessColor()==ChessColor.NONE) {
					arrayList.add(new ChessboardPoint(nr, nc));
				} else if(chessComponents[nr][nc].getChessColor()!=getChessColor()) {
					arrayList.add(new ChessboardPoint(nr, nc));
					break;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		Collections.sort(arrayList, new Comparator<ChessboardPoint>() {

			@Override
			public int compare(ChessboardPoint o1, ChessboardPoint o2) {
				// TODO Auto-generated method stub
				if (o1.getX()!=o2.getX()) {
					return o1.getX()-o2.getX();
				}
				return o1.getY()-o2.getY();
			}
		});
		return arrayList;
	}

}
