package election.formatter;

import election.entities.ConstituencyResult;
import election.entities.VoteEntry;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ResultFormatter {
    private static final String SECTION_DELIMITER = " || ";
    private static final String VOTE_DELIMITER = " | ";

    String format(ConstituencyResult result) {
        var voteEntries = result.votes();
        int totalVotes = calcTotalVotes(voteEntries);

        return new StringJoiner(SECTION_DELIMITER)
            .add(result.constituencyName())
            .add(formatVoteList(voteEntries, totalVotes))
            .toString();
    }

    private String formatVoteList(List<VoteEntry> voteList, int totalVotes) {
        return voteList.stream()
                .map(vote -> formatVote(totalVotes, vote))
                .collect(Collectors.joining(SECTION_DELIMITER));
    }

    private String formatVote(int totalVotes, VoteEntry vote) {
        return vote.party().displayName()
                + VOTE_DELIMITER
                + getVotePercentage(vote.count(), totalVotes);
    }

    private String getVotePercentage(int value, int totalVotes) {
        return String.format("%.2f%%", 100 * (value / (double) totalVotes));
    }

    private int calcTotalVotes(List<VoteEntry> votes) {
        return votes
                .stream()
                .mapToInt(VoteEntry::count)
                .sum();
    }
}
