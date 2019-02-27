package election.parser;

import election.entities.Party;

public interface PartyRepository {
    Party getById(String id);
}
