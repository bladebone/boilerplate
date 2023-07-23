package hjseo.boilerplate.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@SecurityScheme(type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, name = "authorization")
@OpenAPIDefinition(
        info = @Info(
                title = "boilerplate to API",
                version = "0.0.1",
                description = "boilerplate to API",
                contact = @Contact(
                        name = "support",
                        email = "contact@contact",
                        url = "http://localhost"
                )
        ),
        security = @SecurityRequirement(name = "authorization")
)
@Configuration
public class OpenApiConfig {
}
