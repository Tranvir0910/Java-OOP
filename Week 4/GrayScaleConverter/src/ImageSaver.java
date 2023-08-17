import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

public class ImageSaver {
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        ImageMakeGray img = new ImageMakeGray();
        for(File f : dr.selectedFiles()) {
            ImageResource ir = new ImageResource(f);
            String fname = ir.getFileName();
            String newName = "copy-" + fname;
            ImageResource gray = img.makeGray(ir);
            ir.setFileName(fname);
            gray.draw();
            ir.save();
        }
    }
}
