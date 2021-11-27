package com.misiontic2022.apichiquitines.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.misiontic2022.apichiquitines.service.RecursoService;
import com.misiontic2022.apichiquitines.util.RecursoUtil;
//Completar controlador

@RestController
@RequestMapping("/recursos")
public class RecursoController {

	private static final Logger logger = LoggerFactory.getLogger(RecursoController.class);
		
	@Autowired
	private RecursoService recursoService;

	@PostMapping("/subirArchivo")
	public RecursoUtil uploadFile(@RequestParam("file") MultipartFile file) {
		
		String fileName = recursoService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

		return new RecursoUtil(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

}
