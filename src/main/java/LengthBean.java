public class LengthBean {
    private  int length;
    private  String content;
    public  int getLength(){
        return length;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public LengthBean(int length,String content){
        this.length = length;
        this.content = content;
    }

    @Override
    public String toString() {
        return length+content;
    }
}
