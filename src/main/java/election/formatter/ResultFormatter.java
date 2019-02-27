package election.formatter;

import election.entities.ConstituencyResult;
import election.entities.VoteEntry;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ResultFormatter {
    public String format(ConstituencyResult constituencyResult) {
        var voteList = constituencyResult.voteList();
        int totalVotes = calcTotalVotes(voteList);

        return new StringJoiner(" || ")
            .add(constituencyResult.constituencyName())
            .add(formatVoteList(voteList, totalVotes))
            .toString();
    }

    private String formatVoteList(List<VoteEntry> voteList, int totalVotes) {
        return voteList.stream()
                .map(vote -> vote.party.displayName() + " | " + getVotePercentage(vote.numVotes, totalVotes))
                .collect(Collectors.joining(" || "));
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
