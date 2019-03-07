package election;

import election.formatter.ReportFormatter;
import election.parser.FileParser;

public class ElectionReportGenerator {
    private final String rawDataFile;
    private final FileParser parser;
    private final ReportFormatter formatter;

    ElectionReportGenerator(String rawDataFile, FileParser parser, ReportFormatter formatter) {
        this.rawDataFile = rawDataFile;
        this.parser = parser;
        this.formatter = formatter;
    }

    public String generate() {
        var results = parser.parse(rawDataFile);
        return formatter.format(results);
    }

}
