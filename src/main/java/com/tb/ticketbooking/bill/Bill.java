package com.tb.ticketbooking.bill;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tb.ticketbooking.models.model.Seat;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Bill {
    public static void createBill(ArrayList<Seat> data, String flight) {
        Document document = new Document();
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("E:\\University\\Programming\\JavaDirectory\\TicketBookingJEE\\src\\main\\resources\\billConfig.properties"));
            PdfWriter.getInstance(document, new FileOutputStream(properties.getProperty("path")));

            document.open();

            PdfPTable table = new PdfPTable(3);

            Paragraph paragraphHeader = new Paragraph(billHead(flight));

            paragraphHeader.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraphHeader);


            table.addCell("Seat number");
            table.addCell("Class");
            table.addCell("Price");

            for (int i = 0; i < data.size(); i++) {
                table.addCell(data.get(i).getSeat_number());
                table.addCell(data.get(i).getsClass());
                table.addCell(data.get(i).getPrice());
            }

            document.add(table);

            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }


    private static String billHead(String root) {
        StringBuffer result = new StringBuffer();

        result
                .append("WELCOME, TODAY ")
                .append(new Date())
                .append("\n Your Root: ")
                .append(root);

        return result.toString();
    }
}
