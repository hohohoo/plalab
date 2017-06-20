package com.skplanet.plalab.googleDrive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.repository.MemberRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@WebAppConfiguration
public class GoogleDriveApplicationTests {

	private Member member;

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private ObjectMapper objectMapper;
	private MockMvc mock;

	@Before
	public void setUp() throws Exception {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
		member = new Member("Kim", 25, "girl");
	}

	@Test
	public void testCreateMember() throws Exception {
		ResultActions resultActions =
				mock.perform(MockMvcRequestBuilders.post("/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsBytes(member)));

		resultActions.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(member.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(member.getAge())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.sex", Matchers.is(member.getSex())));
	}

	@Test
	public void testGetMemberList() throws Exception {

//		ResultActions resultActions =
//				mock.perform(MockMvcRequestBuilders.get("/list"));
//
//		resultActions.andDo(MockMvcResultHandlers.print())
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(member.getName())))
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].age", Matchers.is(member.getAge())))
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].sex", Matchers.is(member.getSex())));

	}
}
