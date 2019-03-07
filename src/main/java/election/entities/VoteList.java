package election.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoteList {
    private final List<VoteEntry> entries;

    public VoteList(List<VoteEntry> entries) {
        this.entries = entries;
    }

    public List<VoteEntry> entries() {
        return new ArrayList<>(entries);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteList voteList = (VoteList) o;
        return Objects.equals(entries, voteList.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }

    @Override
    public String toString() {
        return "VoteList{" +
                "entries=" + entries +
                '}';
    }
}
