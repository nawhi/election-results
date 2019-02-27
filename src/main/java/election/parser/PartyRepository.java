package election.parser;

import election.entities.Party;

interface PartyRepository {
    Party getById(String id);
}
