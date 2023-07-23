package hjseo.boilerplate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(KeepAliveController.class)
class KeepAliveControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GET /ping")
    public void testGetPing() throws Exception {

        // given
        String result = "ok";

        // when
        // then
        mvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }
}
