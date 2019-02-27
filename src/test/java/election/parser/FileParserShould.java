package election.parser;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

class FileParserShould {
    @Test
    void call_result_parser_for_each_line_in_file() {
        String filename = "whatever";
        List<String> lines = asList(
                "Cardiff, 1, C",
                "Islington North, 2, LD, 3, C",
                "Thanet South, 25, UKIP, 1, L"
        );
        LineReader lineReader = mock(LineReader.class);
        when(lineReader.getLines(filename)).thenReturn(lines.stream());

        ConstituencyResultParser resultParser = mock(ConstituencyResultParser.class);

        FileParser fileParser = new FileParser(lineReader, resultParser);

        fileParser.parse(filename);

        InOrder inOrder = inOrder(resultParser);
        inOrder.verify(resultParser).parse(lines.get(0));
        inOrder.verify(resultParser).parse(lines.get(1));
        inOrder.verify(resultParser).parse(lines.get(2));
    }
}