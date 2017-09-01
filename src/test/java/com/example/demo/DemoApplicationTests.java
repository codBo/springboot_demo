package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
	private ApplicationContext applicationContext;

	@Test
	public void getHello() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello World");
	}
    @Test
    public void testCompression() throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept-Encoding", "gzip");
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<byte[]> entity = this.restTemplate.exchange("/", HttpMethod.GET,
                requestEntity, byte[].class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        try (GZIPInputStream inflater = new GZIPInputStream(
                new ByteArrayInputStream(entity.getBody()))) {
            assertThat(StreamUtils.copyToString(inflater, Charset.forName("UTF-8")))
                    .isEqualTo("Hello World");
        }
    }

//    @Test
//    public void testTimeout() throws Exception {
//        ServletWebServerApplicationContext context = (ServletWebServerApplicationContext) this.applicationContext;
//        TomcatWebServer embeddedServletContainer = (TomcatWebServer) context
//                .getWebServer();
//        ProtocolHandler protocolHandler = embeddedServletContainer.getTomcat()
//                .getConnector().getProtocolHandler();
//        int timeout = ((AbstractProtocol<?>) protocolHandler).getConnectionTimeout();
//        assertThat(timeout).isEqualTo(5000);
//    }
//


}
