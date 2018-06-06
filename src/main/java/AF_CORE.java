import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

public class AF_CORE extends JUnitStories{


    @Override
    public Configuration configuration() {
        if (super.hasConfiguration()) {
            return super.configuration();
        }
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(CONSOLE));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
}

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("stories/TrangHTH10.story");
    }

    @Override
    @Test
    public void run() throws Throwable {
        super.run();
    }
}
