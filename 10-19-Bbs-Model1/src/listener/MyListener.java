package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.ContextLoaderListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class MyListener extends ContextLoaderListener implements ServletContextListener {

}
