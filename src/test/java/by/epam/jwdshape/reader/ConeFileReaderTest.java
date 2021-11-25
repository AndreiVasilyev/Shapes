package by.epam.jwdshape.reader;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.reader.impl.ConeFileReader;

public class ConeFileReaderTest {

	private ShapeReader reader;

	@BeforeClass
	public void setupReader() {
		reader = new ConeFileReader();
	}

	@Test(expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "There is no file path to read data")
	public void testNullPathSourse() throws ConeException {
		reader.readLines(null);
	}

	@Test(expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "There is no file path to read data")
	public void testBlankPathSource() throws ConeException {
		reader.readLines("");
	}

	@Test(expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "Error when reading file with source data.*")
	public void testWrongPathSource() throws ConeException {
		reader.readLines("/source");
	}

	@Test
	public void testReadDataFromFile() throws ConeException {
		String path = ConeFileReaderTest.class.getResource("/data/cones.txt").getPath();
		path = path.substring(1);
		List<String> actualLinesList = reader.readLines(path);
		List<String> expectedLinesList = List.of("1 2 3 5 6", "1.5 2.4 1.4 5.5 6.6", "8 5 9 8.4 11", " 84 54 1.2 23 58",
				"-45 52 -8 5.5 87", "0 0 0 0 0", " 0 0 0 3 3", "1001 52 85 84 52");
		assertEquals(actualLinesList, expectedLinesList);
	}

}

