import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// @Author Hadesoverflow

public class WatermarkEmbedder {

    public static void addVisibleWatermark(String inputPath, String outputPath, String watermarkText) {
        try {
            File inputFile = new File(inputPath);
            BufferedImage image = ImageIO.read(inputFile);

            Graphics2D g2d = (Graphics2D) image.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // ====== Insert logo in the middle and larger ======
            addLogoWatermark(g2d, image, "logo/Hadesoverflow_Logo.png", 0.3f); // opacity 30%

            // ====== Insert watermark rotated -45 degrees ======
            Font font = new Font("Arial", Font.BOLD, 40);
            g2d.setFont(font);
            g2d.setColor(new Color(0, 0, 0, 60)); // matte black

            AffineTransform originalTransform = g2d.getTransform();
            AffineTransform rotateTransform = AffineTransform.getRotateInstance(
                    Math.toRadians(-45), 0, 0);
            g2d.setTransform(rotateTransform);

            int stepX = 400;
            int stepY = 250;

            for (int x = -image.getWidth(); x < image.getWidth() * 2; x += stepX) {
                for (int y = -image.getHeight(); y < image.getHeight() * 2; y += stepY) {
                    g2d.drawString(watermarkText, x, y);
                }
            }

            g2d.setTransform(originalTransform); // restore transform
            g2d.dispose();

            // ====== Save image in original format ======
            String format = outputPath.substring(outputPath.lastIndexOf('.') + 1);
            File outputFile = new File(outputPath);
            ImageIO.write(image, format, outputFile);

            System.out.println("Watermark inserted: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error inserting watermark: " + e.getMessage());
        }
    }

    public static void addLogoWatermark(Graphics2D g2d, BufferedImage image, String logoPath, float opacity) {
        try {
            BufferedImage logo = ImageIO.read(new File(logoPath));

            // Increase logo size to 40% of image width
            int scaledWidth = image.getWidth() * 7 / 10;
            int scaledHeight = logo.getHeight() * scaledWidth / logo.getWidth();
            Image scaledLogo = logo.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

            // Center the logo horizontally and vertically
            int x = (image.getWidth() - scaledWidth) / 2;
            int y = (image.getHeight() - scaledHeight) / 2;

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            g2d.drawImage(scaledLogo, x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); // restore opacity
        } catch (Exception e) {
            System.err.println("Error when inserting logo: " + e.getMessage());
        }
    }

    public static void processBatch(String inputFolder, String outputFolder, String watermarkText) {
        File folder = new File(inputFolder);
        File outDir = new File(outputFolder);
        if (!outDir.exists()) {
            outDir.mkdirs(); // create directory if not exist
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png")
                || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));

        if (files != null) {
            for (File file : files) {
                String outputPath = outputFolder + File.separator + file.getName();
                addVisibleWatermark(file.getAbsolutePath(), outputPath, watermarkText);
            }
        }
    }
}
