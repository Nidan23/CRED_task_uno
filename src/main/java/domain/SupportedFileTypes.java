package domain;

import java.util.HexFormat;

public class SupportedFileTypes {
    public static String gif = "gif";
    public static String jpg = "jpg";
    public static String txt = "txt";

    public static byte[] gifSignature = HexFormat.of().parseHex("474946383961");
    public static byte[] jpgSignature = HexFormat.of().parseHex("FFD8FFE000104A4649460001");
}
