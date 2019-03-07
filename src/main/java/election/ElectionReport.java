package election;

import election.formatter.ReportFormatter;
import election.formatter.ResultFormatter;
import election.parser.*;

public class ElectionReport {

    public static ElectionReportGenerator forDataFile(String relativePath) {
        var repository = new InMemoryPartyRepository();
        var voteBuilder = new VoteBuilder(repository);
        var resultParser = new ConstituencyResultParser(voteBuilder);
        var parser = new FileParser(new LineReader(), resultParser);
        ReportFormatter formatter = new ReportFormatter(new ResultFormatter());
        return new ElectionReportGenerator(relativePath, parser, formatter);
    }
}
