package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.services.FileStorageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    Path originalPath = Paths.get("").toAbsolutePath().getParent().resolve("Images");

    @Override
    public String uploadFile(MultipartFile file,String pathFolder){

        String path = originalPath.resolve(pathFolder).toString();
        System.out.println(path);


        boolean isExit = new File(path).exists();
        if (!isExit) {
            new File (path).mkdirs();
            System.out.println("mk dir.............");
        }

        String filename = file.getOriginalFilename();
        String newFileName;
        newFileName = FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (path+File.separator+newFileName);
        System.out.println(newFileName);
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }

        return  newFileName;
    }


    @Override
    public String loadFile(String pathFile){

        String pathFolder = originalPath.resolve(pathFile).getParent().toString();
        String path = originalPath.resolve(pathFile).toString();

        boolean isExit = new File(pathFolder).exists();
        if (!isExit) {
            new File (pathFolder).mkdirs();
            System.out.println("mk dir.............");
        }

        File file = new File(path);

        String image = null;

        try {
            String extension = FilenameUtils.getExtension(file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStream.read(bytes);
            String encodeBase64 = Base64.getEncoder().encodeToString(bytes);
            image = "data:image/"+extension+";base64,"+encodeBase64;
            fileInputStream.close();
        }
        catch (Exception e){
            System.out.println("download failed!!");
        }

        return image;
    }

    @Override
    public void deleteFile(String pathFile){
         Path path = originalPath.resolve(pathFile);

        try {
            // Delete file or directory
            Files.delete(path);
            System.out.println("File or directory deleted successfully");
        } catch (IOException ex) {
            System.out.println("No such file or directory: "+ path);

        }
    }

}
