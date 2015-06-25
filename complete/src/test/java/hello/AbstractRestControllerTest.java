package hello;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = { TestRestServiceConfig.class, TestRestServiceWebConfig.class })
@WebAppConfiguration
public abstract class AbstractRestControllerTest {
    protected MockMvc mockMvc;

    @Inject
    protected WebApplicationContext webApplicationContext;

//    @Inject
//    protected UserAccountService userAccountServiceMock;

    @Before
    public void setup() {
//        Mockito.reset(userAccountServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected static final String USER_ID = "user123";
    protected static final String USER_USERNAME = "john.doe@company.com";
    protected static final String USER_DISPLAY_NAME = "John Doe";

//    protected UserAccount getTestLoggedInUser() {
//        UserAccount user = new UserAccount();
//        user.setUserId(USER_ID);
//        user.setRoles(new UserRoleType[]{UserRoleType.ROLE_USER});
//        user.setDisplayName(USER_DISPLAY_NAME);
//        return user;
//    }

    protected static final String BLOG_ID = "blog123";
    protected static final String BLOG_TITLE = "My First Post";
    protected static final String BLOG_PATH = "My_First_Post";
    protected static final String BLOG_AUTHOR_ID = "author123";

//    protected BlogPost getTestSinglePublishedBlogPost() {
//        BlogPost blog = new BlogPost();
//        blog.setId(BLOG_ID);
//        blog.setAuthorId(BLOG_AUTHOR_ID);
//        blog.setTitle(BLOG_TITLE);
//        blog.publish(BLOG_PATH, 2014, 1);
//        return blog;
//    }

    protected static final String BLOGS_1_ID = "blog001";
    protected static final String BLOGS_1_TITLE = "Test Blog One";
    protected static final String BLOGS_1_AUTHOR_ID = "author123";
    protected static final String BLOGS_2_ID = "blog002";
    protected static final String BLOGS_2_TITLE = "Test Blog Two";
    protected static final String BLOGS_2_AUTHOR_ID = "author456";

//    protected List<BlogPost> getTestPublishedBlogPostList() {
//        BlogPost blog1 = new BlogPost();
//        blog1.setId(BLOGS_1_ID);
//        blog1.setTitle(BLOGS_1_TITLE);
//        blog1.setAuthorId(BLOGS_1_AUTHOR_ID);
//        blog1.publish(BLOG_PATH, 2014, 1);
//
//        BlogPost blog2 = new BlogPost();
//        blog2.setId(BLOGS_2_ID);
//        blog2.setTitle(BLOGS_2_TITLE);
//        blog2.setAuthorId(BLOGS_2_AUTHOR_ID);
//        blog2.publish(BLOG_PATH, 2014, 1);
//
//        return Arrays.asList(blog1, blog2);
//    }

}