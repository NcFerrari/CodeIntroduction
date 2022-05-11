package wic.lp.processing;

import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PDFCreateorTest {
    private final PDFCreateor pdfCreateor = new PDFCreateor();

    @Test
    void createSimpleDocument() throws FileNotFoundException, DocumentException {
        pdfCreateor.createSimpleDocument();
    }

}