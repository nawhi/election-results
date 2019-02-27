package election.acceptance;

import election.ElectionReport;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AT_ElectionResults {

    private static final String FORMATTED_DATA = "Cardiff West || Conservative Party | 30.76% || Labour Party | 49.72% || UKIP | 13.75% || Liberal Democrats | 5.78%\n" +
            "Islington South & Finsbury || Labour Party | 51.45% || Conservative Party | 21.43% || Liberal Democrats | 11.02% || UKIP | 7.70% || Green Party | 7.69% || Independent | 0.70%";
    private static final String RAW_DATA_FILE = "raw_data_sample.csv";

    @Test
    void transforms_raw_data_into_formatted_results() {
        ElectionReport report = new ElectionReport(RAW_DATA_FILE);
        String data = report.generate();
        assertThat(data, is(FORMATTED_DATA));
    }
}
