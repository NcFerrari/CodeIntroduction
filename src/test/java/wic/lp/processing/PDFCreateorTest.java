package wic.lp.processing;

import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class PDFCreateorTest {
    private final PDFCreateor pdfCreateor = new PDFCreateor();
    private final File basicFile = new File("test.pdf");

    @AfterEach
    void tearDown() throws IOException {
//        Files.delete(basicFile.toPath());
    }

    @Test
    void createSimpleDocument() throws IOException, DocumentException, URISyntaxException {
        pdfCreateor.createSimpleDocument();
        assertThat(basicFile.exists());
    }

}