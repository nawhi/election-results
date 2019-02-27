package election;

import election.builders.ElectionReportBuilder;
import election.formatter.ReportFormatter;
import election.parser.*;

public class ElectionReport {
    private String rawDataFile;
    private FileParser parser;
    private ReportFormatter formatter;

    public ElectionReport(String rawDataFile, FileParser parser, ReportFormatter formatter) {
        this.rawDataFile = rawDataFile;
        this.parser = parser;
        this.formatter = formatter;
    }

    public static ElectionReport forFile(String absolutePath) {
        return new ElectionReportBuilder().forDataFile(absolutePath);
    }

    public String generate() {
        var results = parser.parse(rawDataFile);
        return formatter.format(results);
    }

}
