package com.kltn.motelservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.motelservice.entity.ActionName;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.ToiletName;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.*;
import com.kltn.motelservice.repository.ActionRepository;
import com.kltn.motelservice.repository.PostRepository;
import com.kltn.motelservice.repository.UserRepository;
import com.kltn.motelservice.service.ActionService;
import com.kltn.motelservice.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MotelServiceApplication.class)
@ActiveProfiles("test")
public class MotelServiceApplicationTests {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilter(springSecurityFilterChain).build();
    }

    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "clientIdPassword");
        params.add("client_secret", "123");
        params.add("username", username);
        params.add("password", password);

        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    public void contextLoads() {
    }

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    // Action
    @Test
    public void testGetAction() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/actions?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk()) // giong assert
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    // Comment
    @Test
    public void testGetComment() throws Exception {
        mockMvc.perform(get("/api/comments/post/1/?page=0")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk()) // giong assert
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testCreateComment() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setContent("Test Create Comment ");
        commentDTO.setRate(4l);
        commentDTO.setIdPost(10l);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/comment/post")
                .content(objectMapper.writeValueAsBytes(commentDTO))
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    @Test
    public void testUpdateComment() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setContent("Test Update Comment ");
        commentDTO.setRate(5l);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(put("/api/comment/10")
                .content(objectMapper.writeValueAsBytes(commentDTO))
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    @Test
    public void testDeleteComment() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(delete("/api/comment/11")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    // Criteria
    @Test
    public void testGetAllCriteria() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/criterias?page=0&all=true")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetCriteriaNotStop() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/criterias?page=0&all=false")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testCreateCriteria() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");
        CriteriaDTO criteriaDTO = new CriteriaDTO();
        criteriaDTO.setDistrictDTO(new DistrictDTO());
        criteriaDTO.getDistrictDTO().setId(1l);
        criteriaDTO.setMotel(true);
        criteriaDTO.setAcreageStart(30);
        criteriaDTO.setAcreageEnd(40);
        criteriaDTO.setPriceStart(5);
        criteriaDTO.setPriceEnd(10);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/criteria")
                .content(objectMapper.writeValueAsBytes(criteriaDTO))
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    @Test
    public void testStopCriteria() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(put("/api/criteria/stop/5")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    @Test
    public void testStartCriteria() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(put("/api/criteria/start/5")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    // District
    @Test
    public void testGetDistrict() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/districts")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    //Notification
    @Test
    public void testGetScreenNotification() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/notification?page=0&screen=true")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetNotification() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/notification?page=0&screen=false")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testgetNotificationByEmailAndCriteria() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/notification/criteria?idCriteria=1&page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testSeenNotification() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(put("/api/notification/9")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andDo(print());
    }

    // Post
//    @Test
//    public void testSearchPost() throws Exception {
//        String accessToken = obtainAccessToken("user@gmail.com", "123");
//        SearchDTO searchDTO = new SearchDTO();
//        searchDTO.setIdDistrict(13l);
//        searchDTO.setMotel(1);
//        searchDTO.setPriceStart(0);
//        searchDTO.setPriceEnd(10);
//        searchDTO.setAcreageStart(0);
//        searchDTO.setAcreageEnd(50);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        mockMvc.perform(get("/api/posts/search?page=0&sort=1")
//                .content(objectMapper.writeValueAsBytes(searchDTO))
//                .header("Authorization", "Bearer " + accessToken)
//                .header("content-type", "application/json")
//                .accept("application/json;charset=UTF-8"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").exists())
//                .andDo(print());
//    }

    @Test
    public void testGetAllPost() throws Exception {
        String accessToken = obtainAccessToken("mod@gmail.com", "123");

        mockMvc.perform(get("/api/posts/?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetAllPostApproved() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/posts/approved/true?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetAllPostNotApproved() throws Exception {
        String accessToken = obtainAccessToken("mod@gmail.com", "123");

        mockMvc.perform(get("/api/posts/approved/false?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetMotelPost() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/posts/motel/true?page=0&sort=1")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetHousePost() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/posts/motel/false?page=0&sort=1")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetPostWaiting() throws Exception {
        String accessToken = obtainAccessToken("mod@gmail.com", "123");

        mockMvc.perform(get("/api/posts/waiting?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetPostByIdUser() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/post/user/2?page=0")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testGetPostById() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        mockMvc.perform(get("/api/post/2")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testApprovePostAndLogging() throws Exception {
        String accessToken = obtainAccessToken("mod@gmail.com", "123");

        mockMvc.perform(put("/api/post/27/approve/true")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testNotApprovePostAndLogging() throws Exception {
        String accessToken = obtainAccessToken("mod@gmail.com", "123");

        mockMvc.perform(put("/api/post/26/approve/false")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }

    @Test
    public void testCreatePost() throws Exception {
        String accessToken = obtainAccessToken("user@gmail.com", "123");

        PostDTO postDTO = new PostDTO();
        postDTO.setAccomodationDTO(new AccomodationDTO());
        postDTO.getAccomodationDTO().setAcreage(20);
        postDTO.getAccomodationDTO().setAddress("Thủ đức");
        postDTO.getAccomodationDTO().setIdDistrict(13l);
        postDTO.getAccomodationDTO().setElectricPrice(0);
        postDTO.getAccomodationDTO().setWaterPrice(0);
        postDTO.getAccomodationDTO().setMotel(true);
        postDTO.getAccomodationDTO().setPrice(5000000);
        postDTO.getAccomodationDTO().setToilet(ToiletName.KHEP_KIN);
        postDTO.getAccomodationDTO().setxCoordinate(2l);
        postDTO.getAccomodationDTO().setyCoordinate(2l);

        Optional<User> user = userRepository.findByEmail("user@gmail.com");
        postDTO.setTitle("Testing");
        postDTO.setContent("Testing");
        List image = new ArrayList();
        image.add(null);
        postDTO.setImageStrings(image);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/post")
                .content(objectMapper.writeValueAsBytes(postDTO))
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }


}
