package election.formatter;

import election.entities.ConstituencyResult;
import election.entities.Party;

import java.util.Map;
import java.util.StringJoiner;

public class ResultFormatter {
    public String format(ConstituencyResult constituencyResult) {
        Map<Party, Integer> voteList = constituencyResult.voteList();
        int totalVotes = calcTotalVotes(voteList);
        var joiner = new StringJoiner(" || ")
            .add(constituencyResult.constituencyName());

        voteList.entrySet()
                .forEach(entry -> {
                    String partyName = entry.getKey().displayName();
                    String votePercentage = getVotePercentage(entry.getValue(), totalVotes);
                    joiner.add(partyName + " | " + votePercentage);
                });

        return joiner.toString();


    }

    private String getVotePercentage(int value, int totalVotes) {
        return String.format("%.2f%%", 100 * (value / (double) totalVotes));
    }

    private int calcTotalVotes(Map<Party, Integer> voteList) {
        return voteList.entrySet()
                .stream()
                .mapToInt(entry -> entry.getValue())
                .sum();
    }
}
