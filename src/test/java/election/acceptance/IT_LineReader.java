package election.acceptance;

import election.parser.LineReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class IT_LineReader {

    private static final String RAW_DATA_REL_PATH = "/larger_raw_data_sample.csv";
    private static final String RAW_DATA_ABS_PATH = IT_LineReader.class.getResource(RAW_DATA_REL_PATH).getPath();

    @Test
    void stream_lines_in_file() {
        var expectedLines = Arrays.asList(
                "Aldershot, 4445, LD, 26545, UKIP, 244, Ind, 3, SNP, 4, G, 3, C",
                "Aldridge-Brownhills, 12703, G, 10543, L, 5327, Ind, 258, LD, 76, C, 67, UKIP",
                "Altrincham and Sale West, 28667, G, 3372, SNP, 11372, L, 127, Ind, 13, LD, 381, UKIP",
                "Amber Valley, 15242, C, 9295, UKIP, 8197, LD, 5474, Ind, 26, G, 269, L, 2336, SNP",
                "Arundel and South Downs, 14939, SNP, 10117, UKIP, 3379, LD, 9137, Ind, 8699, G, 765, C, 1423, L",
                "Ashfield, 2012, C, 5352, Ind, 2759, L, 31770, SNP, 1651, G, 138, LD, 53, UKIP"
        );
        var lines = new LineReader().getLines(RAW_DATA_ABS_PATH).collect(Collectors.toList());
        assertThat(lines, is(expectedLines));

    }
}