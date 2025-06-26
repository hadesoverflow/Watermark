public class Main {
    public static void main(String[] args) {
        String inputFolder = "input_images";
        String outputFolder = "output_images";
        String watermarkText = "hadesoverflow";

        WatermarkEmbedder.processBatch(inputFolder, outputFolder, watermarkText);
    }
}
