package election.acceptance;

import election.ElectionReport;
import election.parser.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AT_ElectionResults {

    private static final String FORMATTED_DATA = "Cardiff West || Conservative Party | 30.76% || Labour Party | 49.72% || UKIP | 13.75% || Liberal Democrats | 5.78%\n" +
            "Islington South & Finsbury || Labour Party | 51.45% || Conservative Party | 21.43% || Liberal Democrats | 11.02% || UKIP | 7.70% || Green Party | 7.69% || Independent | 0.71%";
    private static final String RAW_DATA_REL_PATH = "/raw_data_sample.csv";
    private static final String RAW_DATA_ABS_PATH = AT_ElectionResults.class.getResource(RAW_DATA_REL_PATH).getPath();

    @Test
    void transforms_raw_data_into_formatted_results() {
        ElectionReport report = ElectionReport.forFile(RAW_DATA_ABS_PATH);
        String data = report.generate();
        assertThat(data, is(FORMATTED_DATA));
    }


}
