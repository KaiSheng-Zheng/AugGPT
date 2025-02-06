import java.util.List;

public class PawnChessComponent extends ChessComponent {
  public PawnChessComponent(ChessColor color){
      this.setChessColor(color);
      if (color==ChessColor.WHITE) {
          this.name = 'p';
      }else if (color==ChessColor.BLACK){
          this.name = 'P';
      }else{
          this.name = '_';
      }
  }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}


