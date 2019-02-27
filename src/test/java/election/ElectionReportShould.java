package election;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteList;
import election.formatter.ReportFormatter;
import election.parser.FileParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ElectionReportShould {

    @Test
    void get_file_parsed_into_standard_format() {
        String filename = "name/doesn't/matter/here";
        FileParser parser = mock(FileParser.class);

        var formatter = mock(ReportFormatter.class);

        new ElectionReport(filename, parser, formatter).generate();

        verify(parser).parse(filename);
    }

    @Test
    void pass_data_returned_from_parser_to_formatter() {
        String expectedReport = "Some || Election || Results";

        List<ConstituencyResult> result = aResult();

        FileParser parser = mock(FileParser.class);
        when(parser.parse("whatever")).thenReturn(result);

        ReportFormatter formatter = mock(ReportFormatter.class);
        when(formatter.format(result)).thenReturn(expectedReport);

        String actualReport = new ElectionReport("whatever", parser, formatter).generate();

        verify(formatter).format(result);
        assertThat(actualReport, is(expectedReport));


    }

    private List<ConstituencyResult> aResult() {
        return asList(new ConstituencyResult(
                new Constituency("whatever"),
                new VoteList(emptyMap())));
    }
}