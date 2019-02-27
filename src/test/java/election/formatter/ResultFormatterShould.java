package election.formatter;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.Party;
import election.entities.VoteList;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static election.helpers.Parties.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ResultFormatterShould {

    @Disabled
    @Test
    void format_result_line_into_string() {
        var data = result("Thanet South", Map.of(UKIP, 500, CONSERVATIVES, 300, LABOUR, 200));
        String expectedReportLine = "Thanet South || UKIP | 50.00% || Conservative Party | 30.00% || Labour Party | 20.00%";

        ResultFormatter formatter = new ResultFormatter();
        assertThat(formatter.format(data), CoreMatchers.is(expectedReportLine));
    }

    private ConstituencyResult result(String constituencyName, Map<Party, Integer> rawVotes) {
        return new ConstituencyResult(
                new Constituency(constituencyName),
                new VoteList(rawVotes)
        );
    }
}