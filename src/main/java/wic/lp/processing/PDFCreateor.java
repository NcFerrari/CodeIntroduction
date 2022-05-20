package wic.lp.processing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.XMLResource;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class PDFCreateor {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
//    private final Document document = new Document();
    private boolean bodyContent = false;
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================
    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================
    public void createSimpleDocument() throws IOException, URISyntaxException {

        try {
            URLConnection connection = new URL("https://translate.google.cz/?hl=cs").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 " +
                    "(KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    Charset.forName("Windows-1250")));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = r.readLine()) != null) {
                sb.append(line + "\n");
            }
            File file = new File("test.html");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        File inputHTML = new File("test.html");
        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        try (OutputStream outputStream = new FileOutputStream("test.pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(document.html());
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
