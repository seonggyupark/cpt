package it.chi.webpipe.test.fixtures;

import it.chi.resource.ResourceUtils;
import it.chi.webpipe.crawler.executor.CrawlingSpecification;
import it.chi.webpipe.mapper.executor.MappingSpecification;
import it.chi.webpipe.pilot.repository.crawler.CrawlingSpecificationReader;
import it.chi.webpipe.test.crawler.CrawlingSpecificationAdapter;
import it.chi.webpipe.test.crawler.CrawlingSpecificationFirefoxPluginAdapter;
import it.chi.webpipe.wrapper.executor.WrappingSpecification;

import java.io.Reader;

public class FVGWebpipeSpecificationFixture extends WebpipeSpecificationFixture {

	final String wrappingPath = "/webpipes/TwoPageclasses/webpipe/wrapping.xml";
	
	final String crawlingPath = "/webpipes/TwoPageclasses/webpipe/crawling.xml";
	
	private Reader getWrapperReader(String resourceName) {
		return ResourceUtils.getResourceAsReader("/webpipes/"+getWebpipeName()+"/webpipe/wrappers/"+resourceName);
	}
	
	private Reader getCrawlerReader() {
		String crawlSpec = "/webpipes/"+getWebpipeName()+"/webpipe/crawling.xml";
		CrawlingSpecificationAdapter adapter = new CrawlingSpecificationFirefoxPluginAdapter(crawlSpec);
		
		String adaptedCrawlingSpecFile = adapter.getAdaptedFile(); 
		
		return ResourceUtils.getResourceAsReader(adaptedCrawlingSpecFile);
	}
	
	public FVGWebpipeSpecificationFixture(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CrawlingSpecification createCrawlingSpecification() {
		CrawlingSpecificationReader crReader = new CrawlingSpecificationReader();
		Reader reader= getCrawlerReader();

		CrawlingSpecification specific =crReader.read(reader);
		return specific;
	}

	@Override
	protected MappingSpecification createMappingSpecification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrappingSpecification createWrappingSpecification() {
		// TODO Auto-generated method stub
		return null;
	}

}
