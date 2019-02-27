package election.parser;

import election.entities.VoteEntry;
import election.entities.VoteList;

import java.util.ArrayList;
import java.util.List;

public class VoteBuilder {

    private final PartyRepository partyRepository;

    public VoteBuilder(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    VoteList build(List<String> tokens) {
        List<VoteEntry> rawVotes = new ArrayList<>();
        for (int i = 0; i < tokens.size() - 1; i += 2) {
            String count = tokens.get(i);
            String partyId = tokens.get(i+1);
            rawVotes.add(new VoteEntry(partyRepository.getById(partyId), Integer.parseInt(count)));
        }
        return new VoteList(rawVotes);
    }
}
