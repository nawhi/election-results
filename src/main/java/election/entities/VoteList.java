package election.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VoteList {
    private final Map<Party, Integer> entries;

    public VoteList(Map<Party, Integer> entries) {
        this.entries = new HashMap<>(entries);
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
