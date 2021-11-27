package com.misiontic2022.apichiquitines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.misiontic2022.apichiquitines.util.NoticiaUtil;
import com.misiontic2022.apichiquitines.util.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class,
    NoticiaUtil.class
})
public class ChiquitinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChiquitinesApplication.class, args);
	}

}
