package election.formatter;

import election.entities.ConstituencyResult;

import java.util.List;
import java.util.stream.Collectors;

public class ReportFormatter {
    private ResultFormatter resultFormatter;

    public ReportFormatter(election.formatter.ResultFormatter resultFormatter) {
        this.resultFormatter = resultFormatter;
    }

    public String format(List<ConstituencyResult> voteList) {
        return voteList.stream()
                .map(resultFormatter::format)
                .collect(Collectors.joining("\n"));
    }
}
