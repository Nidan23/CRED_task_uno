package service;

import domain.SupportedFileTypes;
import domain.TxtFileValues;

import java.io.*;

public class FileService {
    private static FileService instance;
    private final String extensionNotSupportedError = "Extension not supported";
    private final String extensionFakeError = "Extension is fake";
    private final String fileDoesNotExistsError = "File doesn't exists";

    private FileService() {}

    public static FileService getInstance() {
        if (instance == null)
            instance = new FileService();

        return instance;
    }

    public String validateFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists() || !file.isFile() || !file.canRead())
            throw new FileNotFoundException(fileDoesNotExistsError);

        String[] pathFragments = file.getPath().split("\\.");
        String extension = pathFragments[pathFragments.length - 1].toLowerCase();
        byte[] bytes = getBytes(file);

        if (bytes.length == 0)
            throw new RuntimeException(this.extensionFakeError);

        return validateFileExtension(extension, bytes);
    }

    private String validateFileExtension(String extension, byte[] bytes) {
        if (extension.equals(SupportedFileTypes.gif) && this.validateGifOrJpg(bytes, SupportedFileTypes.gifSignature))
            return this.extensionIsTrue(extension);

        if (extension.equals(SupportedFileTypes.jpg) && this.validateGifOrJpg(bytes, SupportedFileTypes.jpgSignature))
            return this.extensionIsTrue(extension);

        if (extension.equals(SupportedFileTypes.txt) && this.validateTxt(bytes))
            return this.extensionIsTrue(extension);

        return this.fileExtensionMismatch(bytes, extension);
    }

    private byte[] getBytes(File file) throws IOException {
        FileInputStream fileOutput = new FileInputStream(file);
        byte[] bytes = fileOutput.readAllBytes();
        fileOutput.close();

        return bytes;
    }

    private Boolean validateGifOrJpg(byte[] bytes, byte[] matchBytes) {
        for(int bt = 0; bt < matchBytes.length; bt++)
            if (bytes[bt] != matchBytes[bt])
                return false;

        return true;
    }

    private Boolean validateTxt(byte[] bytes) {
        for (byte aByte : bytes)
            if (isTxtByteLargerThanAllowedValue(aByte)
                || (isTxtByteInsideForbiddenRange(aByte)
                && !isTxtByteAllowedCharFromForbiddenRange(aByte)))
                return false;

        return true;
    }

    private Boolean isTxtByteLargerThanAllowedValue(byte aByte) {
        return aByte > TxtFileValues.maxTxtASCIIByteValue;
    }

    private Boolean isTxtByteInsideForbiddenRange(byte aByte) {
        return aByte >= TxtFileValues.forbiddenRangeBottom && aByte <= TxtFileValues.forbiddenRangeTop;
    }

    private Boolean isTxtByteAllowedCharFromForbiddenRange(byte aByte) {
        return aByte == TxtFileValues.tab || aByte == TxtFileValues.newLine || aByte == TxtFileValues.newLine2;
    }

    private String fileExtensionMismatch(byte[] bytes, String extension) {
        if (validateGifOrJpg(bytes, SupportedFileTypes.gifSignature) && !extension.equals(SupportedFileTypes.gif))
            return this.typeMismatchMessageGenerator(extension, SupportedFileTypes.gif);
        else if (validateGifOrJpg(bytes, SupportedFileTypes.jpgSignature) && !extension.equals(SupportedFileTypes.jpg))
            return this.typeMismatchMessageGenerator(extension, SupportedFileTypes.jpg);
        else if (validateTxt(bytes) && !extension.equals(SupportedFileTypes.txt))
            return this.typeMismatchMessageGenerator(extension, SupportedFileTypes.txt);
        else
            throw new RuntimeException(extensionNotSupportedError);
    }

    private String typeMismatchMessageGenerator(String fakeExtension, String trueExtension) {
        return String.format("It suppose to by %s , but actually is %s", fakeExtension, trueExtension);
    }

    private String extensionIsTrue(String extension) {
        return String.format("File has %s extension and really is %s", extension, extension);
    }
}
