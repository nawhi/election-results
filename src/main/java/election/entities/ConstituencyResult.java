package election.entities;

import java.util.Objects;

public class ConstituencyResult {
    private final Constituency constituency;
    private final VoteList votes;

    public ConstituencyResult(Constituency constituency, VoteList votes) {
        this.constituency = constituency;
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstituencyResult that = (ConstituencyResult) o;
        return Objects.equals(constituency, that.constituency) &&
                Objects.equals(votes, that.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constituency, votes);
    }

    @Override
    public String toString() {
        return "ConstituencyResult{" +
                "constituency=" + constituency +
                ", votes=" + votes +
                '}';
    }
}
