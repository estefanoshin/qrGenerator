package qr;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.glxn.qrgen.javase.QRCode;

public final class Main {
	
	private static final String extension = "png";
	private static final String fileLocation = "/qrCode." + extension;

	public static void main(String[] args) {
		generateQRCodeImage(args[0]);
	}

	private static void generateQRCodeImage(String barcodeText) {
		try {
			ByteArrayOutputStream stream = QRCode.from(barcodeText)
				.withSize(150, 150)
				.stream();
			ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
			BufferedImage img = ImageIO.read(bis);
			File file = new File(fileLocation);
			ImageIO.write(img, extension, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
