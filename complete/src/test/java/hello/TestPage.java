package hello;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.ResourceSupport;

public class TestPage<T> extends ResourceSupport{
	
	private T content;
	
	private Integer numberOfElements;
	
	private Integer totalElements;

    @SuppressWarnings("rawtypes")
	private Page page;
  
	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	@SuppressWarnings("rawtypes")
	public Page getPage() {
		return page;
	}

	@SuppressWarnings("rawtypes")
	public void setPage(Page page) {
		this.page = page;  
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}
    
    
	
}
