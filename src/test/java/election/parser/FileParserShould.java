package election.parser;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteList;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileParserShould {
    @Test
    void parse_line_of_input_into_report_object() {
        LineReader reader = mock(LineReader.class);
        FileParser parser = new FileParser(reader);

        ConstituencyResult expectedResult = new ConstituencyResult(
                new Constituency("Cardiff West"),
                new VoteList(emptyMap())
        );

        when(reader.getLine()).thenReturn("Cardiff West");

        ConstituencyResult actualResult = parser.parse("filename/does/not/matter");

        assertThat(actualResult, is(expectedResult));
    }
}