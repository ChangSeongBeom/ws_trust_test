package org.wso2.carbon.sts.security.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An in-memory DB which maintains all the security scenarios
 */
public class SecurityScenarioDatabase {
	private static Map<String, SecurityScenario> scenarios = new LinkedHashMap<>();
	private static SecurityScenarioDatabase instance = new SecurityScenarioDatabase();

	private SecurityScenarioDatabase() {
	}

	public static SecurityScenarioDatabase getInstance() {
		return instance;
	}

	public static void put(String scenarioId, SecurityScenario scenario) {
		scenarios.put(scenarioId, scenario);
	}

	public static SecurityScenario get(String scenarioId) {
		return scenarios.get(scenarioId);
	}

	public static Collection<SecurityScenario> getAllScenarios() {
		return scenarios.values();
	}

	public static SecurityScenario getByWsuId(String wsuIdValue) {
		SecurityScenario scenario = null;
		Iterator<SecurityScenario> ite = scenarios.values().iterator();
		while (ite.hasNext()) {
			SecurityScenario temp = ite.next();
			if (wsuIdValue.equals(temp.getWsuId())) {
				scenario = temp;
				break;
			}
		}
		return scenario;
	}
}
