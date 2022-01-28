package feature;

import com.intuit.karate.junit5.Karate;


public class ApiTestRunner {
	@Karate.Test
	Karate testCountryFeature() {
		return Karate.run("country");
	}
}
