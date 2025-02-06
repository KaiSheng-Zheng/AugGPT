import java.util.*;
public class KingChessComponent extends ChessComponent{
	public KingChessComponent(){
		
	}
	public List<ChessboardPoint> canMoveTo(){
		ArrayList<ChessboardPoint> ret=new ArrayList<ChessboardPoint>();
		ret.add(source.offset(-1,-1));
		ret.add(source.offset(1,-1));
		ret.add(source.offset(-1,1));
		ret.add(source.offset(1,1));
		ret.add(source.offset(0,-1));
		ret.add(source.offset(-1,0));
		ret.add(source.offset(0,1));
		ret.add(source.offset(1,0));
		return ret;
	}
	@Override
	public String toString() {
		return String.valueOf(this.name);
	}
}