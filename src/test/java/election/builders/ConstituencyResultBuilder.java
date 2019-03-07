package election.builders;

import election.entities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static election.helpers.Parties.*;
import static java.util.Arrays.asList;

public class ConstituencyResultBuilder {

    private static final VoteEntry VOTE_ENTRY_1 = new VoteEntry(CONSERVATIVES, 25);
    private static final VoteEntry VOTE_ENTRY_2 = new VoteEntry(LABOUR, 25);
    private static final VoteEntry VOTE_ENTRY_3 = new VoteEntry(UKIP, 25);
    private static final List<VoteEntry> VOTES = asList(VOTE_ENTRY_1, VOTE_ENTRY_2, VOTE_ENTRY_3);

    private Constituency constituency = new Constituency("Islington North");
    private VoteList voteList;

    public static ConstituencyResultBuilder aResult() {
        return new ConstituencyResultBuilder();
    }

    public ConstituencyResult build() {
        return new ConstituencyResult(
                constituency,
                (voteList == null) ? new VoteList(VOTES) : voteList
        );
    }

    public ConstituencyResultBuilder withConstituency(String name) {
        constituency = new Constituency(name);
        return this;
    }

    public ConstituencyResultBuilder withVoteEntry(Party party, int numVotes) {
        VoteEntry entry = new VoteEntry(party, numVotes);
        if (voteList == null) {
            voteList = new VoteList(List.of(entry));
        } else {
            ArrayList<VoteEntry> entries = new ArrayList<>(voteList.entries());
            entries.add(entry);
            voteList = new VoteList(entries);
        }
        return this;
    }
}
