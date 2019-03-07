package election.formatter;

import election.entities.ConstituencyResult;

import java.util.List;
import java.util.stream.Collectors;

public class ReportFormatter {
    private final ConstituencyResultFormatter constituencyResultFormatter;

    public ReportFormatter(ConstituencyResultFormatter constituencyResultFormatter) {
        this.constituencyResultFormatter = constituencyResultFormatter;
    }

    public String format(List<ConstituencyResult> voteList) {
        return voteList.stream()
                .map(constituencyResultFormatter::format)
                .collect(Collectors.joining("\n"));
    }
}
