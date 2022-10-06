import domain.SupportedFileTypes;
import org.junit.Test;
import org.junit.Assert;
import service.FileService;
import service.FilepathService;

import java.io.IOException;

public class FileDifferentiatorTestFakes {
    private final FileService fileService = FileService.getInstance();
    private final FilepathService filepathService = FilepathService.getInstance();
    private final String resultFakeStringTemplate = "It suppose to by %s , but actually is %s";

    @Test
    public void testFakeGif() throws IOException {
        String filepath = this.filepathService.getFilepathFromResources("fake.gif");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultFakeStringTemplate, SupportedFileTypes.gif, SupportedFileTypes.jpg), result);
    }

    @Test
    public void testFakeJpg() throws IOException {
        String filepath =  this.filepathService.getFilepathFromResources("fake.jpg");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultFakeStringTemplate, SupportedFileTypes.jpg, SupportedFileTypes.gif), result);
    }

    @Test
    public void testFakeTxt() throws IOException {
        String filepath =  this.filepathService.getFilepathFromResources("fake.txt");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultFakeStringTemplate, SupportedFileTypes.txt, SupportedFileTypes.gif), result);
    }
}
