package hello;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRestServiceConfig {
	
	@Bean
	public PersonRepository personRepositoryMock() {
		return Mockito.mock(PersonRepository.class);
	}

//    @Bean
//    public UserAccountService userAccountServiceMock() {
//        return Mockito.mock(UserAccountService.class);
//    }
//
//    @Bean
//    public UserAccountRepository userAccountRepositoryMock() {
//        return Mockito.mock(UserAccountRepository.class);
//    }
//
//    @Bean
//    public UserSocialConnectionRepository userSocialConnectionRepositoryMock() {
//        return Mockito.mock(UserSocialConnectionRepository.class);
//    }
//
//    @Bean
//    public CommentPostRepository commentPostRepositoryMock() {
//        return Mockito.mock(CommentPostRepository.class);
//    }
//
//    @Bean
//    public BlogPostRepository blogPostRepositoryMock() {
//        return Mockito.mock(BlogPostRepository.class);
//    }
}
