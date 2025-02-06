import java.util.List;

abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
private ChessColor chessColor; // What's the color
protected char name; // What's the name

public ChessComponent(){}
    
public ChessComponent (ChessColor chessColor){}
    


public abstract List <ChessboardPoint> canMoveTo() ;


@Override
public String toString() {

 return String.valueOf(this.name);

}














}
