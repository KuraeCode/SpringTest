package anotherconfstyle;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

/**
 * Created by artmaster on 17.05.2017.
 */
public class DestructiveBean {

    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:anotherconfstyle/META-INF/app-context-destroy-xml.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destrBean");
    /*    System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");*/
    }
}
