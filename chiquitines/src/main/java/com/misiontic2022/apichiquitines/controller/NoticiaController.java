package com.misiontic2022.apichiquitines.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;
import com.misiontic2022.apichiquitines.model.Noticia;
import com.misiontic2022.apichiquitines.service.NoticiaService;
import com.misiontic2022.apichiquitines.util.NoticiaUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	// Devuelve las imagenes al navegador
	private String FILE_PATH_ROOT = "C:/ChiquitinesResources/Noticias/";

	@GetMapping("getImg/{filename}")
	public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
		byte[] image = new byte[0];
		try {
			image = FileUtils.readFileToByteArray(new File(FILE_PATH_ROOT + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

	@RequestMapping(value = "/subir_noticia", method = RequestMethod.POST)
	public Noticia subirNoticia(@RequestParam("imagen") MultipartFile file,
			@RequestParam("noticia") String noticiaUtil) {
		NoticiaUtil n = new Gson().fromJson(noticiaUtil, NoticiaUtil.class);
		String titulo = n.getTituloNoticia();
		String fileName = noticiaService.obtenerNombre(file);
		List<Noticia> noticias = noticiaService.getNoticias();
		String numeroNoticia;
		if (noticias.size() == 0) {
			numeroNoticia = "1";
		} else {
			numeroNoticia = String.valueOf(noticias.get(noticias.size() - 1).getId() + 1);
		}
		

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("noticias/getImg/")
				.path(numeroNoticia + fileName).toUriString();
		Noticia noticia = new Noticia(titulo, numeroNoticia + fileName,
				new Date(System.currentTimeMillis()), fileDownloadUri, n.getDescripcion());
	
		
		noticiaService.guardarNoticia(file, noticia, numeroNoticia + fileName);
		return noticia;
	}

	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public List<Noticia> getNoticias() {
		return noticiaService.getNoticias();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteNoticia(@PathVariable("id") Integer id) throws IOException {

		Files.deleteIfExists(
				Paths.get("C:/ChiquitinesResources/Noticias/" + noticiaService.getNoticia(id).getNombreImagen()));
		this.noticiaService.deleteNoticia(id);
		return ResponseEntity.ok(new Gson().toJson("Noticia eliminada"));
	}

	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Noticia getNoticia(@PathVariable Integer id) {
		Noticia noticia = this.noticiaService.getNoticia(id);
		return noticia;
	}
}
