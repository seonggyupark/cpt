package it.chi.webpipe.test;

import it.chi.webpipe.test.fixtures.AlzWebpipeSpecificationFixture;
import it.chi.webpipe.test.fixtures.WebpipeSpecificationFixture;

import org.junit.Test;

public class AlzWebpipeIntegrationTest extends
		AbstractWebpipeServiceIntegrationTest {

	private static final String WEBPIPE_NAME = "Alz";
	
	
	@Override
	public String getWebpipeName() {
		return WEBPIPE_NAME;
	}

	@Override
	public WebpipeSpecificationFixture getWebpipeSpecificationFixture() {
		return new AlzWebpipeSpecificationFixture(getWebpipeName());
	}
	
	@Test
	public void testDriveWebpipe() throws Exception {
		super.executeWebpipe();
		//TODO: assertions...
	}

}
