package hp.test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
@WebServlet(name="upload",urlPatterns="/upload")
public class uploadServlet extends HttpServlet {
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		//�ļ��洢·��
		String path=this.getServletContext().getRealPath("/WEB-INF/upload");
		//��ʱ�ļ��洢·��
		String tempPath=this.getServletContext().getRealPath("/WEB-INF/temp");
		File file=new File(path);
		File temp=new File(tempPath);
		//���Ŀ¼�����ھʹ���
		if(!file.exists() && !file.isDirectory()){
			file.mkdirs();
		}
		//���Ŀ¼�����ھʹ���
		if(!temp.exists() && !temp.isDirectory()){
			file.mkdirs();
		}
		
		//��������Ƿ���Multipart������
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//���û�������С�����ϴ��ļ�������������Сʱ��ͻ�洢����ʱ�ļ���,������Ĭ�ϴ�С��10kb
			factory.setSizeThreshold(1024*100);//���û�����Ϊ100kb
			//������ʱ�ļ�����Ŀ¼
			factory.setRepository(temp);
			ServletFileUpload upload=new ServletFileUpload(factory);
			 //����ϴ��ļ������ģ�����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			//�����ϴ��ļ�����
			upload.setProgressListener(new ProgressListener (){
				@Override
				public void update(long arg0, long arg1, int arg2) {
					System.out.println("��ǰ�Ѿ��ϴ�"+arg0);
					System.out.println("�ܴ�С"+arg1);
				}
			});
			//�����ϴ�һ���ļ����������
			upload.setFileSizeMax(1024*1000);
			//�����ϴ��ļ���������
			upload.setSizeMax(1024*1000*10);
			List<FileItem> list=null;
			try {
				list=upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			//ÿ��item��Ӧ����һ��,��������ÿһ��
			for(FileItem item:list){
				//��鵱ǰ��Ŀ����ͨ����Ŀ�����ϴ��ļ���
				if(item.isFormField()){
					//��nameֵ
					String name=item.getFieldName();
					System.out.println(name);
					//��valueֵ
					System.out.println(item.getString("UTF-8"));
					
				}else{
					//
					//�ϴ��ļ����ļ�����
					String fileName=item.getName();
					//System.out.println(fileName);
					//ȥ���ļ�·����ȡ���ļ���
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					System.out.println(fileName);
					//��ȡ�ļ�����չ��
					String fileExt=fileName.substring(fileName.lastIndexOf(".")+1);
					System.out.println(fileExt);
					//����Ψһ���ļ���
					String trueName=UUID.randomUUID().toString()+fileName;
					System.out.println(trueName);
					
					InputStream is=item.getInputStream();
					System.out.println(path+File.separator+fileName);
					OutputStream os=new FileOutputStream(path+File.separator+trueName);
					byte[] flush=new byte[1024];
					int len=0;
					while( (len=is.read())!=-1 ){
						os.write(len);
					}
					os.flush();
					os.close();
					is.close();
					item.delete();
					
				}
			}
			
		}else{
			System.out.println("û������multipart/form-data");
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}