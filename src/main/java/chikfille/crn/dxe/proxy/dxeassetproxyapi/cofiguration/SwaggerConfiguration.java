package chikfille.crn.dxe.proxy.dxeassetproxyapi.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket swagApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("chikfille.crn.dxe.proxy.dxeassetproxyapi.cofiguration"))
				.paths(regex("asset.*"))
				.build()
				.apiInfo(otherInfo());
	}

	private ApiInfo otherInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Chick fill-A DXE asset proxy service")
				.description("Chick fill-A DXE asset proxy service")
				.contact("Chick fill-A DXE asset proxy service").termsOfServiceUrl("www.chickfilleA.com").build();
	}
}
