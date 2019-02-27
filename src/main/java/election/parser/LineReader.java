package election.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LineReader {

    public Stream<String> getLines(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename)).stream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
