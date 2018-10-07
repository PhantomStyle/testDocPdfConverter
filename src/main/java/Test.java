import fr.opensagres.xdocreport.converter.*;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, XDocReportException {
        // 1) Create options ODT 2 PDF to select well converter form the registry
        Options options = Options.getFrom(DocumentKind.DOCX).to(ConverterTypeTo.PDF);

// 2) Get the converter from the registry
        IConverter converter = ConverterRegistry.getRegistry().getConverter(options);

// 3) Convert ODT 2 PDF
        InputStream in= new FileInputStream(new File("E:\\FOR_WORK\\Программирование\\Java\\testXdocreport\\src\\main\\resources\\ODTHelloWord.docx"));
        File file = new File("E:\\FOR_WORK\\Программирование\\Java\\testXdocreport\\src\\main\\resources\\ODTHelloWord2PDF.pdf");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
        converter.convert(in, out, options);

        // 1) Load ODT file and set Velocity template engine and cache it to the registry
//        InputStream in= new FileInputStream(new File("E:\\FOR_WORK\\Программирование\\Java\\testXdocreport\\src\\main\\resources\\ODTHelloWord.docx"));
//        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
//
//// 2) Create Java model context
//        IContext context = report.createContext();
//        context.put("name", "world");
//
//// 3) Generate report by merging Java model with the ODT
//        OutputStream out = new FileOutputStream(new File("ODTHelloWordWithVelocity_Out.docx"));
//        report.process(context, out);
    }
}
