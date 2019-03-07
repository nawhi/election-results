package election.parser;

import election.builders.ConstituencyResultBuilder;
import election.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static election.helpers.Parties.CONSERVATIVES;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class ConstituencyResultParserShould {

    private VoteBuilder voteBuilder;

    @BeforeEach
    void setUp() {
        voteBuilder = mock(VoteBuilder.class);
    }

    @Test
    void assemble_a_result_object_for_a_constituency() {
        when(voteBuilder.build(asList("100", "C")))
                .thenReturn(voteList(CONSERVATIVES, 100));

        var expectedResult = ConstituencyResultBuilder.aResult()
                .withConstituency("Witney")
                .withVoteEntry(CONSERVATIVES, 100)
                .build();

        var result = new ConstituencyResultParser(voteBuilder).parse("Witney, 100, C");

        assertThat(result, is(expectedResult));
    }

    private VoteList voteList(Party party, int count) {
        return new VoteList(asList(new VoteEntry(party, count)));
    }

}