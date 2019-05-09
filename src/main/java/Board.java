import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public Boolean isEmpty() {
            List grid = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

            return !grid.contains("X") && !grid.contains("O");
    }
}