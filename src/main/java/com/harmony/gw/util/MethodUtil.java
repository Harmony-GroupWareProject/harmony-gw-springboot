package com.harmony.gw.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

public class MethodUtil {

	 public static String readHtmlFileToString(String fileName) throws IOException {
	        // 리소스 폴더의 data/html 디렉토리에 있는 파일 경로 설정
	        ClassPathResource resource = new ClassPathResource("data/documenttemplate/" + fileName + ".html");
	        Path path = Paths.get(resource.getURI());
	        // 파일을 읽어서 문자열로 변환
	        return new String(Files.readAllBytes(path));
	    }
}
