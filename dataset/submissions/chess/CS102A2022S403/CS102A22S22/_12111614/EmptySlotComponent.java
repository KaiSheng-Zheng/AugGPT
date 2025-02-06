import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

	
	
	

	public EmptySlotComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
		super(x, y, name, chessComponents);
		// TODO Auto-generated constructor stub
		setChessColor(ChessColor.NONE);
	}

	@Override
	public List<ChessboardPoint> canMoveTo() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

}
