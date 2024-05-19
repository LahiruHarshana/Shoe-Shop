package lk.ijse.gdse66.shoeshopbackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : L.H.J
 * @File: UploadService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface UploadService {
    String uploadFile(MultipartFile file) throws IOException;
}
