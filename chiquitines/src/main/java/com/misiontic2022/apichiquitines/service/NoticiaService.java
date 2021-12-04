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
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.misiontic2022.apichiquitines.model.Noticia;
import com.misiontic2022.apichiquitines.repository.NoticiaRepository;
import com.misiontic2022.apichiquitines.util.FileStorageException;
import com.misiontic2022.apichiquitines.util.MyFileNotFoundException;
import com.misiontic2022.apichiquitines.util.NoticiasFileStorageProperties;

@Service
public class NoticiaService {
  private final Path fileStorageLocation;
	@Autowired
	private NoticiaRepository noticiaRepository;

	@Autowired
	public NoticiaService(NoticiasFileStorageProperties noticiaStorageProperties) {
		this.fileStorageLocation = Paths.get(noticiaStorageProperties.getUploadDir()).normalize();
		
		

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public List<Noticia> getNoticias() {
		List<Noticia> noticias = noticiaRepository.findAll();
		return noticias;
	}
	

	public String obtenerNombre(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		return fileName;
	}

	public void guardarNoticia(MultipartFile file, Noticia noticia, String name) {
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
			noticiaRepository.save(noticia);

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public void deleteNoticia(Integer id) {
		this.noticiaRepository.deleteById(id);
	}

	public Noticia getNoticia(Integer id) {
		Optional<Noticia> noticia = this.noticiaRepository.findById(id);
		if (noticia.isPresent()) {
			return noticia.get();
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
