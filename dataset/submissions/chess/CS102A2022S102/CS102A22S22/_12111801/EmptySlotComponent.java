import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

}
