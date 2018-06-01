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

    public void readVCFFile(){
        try {
            File contactFile = new File("C:\\Users\\baopn.VPBANK\\Downloads\\MyContacts-2018-05-19-192456-1071.vcf");
            BufferedReader bf = new BufferedReader(new FileReader(contactFile));
            String st ;
            while((st = bf.readLine()) != null){
                String[] telephoneLine = st.split("\n");
                for (int i = 0; i < telephoneLine.length; i++) {
                    if(telephoneLine[i].contains(".TEL")){
                        System.out.println(telephoneLine[i].split("\\:")[1]);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


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
        return Arrays.asList("stories/Gmail_Login.story");
    }

    @Override
    @Test
    public void run() throws Throwable {
        super.run();
    }
}
