<<<<<<< HEAD
package c8y.devteams;

import java.lang.Thread.UncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import c8y.devteams.agent.Agent;
import c8y.devteams.agent.configuration.CredentialsManager;
import c8y.devteams.agent.driver.impl.ServiceLocatorDriversLoader;

/**
 * @author Ivelin Yanev
 * @since 01.09.2020
 *
 */
public class AgentLauncher {

	private static final Logger logger = LoggerFactory.getLogger(AgentLauncher.class);

	private static final String STOP = "stop";
	private static final String START = "start";

	public static void main(String[] args) {
		if (START.equals(args[0])) {
			start(args);
		} else if (STOP.equals(args[0])) {
			stop(args);
		}

	}

	private static void stop(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void start(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logger.error("Unrecoverable error, exiting: {}", e);
				return;

			}

		});

		// change the name of the thread
		Thread.currentThread().setName("C8Y DEVTEAMS Agent");
		final Agent agent = Agent.getInstance();

		agent.init(CredentialsManager.defaultCredentialsManager(), new ServiceLocatorDriversLoader());
	}

}
=======
package c8y.devteams;

import java.lang.Thread.UncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import c8y.devteams.agent.Agent;
import c8y.devteams.agent.configuration.ConfigurationManager;
import c8y.devteams.agent.driver.impl.ServiceLocatorDriversLoader;

/**
 * @author Ivelin Yanev
 * @since 01.09.2020
 *
 */
public class AgentLauncher {

	private static final Logger logger = LoggerFactory.getLogger(AgentLauncher.class);

	private static final String STOP = "stop";
	private static final String START = "start";

	public static void main(String[] args) {
		if (START.equals(args[0])) {
			start(args);
		} else if (STOP.equals(args[0])) {
			stop(args);
		}

	}

	private static void stop(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void start(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logger.error("Unrecoverable error, exiting: {}", e);
				return;

			}

		});

		// change the name of the thread
		Thread.currentThread().setName("C8Y DEVTEAMS Agent");
		final Agent agent = Agent.getInstance();

		agent.init(ConfigurationManager.defaultCredentialsManager(), new ServiceLocatorDriversLoader());
	}

}
>>>>>>> 50db4b2... add the polling driver class