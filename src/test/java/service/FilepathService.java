package service;

public class FilepathService {
    private static FilepathService instance;
    private final int filepathOffset = 1;

    private FilepathService() {}

    public static FilepathService getInstance() {
        if (instance == null)
            instance = new FilepathService();

        return instance;
    }

    public String getFilepathFromResources(String filename) {
        return getClass().getClassLoader().getResource(filename).getPath().substring(this.filepathOffset);
    }
}
