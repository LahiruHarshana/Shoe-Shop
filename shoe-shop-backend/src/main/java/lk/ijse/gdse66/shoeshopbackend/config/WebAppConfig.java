package lk.ijse.gdse66.shoeshopbackend.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * @author : L.H.J
 * @File: WebAppConfig
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/

@Configuration
public class WebAppConfig {
    @Bean
    public ModelMapper test() {
        return new ModelMapper();
    }
    @Bean
    public Drive driveService() throws IOException, GeneralSecurityException {
        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(getPathToGoodleCredentials()))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                credential)
                .build();
    }

    private static String getPathToGoodleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("CURRENT DIRECTORY: " + currentDirectory);
        Path filePath = Paths.get(currentDirectory, "/upload.json");
        System.out.println("FILE PATH: " + filePath.toString());
        return filePath.toString();
    }
}
