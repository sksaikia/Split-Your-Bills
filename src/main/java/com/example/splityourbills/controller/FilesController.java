package com.example.splityourbills.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.example.splityourbills.dto.imageupload.FileInfo;
import com.example.splityourbills.response.imageupload.ImageUploadResponse;
import com.example.splityourbills.security.CurrentUser;
import com.example.splityourbills.security.UserPrincipal;
import com.example.splityourbills.service.implementation.UserServiceImpl;
import com.example.splityourbills.service.interfaces.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class FilesController {

    @Autowired
    FilesStorageService storageService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/upload")
    public ResponseEntity<ImageUploadResponse> uploadFile(@RequestParam("file") MultipartFile file,
                                                          @CurrentUser UserPrincipal currentUser) {
        String message = "";
        try {
            String url =  storageService.save(file,currentUser.getId());

            message = "Uploaded the file successfully: ";

            userService.updateProfilePicture(url,currentUser);

            return ResponseEntity.status(HttpStatus.OK).body(new ImageUploadResponse(message,url));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ImageUploadResponse(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            String[] fileNamesString = filename.split("\\.");
            String userId = fileNamesString[0];
            return new FileInfo(filename, url,userId);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
