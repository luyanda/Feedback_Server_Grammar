package ava.Files.Source;//package ava.Files.Source;

import java.io.IOException;

public class Testing{
	public static void main(String []args) throws IOException, InterruptedException {
		String script = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/Files/Source/compile.sh";
		ProcessBuilder processBuilder = new ProcessBuilder(script);
		Process process = processBuilder.start();
	}
}
