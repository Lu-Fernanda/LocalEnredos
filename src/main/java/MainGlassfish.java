import java.io.File;
import org.glassfish.embeddable.CommandResult;
import org.glassfish.embeddable.CommandRunner;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

public class MainGlassfish {

	public static void main(String[] args) throws Exception {
	   String webappDirLocation = "src/main/webapp/";

	// Look for that variable and default to 8080 if it isn't there.
	String webPort = System.getenv("PORT");
	if (webPort == null || webPort.isEmpty()) {
	    webPort = "8083";
	}

	/** Create and start GlassFish which listens at 8080 http port */
	GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", Integer.valueOf(webPort)); // refer
        gfProps.setProperty("domain-dir", "glassfishDomain");

	GlassFish glassfish = GlassFishRuntime.bootstrap()
			.newGlassFish(gfProps);
	glassfish.start();
	CommandRunner runner = glassfish.getCommandRunner();
	
        CommandResult result  = runner.run("set-log-level", "javax.enterprise.system.container.web=INFO:javax.enterprise.system.container.ejb=FINEST");
        System.out.println("------output of set log level: " + result.getOutput());
	Deployer deployer = glassfish.getDeployer();

      
        
        //Invocando el Script de Creacion de la base de datos.
      
	// Create a scattered web application.
	ScatteredArchive archive = new ScatteredArchive("holaMundo",
	ScatteredArchive.Type.WAR, new File(webappDirLocation));
        // target/classes directory contains my complied servlets
	archive.addClassPath(new File("target", "classes"));
	deployer.deploy(archive.toURI());

	}

}
