package election.formatter;

import election.entities.ConstituencyResult;
import election.entities.VoteEntry;

import java.util.List;
import java.util.StringJoiner;

public class ResultFormatter {
    public String format(ConstituencyResult constituencyResult) {
        var voteList = constituencyResult.voteList();
        int totalVotes = calcTotalVotes(voteList);
        var joiner = new StringJoiner(" || ")
            .add(constituencyResult.constituencyName());

        voteList.stream()
                .forEach(vote -> {
                    String partyName = vote.party.displayName();
                    String votePercentage = getVotePercentage(vote.numVotes, totalVotes);
                    joiner.add(partyName + " | " + votePercentage);
                });

        return joiner.toString();
    }

    private String getVotePercentage(int value, int totalVotes) {
        return String.format("%.2f%%", 100 * (value / (double) totalVotes));
    }

    private int calcTotalVotes(List<VoteEntry> voteList) {
        return voteList
                .stream()
                .mapToInt(entry -> entry.numVotes)
                .sum();
    }
}
