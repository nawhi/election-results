package election.parser;

import election.entities.Party;
import election.entities.VoteList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteBuilder {

    private PartyRepository partyRepository;

    public VoteBuilder(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    VoteList build(List<String> tokens) {
        Map<Party, Integer> rawVotes = new HashMap<>();
        for (int i = 0; i < tokens.size() - 1; i += 2) {
            String count = tokens.get(i);
            String partyId = tokens.get(i+1);
            rawVotes.put(partyRepository.getById(partyId), Integer.parseInt(count));
        }
        return new VoteList(rawVotes);
    }
}
