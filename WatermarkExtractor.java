import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// @Author Hadesoverflow

public class WatermarkExtractor {

    public static String extractWatermark(BufferedImage image, int length) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] watermarkBits = new int[length * 8];
        int bitIndex = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int blue = rgb & 0xFF;

                if (bitIndex < watermarkBits.length) {
                    watermarkBits[bitIndex] = blue & 1;
                    bitIndex++;
                }
            }
        }

        byte[] watermarkBytes = new byte[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 8; j++) {
                watermarkBytes[i] = (byte) ((watermarkBytes[i] << 1) | watermarkBits[i * 8 + j]);
            }
        }

        return new String(watermarkBytes);
    }

    public static void extractFromBatch(String inputFolder, int watermarkLength) {
        File inputDir = new File(inputFolder);
        File[] imageFiles = inputDir.listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg"));

        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                try {
                    BufferedImage image = ImageIO.read(imageFile);
                    String extractedWatermark = extractWatermark(image, watermarkLength);

                    System.out.println("Extracted Watermark from " + imageFile.getName() + ": " + extractedWatermark);

                } catch (Exception e) {
                    System.out.println("Error processing: " + imageFile.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}
