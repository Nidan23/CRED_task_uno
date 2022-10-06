import org.junit.Assert;
import org.junit.Test;
import service.FileService;
import service.FilepathService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDifferentiatorTestExceptions {
    private final FileService fileService = FileService.getInstance();
    private final FilepathService filepathService = FilepathService.getInstance();
    private final String extensionNotSupportedError = "Extension not supported";
    private final String extensionFakeError = "Extension is fake";
    private final String fileDoesNotExistsError = "File doesn't exists";

    @Test
    public void testNotExistingFile() throws IOException {
        String filepath = "C:/Blebleble/ble.txt";

        try {
            this.fileService.validateFile(filepath);
        } catch (FileNotFoundException e) {
            Assert.assertEquals(this.fileDoesNotExistsError, e.getMessage());
        }
    }

    @Test
    public void testFakeExtension() throws IOException {
        String filepath = this.filepathService.getFilepathFromResources("fake-extension.gif");

        try {
            this.fileService.validateFile(filepath);
        } catch (RuntimeException e) {
            Assert.assertEquals(this.extensionFakeError, e.getMessage());
        }
    }

    @Test
    public void testFakeNotSupportedExtension() throws IOException {
        String filepath = this.filepathService.getFilepathFromResources("notsupported.tdd");

        try {
            this.fileService.validateFile(filepath);
        } catch (RuntimeException e) {
            Assert.assertEquals(this.extensionNotSupportedError, e.getMessage());
        }
    }
}
