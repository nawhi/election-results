package election.entities;

import java.util.Objects;

public class VoteEntry {
    public final Party party;
    public final int numVotes;

    public VoteEntry(Party party, int numVotes) {
        this.party = party;
        this.numVotes = numVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntry voteEntry = (VoteEntry) o;
        return numVotes == voteEntry.numVotes &&
                Objects.equals(party, voteEntry.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(party, numVotes);
    }

    @Override
    public String toString() {
        return "VoteEntry{" +
                "party=" + party +
                ", numVotes=" + numVotes +
                '}';
    }
}
