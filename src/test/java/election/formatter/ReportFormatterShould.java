package election.formatter;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.Party;
import election.entities.VoteList;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;
import java.util.Map;

import static election.helpers.Parties.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ReportFormatterShould {

    @Test
    void call_result_formatter_for_each_line_in_report() {
        var results = someResults();

        var resultFormatter = mock(ResultFormatter.class);
        when(resultFormatter.format(any())).thenReturn("Line 1", "Line 2", "Line 3");

        var reportFormatter = new ReportFormatter(resultFormatter);
        assertThat(reportFormatter.format(results), is("Line 1\nLine 2\nLine 3"));
    }

    private List<ConstituencyResult> someResults() {
        return asList(
                result("Thanet South", Map.of(UKIP, 1500)),
                result("Witney", Map.of(CONSERVATIVES, 2000)),
                result("Islington North", Map.of(LABOUR, 1300))
        );
    }

    private ConstituencyResult result(String constituencyName, Map<Party, Integer> rawVotes) {
        return new ConstituencyResult(
                new Constituency(constituencyName),
                new VoteList(rawVotes)
        );
    }

}