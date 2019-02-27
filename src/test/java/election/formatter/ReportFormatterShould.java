package election.formatter;

import election.entities.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

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
                result("Thanet South", UKIP, 1500),
                result("Witney", CONSERVATIVES, 2000),
                result("Islington North", LABOUR, 1300)
        );
    }

    private ConstituencyResult result(String constituencyName, Party party, int numVotes) {
        return new ConstituencyResult(
                new Constituency(constituencyName),
                new VoteList(Collections.singletonList(new VoteEntry(party, numVotes)))
        );
    }

}