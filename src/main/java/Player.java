import java.io.Serializable;

public interface Player extends Serializable {

    String getMark();

    abstract int getMove();
}
