import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {





    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        //ArrayList<ChessboardPoint> list=new ArrayList();
        this.list.clear();
        return list;
    }


    public void loadResource() throws IOException {
        //No resource!
    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }
}
