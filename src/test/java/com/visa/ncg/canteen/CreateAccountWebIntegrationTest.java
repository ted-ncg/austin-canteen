package com.visa.ncg.canteen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateAccountWebIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getToCreateAccountReturnsForm() throws Exception {
        mockMvc.perform(
                get("/create-account")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("create-account"));
    }

    @Test
    public void postToCreateAccountCreatesAccountAndRedirects() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                post("/create-account")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("accountName", "Video Games")
        )
                .andExpect(status().is3xxRedirection())
                .andReturn();

        mockMvc.perform(get(mvcResult.getResponse().getRedirectedUrl()))
                .andExpect(status().isOk())
                .andExpect(view().name("account-view"))
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attribute("account", instanceOf(AccountResponse.class)))
                .andExpect(model().attribute("account", hasProperty("name", is("Video Games"))));
    }

}
