package election;

import election.parser.FileParser;

public class ElectionReport {
    private String rawDataFile;
    private FileParser parser;

    public ElectionReport(String rawDataFile, FileParser parser) {
        this.rawDataFile = rawDataFile;
        this.parser = parser;
    }

    public String generate() {
        parser.parse(rawDataFile);
        return null;
    }
}
