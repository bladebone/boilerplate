package hjseo.boilerplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "00. keep alive", description = "keep alive methods")
@RestController
public class KeepAliveController {

    @Operation(summary = "ping test", description = "ping test for health check")
    @GetMapping(value = "/ping", produces = "text/plain")
    public String getPing() {
        return "ok";
    }
}
