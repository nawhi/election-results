package election.parser;

import election.entities.Party;

import java.util.Map;

/**
 * NB: in a real application this might be read from a database
 */
class PartyFromId {

    private static final Map<String, Party> PARTIES = Map.of(
            "L", new Party("L", "Labour"),
            "C", new Party("C", "Conservative"),
            "UKIP", new Party("UKIP", "UKIP"),
            "LD", new Party("LD", "Liberal Democrats"),
            "G", new Party("G", "Green Party"),
            "Ind", new Party("Ind", "Independent"),
            "SNP", new Party("SNP", "SNP")
    );

    Party convert(String id) {
        return PARTIES.get(id);
    }
}
