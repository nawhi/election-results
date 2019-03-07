package election.formatter;

import election.entities.ConstituencyResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static election.builders.ConstituencyResultBuilder.aResult;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ReportFormatterShould {

    private ConstituencyResultFormatter constituencyResultFormatter;

    @BeforeEach
    void setUp() {
        constituencyResultFormatter = mock(ConstituencyResultFormatter.class);
    }

    @Test
    void combine_results_returned_by_result_formatter() {
        when(constituencyResultFormatter.format(any()))
                .thenReturn("Line 1", "Line 2", "Line 3");

        String actual = new ReportFormatter(constituencyResultFormatter).format(threeResults());

        assertThat(actual, is("Line 1\nLine 2\nLine 3"));
    }

    private List<ConstituencyResult> threeResults() {
        return asList(
                aResult().build(),
                aResult().build(),
                aResult().build()
        );
    }
}