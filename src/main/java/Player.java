import java.io.IOException;

public interface Player {

    String getMark();

    abstract int getMove() throws IOException;
}
