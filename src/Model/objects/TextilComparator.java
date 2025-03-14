package Model.objects;
import java.util.Comparator;

public class TextilComparator implements Comparator<Textil> {
    @Override
    public int compare(Textil t1, Textil t2) {
        return t1.getComposicio().compareTo(t2.getComposicio());
    }
}
