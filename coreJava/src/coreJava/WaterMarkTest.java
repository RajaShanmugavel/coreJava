package coreJava;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class WaterMarkTest {

    public static void main(String args[]) throws Exception {

        PdfReader reader = new PdfReader("E:\\Raja\\pdftest\\Raja_Resume.pdf");

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("E:\\Raja\\pdftest\\AddedWaterMark.pdf"));

        waterMarkImage("This is watermark");

       for(int i=1;i<=reader.getNumberOfPages();i++) {
           PdfContentByte content = stamper.getUnderContent(i);
           Image image = Image.getInstance(waterMarkImage("WaterMark...."));
           image.setAbsolutePosition(150f, 750f);
           content.addImage(image);
       }
       stamper.close();
    }

    private static byte[] waterMarkImage(String text) throws Exception {
        BufferedImage bufferedImage = new BufferedImage(170, 30,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 200, 50);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
        graphics.drawString(text, 10, 25);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return baos.toByteArray();

    }
}
