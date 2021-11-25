package com.misiontic2022.apichiquitines.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.filedemo.payload.UploadFileResponse;
import com.misiontic2022.apichiquitines.service.RecursoService;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

	private static final Logger logger = LoggerFactory.getLogger(RecursoController.class);

	@Autowired
	private RecursoService recursoService;
	
	@PostMapping("/subirArchivo")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

}
