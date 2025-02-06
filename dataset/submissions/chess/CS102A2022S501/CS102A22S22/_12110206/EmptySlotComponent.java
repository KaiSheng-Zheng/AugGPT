import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int i, int j, char identity){
        super(i,j,identity);
        this.name='_';
    }


    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

}
