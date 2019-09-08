package chikfille.crn.dxe.proxy.dxeassetproxyapi.cofiguration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@Component(value="ResourceConfig")
public class ResourceConfig {
	
	@Value("${dxe.contentful.proxy.base_url}")
	String contentulBaseUrl;

	@Value("${dxe.contentful.proxy.acess_token}")
	String accessToken;

	public String getContentulBaseUrl() {
		return contentulBaseUrl;
	}

	public void setContentulBaseUrl(String contentulBaseUrl) {
		this.contentulBaseUrl = contentulBaseUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {

			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().set("User-agent", "curl/7.59.0");
				return execution.execute(request, body);
			}
		});
		return restTemplate;
	}

}
