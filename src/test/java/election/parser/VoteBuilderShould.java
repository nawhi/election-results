package election.parser;

import election.entities.Party;
import election.entities.VoteList;
import election.helpers.Parties;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static election.helpers.Parties.*;
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

        Map<Party, Integer> voteMap = Map.of(
                LABOUR, 22547,
                CONSERVATIVES, 9389
        );
        VoteList expectedVoteList = new VoteList(voteMap);

        assertThat(new VoteBuilder(new InMemoryPartyRepository()).build(tokens), is(expectedVoteList));
    }
}