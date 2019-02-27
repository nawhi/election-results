package election.parser;

import election.entities.Party;
import election.entities.VoteList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteBuilder {

    public static final Map<String, Party> ID_TO_PARTY = Map.of(
            "L", new Party("L", "Labour"),
            "C", new Party("C", "Conservative")
    );

    VoteList build(List<String> tokens) {
        Map<Party, Integer> rawVotes = new HashMap<>();
        for (int i = 0; i < tokens.size() - 1; i += 2) {
            String count = tokens.get(i);
            String partyId = tokens.get(i+1);
            rawVotes.put(getPartyFromId(partyId), Integer.parseInt(count));
        }

        return new VoteList(rawVotes);
    }

    private Party getPartyFromId(String partyId) {
        return ID_TO_PARTY.get(partyId);
    }
}
