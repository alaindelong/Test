package com.example.demo.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class FileWS {

	@RequestMapping(value="/download", method=RequestMethod.GET)
	
	public StreamingResponseBody  getFile(HttpServletResponse response) throws IOException{
		
		response.setContentType("application/txt");
        response.setHeader("Content-Disposition", "attachment; filename=\"demo.txt\"");
		InputStream is = new FileInputStream(new File("E:\\PARISTECH\\PERIODE2\\Test\\test.txt"));
		return os->{
			int nRead;
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
			os.write(data,0,nRead);}
		};
	}
}
