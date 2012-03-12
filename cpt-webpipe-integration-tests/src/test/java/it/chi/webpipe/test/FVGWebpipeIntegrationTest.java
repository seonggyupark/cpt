package it.chi.webpipe.test;

import it.chi.webpipe.test.fixtures.FVGWebpipeSpecificationFixture;
import it.chi.webpipe.test.fixtures.WebpipeSpecificationFixture;

import org.junit.Test;

public class FVGWebpipeIntegrationTest extends
		AbstractWebpipeServiceIntegrationTest {

	private static final String WEBPIPE_NAME = "fvg";
	
	
	@Override
	public String getWebpipeName() {
		return WEBPIPE_NAME;
	}

	@Override
	public WebpipeSpecificationFixture getWebpipeSpecificationFixture() {
		return new FVGWebpipeSpecificationFixture(getWebpipeName());
	}
	
	@Test
	public void testDriveWebpipe() throws Exception {
		super.executeWebpipe();
		//TODO: assertions...
	}

}
