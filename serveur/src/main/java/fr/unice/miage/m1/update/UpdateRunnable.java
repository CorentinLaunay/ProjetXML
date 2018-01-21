package fr.unice.miage.m1.update;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Calendar;

public class UpdateRunnable implements Runnable {
	/**
	 * Check if xsd path exists create if not
	 * @return true/false create ok
	 */
	private synchronized boolean checkXSDRepository() {
		File repository = new File("src/main/resources/xsd");
		return repository.exists() || repository.mkdirs();
	}

	@Override
	public synchronized void run() {
		try {
			if(!this.checkXSDRepository()){
				throw new Exception("Unable to create xsd repository");
			}

			String bastriXsdPath = "src/main/resources/xsd/bastri.xsd";
			String bastriCrisXsdPath = "src/main/resources/xsd/bastriCris.xsd";

			File bastri = new File(bastriXsdPath);
			File bastriCris = new File(bastriCrisXsdPath);

			Calendar cal = Calendar.getInstance();

			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);

			if (!bastri.exists() || !bastriCris.exists() || (hour == 8 && minute == 59)) {
				Thread.sleep((long) (60000));
				this.updateBastri("http://www-sop.inria.fr/members/Philippe.Poulard/projet/2017/bastri.xsd", bastriXsdPath);
				this.updateBastri("http://www-sop.inria.fr/members/Philippe.Poulard/projet/2017/bastriCris.xsd", bastriCrisXsdPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get current xsd on server
	 * @param url xsd url
	 * @param xsdPath xsd local path
	 * @throws IOException local xsd not found
	 */
	private synchronized void updateBastri(String url, String xsdPath) throws IOException {
		ReadableByteChannel input = Channels.newChannel(new URL(url).openStream());
		FileOutputStream output = new FileOutputStream(xsdPath);

		FileChannel channel = output.getChannel();
		channel.transferFrom(input, 0, Long.MAX_VALUE);

		output.close();
		System.out.println(xsdPath + " updated");
	}

}
