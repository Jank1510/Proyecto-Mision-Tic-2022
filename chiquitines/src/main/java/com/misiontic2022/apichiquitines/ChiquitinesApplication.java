package com.misiontic2022.apichiquitines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.misiontic2022.apichiquitines.util.NoticiasFileStorageProperties;
import com.misiontic2022.apichiquitines.util.RecursosFileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({NoticiasFileStorageProperties.class, RecursosFileStorageProperties.class })
public class ChiquitinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChiquitinesApplication.class, args);
	}

	

}
