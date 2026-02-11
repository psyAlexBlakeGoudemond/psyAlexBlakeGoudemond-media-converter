package za.co.psybergate.media_converter;

import com.github.kokorin.jaffree.ffmpeg.FFmpeg;
import com.github.kokorin.jaffree.ffmpeg.UrlInput;
import com.github.kokorin.jaffree.ffmpeg.UrlOutput;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class VideoToGifConverterTest {

    @Test
    public void convertVideoToGif() {
        Path videoPath = Path.of("src/test/resources/videos/quick-test.mp4");
        System.out.println("Files.exists(videoPath) = " + Files.exists(videoPath));
        Path gifPath = Path.of("src/test/resources/videos/quick-test.gif");
        FFmpeg.atPath()
                .addInput(UrlInput.fromPath(videoPath))
                .addOutput(
                        UrlOutput.toPath(gifPath)
                                .addArguments("-vf", "fps=15,scale=1280:-1:flags=lanczos")
                )
                .execute();

    }

}
