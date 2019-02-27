package election.parser;

import election.entities.VoteEntry;
import election.entities.VoteList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static election.helpers.Parties.CONSERVATIVES;
import static election.helpers.Parties.LABOUR;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class VoteBuilderShould {

    @Test
    void assemble_a_vote_list_from_a_list_of_tokens() {
        List<String> tokens = asList(
                "22547", "L",
                "9389", "C"
        );

        VoteList expectedVoteList = new VoteList(asList(
                new VoteEntry(LABOUR, 22547),
                new VoteEntry(CONSERVATIVES, 9389)
        ));

        assertThat(new VoteBuilder(new InMemoryPartyRepository()).build(tokens), is(expectedVoteList));
    }
}