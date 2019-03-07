package election;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteList;
import election.formatter.ReportFormatter;
import election.parser.FileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ElectionReportGeneratorShould {

    private ReportFormatter formatter;
    private FileParser parser;
    private String filename;

    @BeforeEach
    void setUp() {
        formatter = mock(ReportFormatter.class);
        parser = mock(FileParser.class);
        filename = "whatever";
    }

    @Test
    void get_file_parsed_into_standard_format() {
        new ElectionReportGenerator(filename, parser, formatter).generate();
        verify(parser).parse(filename);
    }

    @Test
    void pass_data_returned_from_parser_to_formatter() {
        String expectedReport = "Some || Election || Results";

        List<ConstituencyResult> result = aResult();

        when(parser.parse(filename)).thenReturn(result);
        when(formatter.format(result)).thenReturn(expectedReport);

        ElectionReportGenerator report = new ElectionReportGenerator("whatever", parser, formatter);
        String actualReport = report.generate();

        verify(parser).parse(filename);
        verify(formatter).format(result);
        assertThat(actualReport, is(expectedReport));
    }

    private List<ConstituencyResult> aResult() {
        return Collections.singletonList(new ConstituencyResult(
                new Constituency("whatever"),
                new VoteList(emptyList())));
    }
}