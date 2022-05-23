package com.springboot.aristo.app.controller;

import com.springboot.aristo.app.util.FileUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
//@CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin() // open for all ports
public class MultipleFilesUploadController {


    /**
     * Method to upload multiple files
     * @param files
     * @return FileResponse
     */
    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("userid") int userid) {
        try {
            createDirIfNotExist();

            List<String> fileNames = new ArrayList<>();

            // read and write the file to the local folder
            Arrays.asList(files).stream().forEach(file -> {
                byte[] bytes = new byte[0];
                try {
                    bytes = file.getBytes();
                    Files.write(Paths.get(FileUtil.folderPath + userid+"-"+file.getOriginalFilename()), bytes);
                    fileNames.add(file.getOriginalFilename());
                } catch (IOException e) {

                }
            });

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new FileUploadResponse("Files uploaded successfully: " + fileNames));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new FileUploadResponse("Exception to upload files!"));
        }
    }

    /**
     * Create directory to save files, if not exist
     */
    private void createDirIfNotExist() {
        //create directory to save the files
        File directory = new File(FileUtil.folderPath);
        if (! directory.exists()){
            directory.mkdir();
        }
    }

    /**
     * Method to get the list of files from the file storage folder.
     * @return file
     */
    @GetMapping("/files")
    public ResponseEntity<String[]> getListFiles(@RequestParam("userid") int userid) {
    	
    	File dir = new File(FileUtil.folderPath);
    	File[] files = dir.listFiles(new FilenameFilter() {
    	    public boolean accept(File dir, String name) {
    	        return name.toLowerCase().startsWith(String.valueOf(userid));
    	    }
    	});
    	
    	String a[] = new String[files.length];
    	
    	for(int i=0; i<files.length;i++)
    	{
    		a[i]=files[i].getName();
    	}
    	
        //return ResponseEntity.status(HttpStatus.OK).body( new File(FileUtil.folderPath).list());
        
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }

}
