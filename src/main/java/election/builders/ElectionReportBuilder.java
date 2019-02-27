package election.builders;

import election.ElectionReport;
import election.formatter.ReportFormatter;
import election.formatter.ResultFormatter;
import election.parser.*;

public class ElectionReportBuilder {
    public ElectionReport forDataFile(String relativePath) {
        var repository = new InMemoryPartyRepository();
        var voteBuilder = new VoteBuilder(repository);
        var resultParser = new ConstituencyResultParser(voteBuilder);
        var parser = new FileParser(new LineReader(), resultParser);
        ReportFormatter formatter = new ReportFormatter(new ResultFormatter());
        return new ElectionReport(relativePath, parser, formatter);
    }
}
