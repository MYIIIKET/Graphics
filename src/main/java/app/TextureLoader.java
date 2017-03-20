package app;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import static org.lwjgl.opengl.GL11.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL12;

import static org.lwjgl.opengl.GL11.*;

public class TextureLoader {
    private ByteBuffer buffer;
    private BufferedImage bufferedImage;
    private static final int BYTES_PER_PIXEL = 4;

    private static BufferedImage loadImage(String path) throws IOException {
        File imageFile = new File(path);
        if (!imageFile.exists() || imageFile.isDirectory())
            throw new FileNotFoundException();
        else
            return ImageIO.read(imageFile);
    }


    public int loadTexture(String path) throws IOException {

        BufferedImage bufferedImage = loadImage(path);

        int[] pixels = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];

        bufferedImage.getRGB(0, 0, bufferedImage.getWidth(),
                bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
        ByteBuffer buffer = getColorData(bufferedImage, pixels);
        this.buffer = buffer;
        this.bufferedImage = bufferedImage;


        int textureID = glGenTextures();

        return textureID;
    }

    private static ByteBuffer getColorData(BufferedImage bufferedImage, int[] pixels) {

        ByteBuffer buffer = BufferUtils.createByteBuffer(bufferedImage.getWidth() *
                bufferedImage.getHeight() * BYTES_PER_PIXEL);

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                int pixel = pixels[y * bufferedImage.getWidth() + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) (pixel & 0xFF));
                buffer.put((byte) ((pixel >> 24) & 0xFF));
            }
        }

        buffer.flip();
        return buffer;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
