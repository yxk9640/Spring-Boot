package FirstWizard;

import FirstWizard.health.HealthCheckTemplate;
import FirstWizard.resources.HelloResource;
import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FirstDropWizardApplication extends Application<FirstDropWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FirstDropWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "FirstDropWizard";
    }

    @Override
    public void initialize(final Bootstrap<FirstDropWizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FirstDropWizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new HelloResource());
        environment.healthChecks().register("template", new HealthCheck(){
            @Override
            protected Result check() throws Exception {
                return Result.healthy("Good to go.");
            }
        });
    }

}
