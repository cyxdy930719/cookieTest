package com.neuedu.pojo;

import java.util.List;

public class ResultData {
    private List<?> lists;
    private int pageNo;
    private int pageSize=2;
    //分页条
    private String pageView;
    private int maxPage;
    //计数
    private int maxCount;
    private String url;

    /*分页条进行拼接，builder专门进行拼接*/
    public void setUrl(String url){
        this.url=url;
        StringBuilder str = new StringBuilder();
        if(pageNo==1){
            str.append("<li class='page'><a href='javascript:(void)' >首页</a></li>");
            str.append("<li class='page'><a href='javascript:(void)' >上一页</a></li>");
        }else{
            str.append("<li class='page'><a href='list?pageNo=1' >首页</a></li>");
            str.append("<li class='page'><a href='list?pageNo="+(pageNo-1)+"' >上一页</a></li>");
        }
        for(int i =1;i<=maxPage;i++){
            if(i==pageNo){
                str.append("<li class='page'><a href='javascript:(void)' >"+pageNo+"</a></li>");/*当前不跳页*/
            }else{
                str.append("<li class='page'><a href='list?pageNo="+i+"' >"+i+"</a></li>");
            }
        }
        if(pageNo==maxPage){
            str.append("<li class='page'><a href='javascript:(void)' >下一页</a></li>");
            str.append("<li class='page'><a href='javascript:(void)' >尾页</a></li>");
        }else{
            str.append("<li class='page'><a href='list?pageNo="+(pageNo+1)+"' >下一页</a></li>");
            str.append("<li class='page'><a href='list?pageNo="+(maxPage)+"' >尾页</a></li>");
        }
        this.pageView=str.toString();

    }

    public String getPageView() {
        return pageView;
    }

    public List<?> getLists() {
        return lists;
    }

    public void setLists(List<?> lists) {
        this.lists = lists;
    }
/*页数，最大显示条数，总条数可以传进来*/
    public ResultData(int pageNo, int pageSize, int maxCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.maxCount = maxCount;
        this.maxPage = maxCount%pageSize==0?maxCount/pageSize:(maxCount/pageSize)+1;
    }
}
