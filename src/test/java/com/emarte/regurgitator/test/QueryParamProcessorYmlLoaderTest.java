/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.QueryParamProcessorYmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.QueryParamProcessor;

public class QueryParamProcessorYmlLoaderTest extends YmlLoaderTest {
    public QueryParamProcessorYmlLoaderTest() {
        super(new QueryParamProcessorYmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/QueryParamProcessor.yml", QueryParamProcessor);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/QueryParamProcessor_FullLoad.yml");
    }
}
