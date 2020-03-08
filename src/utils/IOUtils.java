package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public final class IOUtils {
	public static BufferedReader getFile(String fileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(fileName));
	}
}
