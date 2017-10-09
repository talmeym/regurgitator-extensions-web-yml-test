/* * Copyright (C) 2017 Miles Talmey. * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT). */package com.emarte.regurgitator.test;import com.emarte.regurgitator.extensions.web.CreateHttpResponseYmlLoader;import org.junit.Test;import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;public class CreateHttpResponseYmlLoaderTest extends YmlLoaderTest {    public CreateHttpResponseYmlLoaderTest() {        super(new CreateHttpResponseYmlLoader());    }    @Test    public void testValueYml() throws Exception {        assertExpectation("classpath:/CreateHttpResponse_value.yml", "com.emarte.regurgitator.extensions.web.CreateHttpResponse:[com.emarte.regurgitator.core.CreateResponse:['create-http-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],null],-1,null]");    }    @Test    public void testValueYml_statusCode() throws Exception {        assertExpectation("classpath:/CreateHttpResponse_statusCode.yml", "com.emarte.regurgitator.extensions.web.CreateHttpResponse:[com.emarte.regurgitator.core.CreateResponse:['create-http-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],null],200,null]");    }    @Test    public void testValueYml_contentType() throws Exception {        assertExpectation("classpath:/CreateHttpResponse_contentType.yml", "com.emarte.regurgitator.extensions.web.CreateHttpResponse:[com.emarte.regurgitator.core.CreateResponse:['create-http-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],null],-1,'contentType']");    }    @Test    public void testValueYml_both() throws Exception {        assertExpectation("classpath:/CreateHttpResponse_both.yml", "com.emarte.regurgitator.extensions.web.CreateHttpResponse:[com.emarte.regurgitator.core.CreateResponse:['create-http-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],null],200,'contentType']");    }    @Test    public void testFullLoadYml() throws Exception {        loadFile("classpath:/CreateHttpResponse_fullLoad.yml");    }}