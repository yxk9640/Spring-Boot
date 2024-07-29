package FirstWizard.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author - yogesh
 */
public class HealthCheckTemplate extends HealthCheck {
    private final String healthCheck;

    public HealthCheckTemplate(String healthCheck) {
        this.healthCheck = healthCheck;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(healthCheck, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
