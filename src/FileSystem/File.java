package FileSystem;

public class File implements FileComponent{
    String name;
    String content;

    public File(String name , String content)
    {
        this.name = name;
        this.content = content;
    }

    public void display(String indent)
    {
        indent += indent;
        System.out.println(indent +" content :"+content);
    }
}
