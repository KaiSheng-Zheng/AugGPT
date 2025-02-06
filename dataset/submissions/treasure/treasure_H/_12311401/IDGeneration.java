public class IDGeneration {
    private static int id=0;
    public static int idGenerate(){
        id= id+1;
        return id;
    }
}
