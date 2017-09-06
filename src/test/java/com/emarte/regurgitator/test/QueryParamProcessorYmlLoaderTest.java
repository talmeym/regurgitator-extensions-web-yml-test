package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.QueryParamProcessorYmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class QueryParamProcessorYmlLoaderTest extends YmlLoaderTest {
	public QueryParamProcessorYmlLoaderTest() {
		super(new QueryParamProcessorYmlLoader());
	}

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/QueryParamProcessor.yml", "com.emarte.regurgitator.extensions.web.QueryParamProcessor:['value']");
	}

	@Test
	public void testFullLoad() throws Exception {
		loadFile("classpath:/QueryParamProcessor_FullLoad.yml");
	}
}
