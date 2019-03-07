package com.evilcorp.trollquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = TrollquizApplication.class)
@ContextConfiguration
@TestPropertySource("/application-test.properties")
@ActiveProfiles("test")
public class TrollquizApplicationTests {

<<<<<<< HEAD
//  @Test
//  public void contextLoads() {
//  }
=======
  @Test
  public void contextLoads() throws Exception{
  }
>>>>>>> e6d8c77b40189d618fc4c2fabcb2ff7848ba4390

}
