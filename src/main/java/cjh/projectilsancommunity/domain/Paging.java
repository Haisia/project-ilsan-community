package cjh.projectilsancommunity.domain;

public class Paging {
    private final int pageSize = 15;
    private final int articlePerPage = 10;
    private final int max;


    private int pageNow=1;
    private int pageLeft = 1;
    private int pageRight = 15;


    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageLeft() {
        return pageLeft;
    }

    public void setPageLeft(int pageLeft) {
        this.pageLeft = pageLeft;
    }

    public int getPageRight() {
        return pageRight;
    }

    public void setPageRight(int pageRight) {
        this.pageRight = pageRight;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getMax() {
        return max;
    }

    public Paging(int numberOfArticle){
        max = (int)Math.ceil((double)numberOfArticle/articlePerPage);
    }

    public int getArticlePerPage() {
        return articlePerPage;
    }

    public void doPaging(int pageNow){
        this.pageNow = pageNow;
        pageLeft = (pageNow-1)/pageSize*pageSize+1;
        pageRight = (pageNow-1)/pageSize*pageSize+15;
    }

    public int getLimit1(int pageNow){
        doPaging(pageNow);
        return (pageNow-1)*10;
    }

    public int getLimit2(){
        return getArticlePerPage();
    }


    @Override
    public String toString() {
        return "Paging{" +
                "pageSize=" + pageSize +
                ", articlePerPage=" + articlePerPage +
                ", pageNow=" + pageNow +
                ", pageLeft=" + pageLeft +
                ", pageRight=" + pageRight +
                ", max=" + max +
                '}';
    }
}
