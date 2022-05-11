package wic.lp.processing;

import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PDFCreateorTest {
    private final PDFCreateor pdfCreateor = new PDFCreateor();
    private final File basicFile = new File("test.pdf");

    @AfterEach
    void tearDown() {
        if (basicFile.exists()) {
            basicFile.delete();
        }
    }

    @Test
    void createSimpleDocument() throws FileNotFoundException, DocumentException {
        pdfCreateor.createSimpleDocument();
        assertThat(basicFile.exists());
    }

}