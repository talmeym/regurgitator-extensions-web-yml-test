/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.HttpCallYmlLoader;
import org.junit.Test;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall_max;

public class HttpCallYmlLoaderTest extends YmlLoaderTest {
    public HttpCallYmlLoaderTest() {
        super(new HttpCallYmlLoader());
    }

    @Test
    public void testThis() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/HttpCall.yml", HttpCall);
    }

    @Test
    public void testMaximum() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/HttpCall_max.yml", HttpCall_max);
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingUsername() throws IOException, RegurgitatorException {
        loadFromFile("classpath:/HttpCall_missingUsername.yml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingPassword() throws IOException, RegurgitatorException {
        loadFromFile("classpath:/HttpCall_missingPassword.yml");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/HttpCall_fullLoad.yml");
    }
}
