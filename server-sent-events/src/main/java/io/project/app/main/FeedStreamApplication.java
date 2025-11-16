package io.project.app.main;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.project"})
public class FeedStreamApplication {

    /**
     * Main entry point of the Comment Web Application.
     *
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        // Create a new instance of SpringApplication with FeedStreamApplication class as the primary source
        final SpringApplication application = new SpringApplication(FeedStreamApplication.class);
        
        // Set the banner mode to show the Spring Boot banner in the console
        application.setBannerMode(Banner.Mode.CONSOLE);
        
        // Set the web application type to REACTIVE to enable Spring WebFlux
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        
        // Run the Spring Boot application with the provided command-line arguments
        application.run(args);
    }

}
