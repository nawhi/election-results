package election.formatter;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static election.builders.ConstituencyResultBuilder.aResult;
import static election.helpers.Parties.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ConstituencyResultFormatterShould {

    @Test
    void format_result_line_into_string() {
        var data = aResult()
                .withConstituency("Thanet South")
                .withVoteEntry(UKIP, 500)
                .withVoteEntry(CONSERVATIVES, 300)
                .withVoteEntry(LABOUR, 200)
                .build();

        String expectedReportLine = "Thanet South || UKIP | 50.00% || Conservative Party | 30.00% || Labour Party | 20.00%";

        ConstituencyResultFormatter formatter = new ConstituencyResultFormatter();
        assertThat(formatter.format(data), CoreMatchers.is(expectedReportLine));
    }
}