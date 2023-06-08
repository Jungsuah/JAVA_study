package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 파일 업로드를 처리하는 로직
        String uploadDirectory = "/path/to/upload/directory"; // 업로드된 파일을 저장할 디렉토리 경로
        Part filePart = request.getPart("stockImage"); // 업로드된 파일의 Part 객체
        String fileName = filePart.getSubmittedFileName(); // 업로드된 파일의 이름

        // 디렉토리가 존재하지 않으면 생성
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 파일을 지정된 디렉토리에 저장
        String filePath = uploadDirectory + File.separator + fileName;
        filePart.write(filePath);

        // 파일 업로드 완료 후 다음 작업을 수행하거나 응답을 처리할 수 있습니다.
        // 예를 들어, 업로드된 파일의 경로를 데이터베이스에 저장하거나 응답 페이지로 이동하는 등의 작업을 수행할 수 있습니다.
        // ...

        response.sendRedirect("upload_success.jsp"); // 파일 업로드가 성공적으로 완료된 후의 페이지로 이동
    }
}
