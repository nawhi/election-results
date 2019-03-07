package election.formatter;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteEntry;
import election.entities.VoteList;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static election.helpers.Parties.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

class ConstituencyResultFormatterShould {

    @Test
    void format_result_line_into_string() {
        var data = result("Thanet South",
                asList(new VoteEntry(UKIP, 500), new VoteEntry(CONSERVATIVES, 300), new VoteEntry(LABOUR, 200)));
        String expectedReportLine = "Thanet South || UKIP | 50.00% || Conservative Party | 30.00% || Labour Party | 20.00%";

        ConstituencyResultFormatter formatter = new ConstituencyResultFormatter();
        assertThat(formatter.format(data), CoreMatchers.is(expectedReportLine));
    }

    private ConstituencyResult result(String constituencyName, List<VoteEntry> rawVotes) {
        return new ConstituencyResult(
                new Constituency(constituencyName),
                new VoteList(rawVotes)
        );
    }
}