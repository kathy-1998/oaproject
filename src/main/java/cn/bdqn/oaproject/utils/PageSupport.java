package cn.bdqn.oaproject.utils;

/**
 * 分页类
 */
public class PageSupport {


	/**
	 * 当前页码
	 */
	private Integer currentPageNo;


	/**
	 * 每页显示记录数
	 */
	private Integer pageSize;

	/**
	 * 总记录数
	 */
	private Integer totalCount;

	/**
	 * 总页数
	 */
	private Integer totalPageCount;
	

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		
		this.totalPageCount = (this.totalCount + this.pageSize - 1) / this.pageSize;
        if(this.totalPageCount == 0){
        	this.totalPageCount = 1;
        }
		
		
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
	
	
	
}
