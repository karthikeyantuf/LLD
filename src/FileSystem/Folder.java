package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileComponent{
    String name;
    List<FileComponent> contents;

    public Folder(String name)
    {
        this.name = name;
        contents = new ArrayList<>();
    }

    public void addToContents(FileComponent component)
    {
        this.contents.add(component);
    }

    public void display(String indent)
    {
        indent += indent;
        for(FileComponent component : contents)
        {
            component.display(indent);
        }
    }
}
