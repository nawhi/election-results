package election;

import election.parser.FileParser;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ElectionReportShould {

    @Test
    void get_file_parsed_into_standard_format() {
        String filename = "name/doesn't/matter/here";
        FileParser parser = mock(FileParser.class);

        new ElectionReport(filename, parser).generate();

        verify(parser).parse(filename);
    }

}