package de.cassini.ecms.java8.tryWithResource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TryWithResourceSample {
	

	public static void main(String[] args) throws IOException {
		
		Path path1 = createTempFile();
		autoclosing(path1);

		Path path2 = createTempFile();
		manualclosing(path2);

		Path path3 = createTempFile();
		newWrite(path3);
		
		path1.toFile().deleteOnExit();
		path2.toFile().deleteOnExit();
		path3.toFile().deleteOnExit();

	}
	
	private static void autoclosing(Path path) {
		

		try ( FileOutputStream out = new FileOutputStream(path.toFile()) ) {
			
			out.write("Hello World".getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void manualclosing(Path path) {
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(path.toFile());
			out.write("Hello World".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( out != null ) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void newWrite(Path path) {
		
		try {
			Files.write(path, "Hello World!".getBytes(), StandardOpenOption.WRITE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Path createTempFile() throws IOException {
		
		final Path path = Files.createTempFile("nio-temp", ".tmp");
		System.out.printf("Tempfile created at %s.%n", path);
		return path;
		
	}
	
	
}
