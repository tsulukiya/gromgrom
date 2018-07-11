package lesson19;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;


    public File(long id, String name, String format, long size) throws Exception {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;

        if (name.length()>=10)
            throw new Exception  ("name is not correct... rename file please and restart compile..." +
                    "File name:"+ name + ". ID file :"+id);

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        return name != null ? name.equals(file.name) : file.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
