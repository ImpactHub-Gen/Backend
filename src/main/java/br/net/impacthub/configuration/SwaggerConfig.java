package br.net.impacthub.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI().info(new Info().title("ImpactHub").description(
				"Rede social focada para maior visibilidade e interação entre ONGs, projetos sociais e os demais usuários da rede")
				.version("v0.0.1").license(new License().name("GitHub").url("https://github.com/ImpactHub-Gen"))
				.contact(new Contact().name("ImpactHub").url("https://impacthub.net.br")
						.email("suporte.impacthub@gmail.com")));

	}

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				ApiResponses apiResponses = operation.getResponses();
				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}

	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}

}