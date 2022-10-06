import service.FileService;

import java.io.IOException;
import java.util.Scanner;

public class FileDifferentiator {
    private static final FileService fileService = FileService.getInstance();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your file path");
        String filePath = scanner.nextLine();
        System.out.println(FileDifferentiator.fileService.validateFile(filePath));
    }
}
