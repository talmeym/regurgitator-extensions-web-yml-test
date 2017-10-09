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

public class HttpCallYmlLoaderTest extends YmlLoaderTest {
    public HttpCallYmlLoaderTest() {
        super(new HttpCallYmlLoader());
    }

    @Test
    public void testThis() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/HttpCall.yml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:[com.emarte.regurgitator.extensions.web.HttpClientWrapper:['something.com',1234,null,null]],[]]");
    }

    @Test
    public void testMax() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/HttpCall_max.yml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:[com.emarte.regurgitator.extensions.web.HttpClientWrapper:['something.com',1234,'username','password']],[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2']]]");
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
    public void testFullLoad() throws IOException, RegurgitatorException {
        loadFile("classpath:/HttpCall_fullLoad.yml");
    }
}
