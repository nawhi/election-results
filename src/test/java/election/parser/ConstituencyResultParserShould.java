package election.parser;

import election.entities.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ConstituencyResultParserShould {

    @Test
    void assemble_a_result_object_for_a_constituency() {
        var line = "Witney, 100, C";
        var party = new Party("C", "Conservative");
        var votes = new VoteList(Collections.singletonList(new VoteEntry(party, 100)));
        var expectedResult = new ConstituencyResult(new Constituency("Witney"), votes);

        var voteBuilder = mock(VoteBuilder.class);
        var parser = new ConstituencyResultParser(voteBuilder);
        when(voteBuilder.build(asList("100", "C"))).thenReturn(votes);

        var result = parser.parse(line);

        assertThat(result, is(expectedResult));
    }
}