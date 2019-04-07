import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class generar_pdf {
	public generar_pdf() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("main");
		try {
			Document d = new Document( PageSize.LETTER );
			PdfWriter w = PdfWriter.getInstance( d , new FileOutputStream("salida.pdf") );
			d.setMargins( 72f , 72f, 72f, 72f);
			d.open();
			d.add( new Paragraph("Mensaje en PDF") );
			d.add( new Paragraph("Otro Mensaje"));
			d.close();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}