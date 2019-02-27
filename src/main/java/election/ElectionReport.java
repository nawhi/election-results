package election;

import election.builders.ElectionReportBuilder;
import election.parser.*;

public class ElectionReport {
    private String rawDataFile;
    private FileParser parser;

    public ElectionReport(String rawDataFile, FileParser parser) {
        this.rawDataFile = rawDataFile;
        this.parser = parser;
    }

    public static ElectionReport forFile(String absolutePath) {
        return new ElectionReportBuilder().forDataFile(absolutePath);
    }

    public String generate() {
        parser.parse(rawDataFile);
        return null;
    }

}
