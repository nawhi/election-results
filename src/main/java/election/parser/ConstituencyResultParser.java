package election.parser;

import election.entities.Constituency;
import election.entities.ConstituencyResult;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConstituencyResultParser {

    private final VoteBuilder voteBuilder;

    public ConstituencyResultParser(VoteBuilder voteBuilder) {
        this.voteBuilder = voteBuilder;
    }

    ConstituencyResult parse(String rawLine) {
        var tokens = getTokens(rawLine);
        return new ConstituencyResult(
                new Constituency(tokens.get(0)),
                voteBuilder.build(tokens.subList(1, tokens.size()))
        );
    }

    private List<String> getTokens(String rawLine) {
        String[] rawTokens = rawLine.split(",");
        return Arrays.stream(rawTokens)
                .map(String::strip)
                .collect(toList());
    }
}
