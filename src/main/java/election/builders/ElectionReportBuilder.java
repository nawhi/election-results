package election.builders;

import election.ElectionReport;
import election.parser.*;

public class ElectionReportBuilder {
    public ElectionReport forDataFile(String relativePath) {
        var repository = new InMemoryPartyRepository();
        var voteBuilder = new VoteBuilder(repository);
        var resultParser = new ConstituencyResultParser(voteBuilder);
        var lineReader = new LineReader();
        var parser = new FileParser(lineReader, resultParser);
        return new ElectionReport(relativePath, parser, new election.formatter.ReportFormatter());
    }
}
