import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AmigoFileStream extends FileInputStream {

    private FileInputStream stream;

    public AmigoFileStream(FileInputStream stream) throws FileNotFoundException {
        super("name");
        this.stream = stream;
    }

    @Override
    public int read() throws IOException {
        System.out.println("Amigo");
        return stream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return stream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return stream.read(b, off, len);
    }
}
