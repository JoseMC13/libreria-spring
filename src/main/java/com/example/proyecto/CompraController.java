package com.example.proyecto;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class CompraController {

    @PostMapping("/compra/comprobante")
    public ResponseEntity<byte[]> generarComprobante(@RequestBody CompraRequest request) throws IOException {
        List<CompraItem> items = request == null ? List.of() : request.getItems();
        if (items == null) {
            items = List.of();
        }

        byte[] pdfBytes = crearPdf(items);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"comprobante.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    private byte[] crearPdf(List<CompraItem> items) throws IOException {
        try (PDDocument document = new PDDocument(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                float margin = 50f;
                float y = page.getMediaBox().getHeight() - margin;
                float leading = 16f;

                content.setFont(PDType1Font.HELVETICA_BOLD, 16);
                y = escribirLinea(content, "Comprobante de compra", margin, y, leading);

                content.setFont(PDType1Font.HELVETICA, 11);
                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                y = escribirLinea(content, "Fecha: " + fecha, margin, y, leading);
                y = escribirLinea(content, "", margin, y, leading);

                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                y = escribirLinea(content, "Detalle de libros:", margin, y, leading);
                content.setFont(PDType1Font.HELVETICA, 11);

                BigDecimal total = BigDecimal.ZERO;
                if (items.isEmpty()) {
                    y = escribirLinea(content, "No hay libros en la compra.", margin, y, leading);
                } else {
                    for (CompraItem item : items) {
                        String titulo = item.getTitulo() == null ? "" : item.getTitulo();
                        int cantidad = Math.max(0, item.getCantidad());
                        BigDecimal precio = BigDecimal.valueOf(item.getPrecioUnitario());
                        BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(cantidad));
                        total = total.add(subtotal);

                        String linea = "- " + titulo + " | Cantidad: " + cantidad +
                                " | Precio: $" + precio.setScale(2, RoundingMode.HALF_UP) +
                                " | Subtotal: $" + subtotal.setScale(2, RoundingMode.HALF_UP);
                        y = escribirLinea(content, linea, margin, y, leading);
                    }
                }

                y = escribirLinea(content, "", margin, y, leading);
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                escribirLinea(content, "Total: $" + total.setScale(2, RoundingMode.HALF_UP), margin, y, leading);
            }

            document.save(out);
            return out.toByteArray();
        }
    }

    private float escribirLinea(PDPageContentStream content, String texto, float x, float y, float leading) throws IOException {
        content.beginText();
        content.newLineAtOffset(x, y);
        content.showText(texto);
        content.endText();
        return y - leading;
    }
}
