package com.misiontic2022.apichiquitines.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.misiontic2022.apichiquitines.model.Recurso;
import com.misiontic2022.apichiquitines.repository.RecursoRepository;
import com.misiontic2022.apichiquitines.util.FileStorageException;
import com.misiontic2022.apichiquitines.util.RecursosFileStorageProperties;
import com.misiontic2022.apichiquitines.util.MyFileNotFoundException;

//Completar servicio
@Service
public class RecursoService {
	private final Path fileStorageLocation;
	@Autowired
	private RecursoRepository recursoRepository;

	@Autowired
	public RecursoService(RecursosFileStorageProperties recursoStorageProperties) {
		this.fileStorageLocation = Paths.get(recursoStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		
	
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public List<Recurso> getRecursos() {
		List<Recurso> recursos = recursoRepository.findAll();
		return recursos;
	}
	

	public String obtenerNombre(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		return fileName;
	}

	public void guardarRecurso(MultipartFile file, Recurso recurso, String name) {
		// Normalize file name
		String fileName = name;

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			System.out.println(targetLocation);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			// Se guardan las caracteristicas del recurso en la BD
			recursoRepository.save(recurso);

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public void deleteRecurso(Integer id) {
		this.recursoRepository.deleteById(id);
	}

	public Recurso getRecurso(Integer id) {
		Optional<Recurso> recurso = this.recursoRepository.findById(id);
		if (recurso.isPresent()) {
			return recurso.get();
		} else {
			return null;
		}
	}

	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}
}
