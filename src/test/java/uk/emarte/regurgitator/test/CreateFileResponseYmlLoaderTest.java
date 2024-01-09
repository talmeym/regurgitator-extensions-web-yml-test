/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.extensions.web.CreateFileResponseYmlLoader;
import org.junit.Test;

import java.io.IOException;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse_prefixed;

public class CreateFileResponseYmlLoaderTest extends YmlLoaderTest {
    public CreateFileResponseYmlLoaderTest() {
        super(new CreateFileResponseYmlLoader());
    }

    @Test
    public void testThis() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/CreateFileResponse.yml", CreateFileResponse);
    }

    @Test
    public void testPrefixed() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/CreateFileResponse_prefixed.yml", CreateFileResponse_prefixed);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/CreateFileResponse_fullLoad.yml");
    }
}
