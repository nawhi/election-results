package election.parser;

import election.entities.Constituency;
import election.entities.ConstituencyResult;
import election.entities.VoteList;

import java.util.Collections;

import static java.util.Collections.emptyMap;

public class FileParser {
    private LineReader reader;

    public FileParser(LineReader reader) {
        this.reader = reader;
    }

    public ConstituencyResult parse(String filename) {
        String[] entries = reader.getLine().split(",");
        return new ConstituencyResult(
                new Constituency(entries[0]),
                new VoteList(emptyMap())
        );
    }
}
