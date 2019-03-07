package election.entities;

import java.util.Objects;

public class VoteEntry {
    private final Party party;
    private final int count;

    public VoteEntry(Party party, int count) {
        this.party = party;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntry voteEntry = (VoteEntry) o;
        return count == voteEntry.count &&
                Objects.equals(party, voteEntry.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(party, count);
    }

    @Override
    public String toString() {
        return "VoteEntry{" +
                "party=" + party +
                ", count=" + count +
                '}';
    }

    public int count() {
        return count;
    }

    public Party party() {
        return party;
    }
}
