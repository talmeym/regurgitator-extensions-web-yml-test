package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.FileResponseYmlLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class FileResponseYmlLoaderTest extends YmlLoaderTest {
	public FileResponseYmlLoaderTest() {
		super(new FileResponseYmlLoader());
	}

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/FileResponse.yml", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
	}

	@Test
	public void testPrefixed() throws SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/FileResponse_prefixed.yml", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
	}

}
