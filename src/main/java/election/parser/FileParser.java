package election.parser;

import election.entities.ConstituencyResult;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileParser {
    private final LineReader lineReader;
    private final ConstituencyResultParser resultParser;

    public FileParser(LineReader lineReader, ConstituencyResultParser resultParser) {
        this.lineReader = lineReader;
        this.resultParser = resultParser;
    }

    public List<ConstituencyResult> parse(String filename) {
        return lineReader.getLines(filename)
                .map(resultParser::parse)
                .collect(toList());
    }
}
