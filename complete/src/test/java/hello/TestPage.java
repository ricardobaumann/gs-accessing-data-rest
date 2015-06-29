package hello;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.ResourceSupport;

public class TestPage<T> extends ResourceSupport{
	
	private T content;
	
	private Integer numberOfElements;
	
	private Integer totalElements;

    private Page page;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public Page getPage() {
		return page;
	}

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
