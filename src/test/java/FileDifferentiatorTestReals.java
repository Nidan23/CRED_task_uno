import domain.SupportedFileTypes;
import org.junit.Test;
import org.junit.Assert;
import service.FileService;
import service.FilepathService;

import java.io.IOException;

public class FileDifferentiatorTestReals {
    private final FileService fileService = FileService.getInstance();
    private final FilepathService filepathService = FilepathService.getInstance();
    private final String resultTrueStringTemplate = "File has %s extension and really is %s";

    @Test
    public void testRealGif() throws IOException {
        String filepath =  this.filepathService.getFilepathFromResources("true.gif");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultTrueStringTemplate, SupportedFileTypes.gif, SupportedFileTypes.gif), result);
    }

    @Test
    public void testRealJpg() throws IOException {
        String filepath = this.filepathService.getFilepathFromResources("true.jpg");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultTrueStringTemplate, SupportedFileTypes.jpg, SupportedFileTypes.jpg), result);
    }

    @Test
    public void testRealTxt() throws IOException {
        String filepath = this.filepathService.getFilepathFromResources("true.txt");
        String result = this.fileService.validateFile(filepath);

        Assert.assertEquals(String.format(this.resultTrueStringTemplate, SupportedFileTypes.txt, SupportedFileTypes.txt), result);
    }
}
