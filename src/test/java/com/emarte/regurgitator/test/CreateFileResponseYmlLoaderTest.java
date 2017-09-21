package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.CreateFileResponseYmlLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class CreateFileResponseYmlLoaderTest extends YmlLoaderTest {
	public CreateFileResponseYmlLoaderTest() {
		super(new CreateFileResponseYmlLoader());
	}

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/CreateFileResponse.yml", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
	}

	@Test
	public void testPrefixed() throws SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/CreateFileResponse_prefixed.yml", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
	}

	@Test
	public void testFullLoadYml() throws RegurgitatorException {
		loadFile("classpath:/CreateFileResponse_fullLoad.yml");
	}
}
