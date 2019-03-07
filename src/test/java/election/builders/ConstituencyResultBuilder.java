package election.builders;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteEntry;
import election.entities.VoteList;

import java.util.List;

import static election.helpers.Parties.*;
import static java.util.Arrays.asList;

public class ConstituencyResultBuilder {

    private static final VoteEntry VOTE_ENTRY_1 = new VoteEntry(CONSERVATIVES, 25);
    private static final VoteEntry VOTE_ENTRY_2 = new VoteEntry(LABOUR, 25);
    private static final VoteEntry VOTE_ENTRY_3 = new VoteEntry(UKIP, 25);
    private static final List<VoteEntry> VOTES = asList(VOTE_ENTRY_1, VOTE_ENTRY_2, VOTE_ENTRY_3);

    private Constituency constituency = new Constituency("Islington North");
    private VoteList voteList = new VoteList(VOTES);

    public static ConstituencyResultBuilder aResult() {
        return new ConstituencyResultBuilder();
    }

    public ConstituencyResult build() {
        return new ConstituencyResult(constituency, voteList);
    }
}
